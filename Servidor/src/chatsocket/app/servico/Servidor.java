package chatsocket.app.servico;

import chatsocket.app.util.ServidorUtilImpl;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import chatsocket.app.tela.PainelDeControle;
import chatsocket.app.bean.Mensagem;
import chatsocket.app.bean.Usuario;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe provedora de serviços
 *
 * @author Lucas Benjamin
 * @since setembro/2018
 */
public class Servidor {

    private static final int PORTA_ESCUTA = 10588;
    private static PainelDeControle painel;
    private Map<String, Usuario> baseUsuarios = new HashMap<>();
    private ServidorUtilImpl servidorUtil = new ServidorUtilImpl();

    public Servidor() {

        try {
            ServerSocket server = new ServerSocket(PORTA_ESCUTA);
            this.painel = new PainelDeControle();
            this.painel.setVisible(true);
            this.painel.exibirLogTela("[" + servidorUtil.obtemDataEHoraAtual() + "]" + " Servidor escutando na porta [ " + server.getLocalPort() + " ]");

            while (true) {
                Socket socket = server.accept();
                new Thread(new OuvinteAtencioso(socket)).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private class OuvinteAtencioso implements Runnable {

        private ObjectOutputStream saida;
        private ObjectInputStream entrada;
        private String loginUsuario;

        public OuvinteAtencioso(Socket socket) {

            try {
                this.saida = new ObjectOutputStream(socket.getOutputStream());
                this.entrada = new ObjectInputStream(socket.getInputStream());

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            Mensagem mensagem = null;

            try {
                while ((mensagem = (Mensagem) entrada.readObject()) != null) {
                    Mensagem.Comando comando = mensagem.getComando();
                    setLoginUsuario(mensagem.getNomeUnico());
                    
                    switch (comando) {
                        case CONECTAR:
                            logarUsuario(mensagem, this.saida);
                            enviarListaOnline();
                            break;
                        case DESCONECTAR:
                            desconectado(mensagem);                                                                                           
                            return;
                        case ENVIAR_UM:

                            break;
                        case ENVIAR_TODOS:
                            enviarMenssagem(mensagem);
                            break;
                        default:
                            break;
                    }

                }
            } catch (IOException | ClassNotFoundException ex) {
                mensagem.setNomeUnico(getLoginUsuario());
                desconectado(mensagem);
                enviarListaOnline();
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public String getLoginUsuario() {
            return loginUsuario;
        }
        public void setLoginUsuario(String loginUsuario) {
            this.loginUsuario = loginUsuario;
        }
    }

    private void enviarMenssagem(Mensagem mensagem) {
        
        /* Envia mensagem de conexão ao usuário que solicitou */
        if (mensagem.getComando().equals(Mensagem.Comando.CONECTAR)) {
            for (Map.Entry<String, Usuario> usuario : baseUsuarios.entrySet()) {
                if (usuario.getKey().equals(mensagem.getNomeUnico())) {
                    try {
                        usuario.getValue().getObjetoSaida().writeObject(mensagem);
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        /* Envia mensagem para todos os destinatarios logados */
        if (mensagem.getComando().equals(Mensagem.Comando.ENVIAR_TODOS)) {
            this.baseUsuarios.entrySet().forEach((usuario) -> {
                try {
                    if(usuario.getValue().isLogado()){
                        usuario.getValue().getObjetoSaida().writeObject(mensagem);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

    private void desconectado(Mensagem mensagem) {
        baseUsuarios.get(mensagem.getNomeUnico()).setLogado(false);
        
        mensagem.setComando(Mensagem.Comando.ENVIAR_TODOS);
        mensagem.setNomeExibicao("Servidor");
        mensagem.setTextoMensagem("[" + servidorUtil.obtemDataEHoraAtual() + "]" + " O Usuário " + mensagem.getNomeUnico()+ " Saiu do chat!");
        
        enviarMenssagem(mensagem);
        enviarListaOnline();
        
        Servidor.painel.exibirLogTela("[" + servidorUtil.obtemDataEHoraAtual() + "]" + " O Usuário " + mensagem.getNomeUnico()+ " Saiu do chat!"); 
    }
    
    private void enviarListaOnline() {
        Set<String> usuariosOnlines = new HashSet<>();
        Mensagem mensagem = new Mensagem();
        mensagem.setComando(Mensagem.Comando.USERS_ONLINE);
        
        //Popula uma lista com os usuários logados no sistema
        for (Map.Entry<String, Usuario> usuario : baseUsuarios.entrySet()) {
            if(usuario.getValue().isLogado()){
                usuariosOnlines.add(usuario.getValue().getNomeExibicao());
            }
        }
        mensagem.setListaOnlines(usuariosOnlines);

        /* Envia a lista para todos os usuários onlines */
        for (Map.Entry<String, Usuario> usuario : baseUsuarios.entrySet()) {
            try {
                if(usuario.getValue().isLogado()){
                    usuario.getValue().getObjetoSaida().writeObject(mensagem);
                }
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void logarUsuario(Mensagem mensagem, ObjectOutputStream objetoSaida) {
            
        String avatar = mensagem.getAvatar();
        String nomeExibicao = mensagem.getNomeExibicao();
        String nomeUnico = mensagem.getNomeUnico();
        String senha = mensagem.getSenha();

        /* Adiciona usuário no objeto Map*/
        Usuario usuario = new Usuario();
        usuario.setAvatar(avatar);
        usuario.setNomeExibicao(nomeExibicao);
        usuario.setNomeUnico(nomeUnico);
        usuario.setObjetoSaida(objetoSaida);
        usuario.setSenha(senha);
        
        /* Valida se usuário esta cadastrado e a senha */    
        if(servidorUtil.isCadastrado(mensagem, baseUsuarios)){
            
            if(servidorUtil.isSenhaValida(mensagem, baseUsuarios)){
                
                usuario.setLogado(true);
                this.baseUsuarios.replace(nomeUnico, usuario);
                
                /* Envia Comando de logon ao usuário  */
                mensagem.setTextoMensagem("[" + servidorUtil.obtemDataEHoraAtual() + "] " + nomeExibicao + " entrou no chat");
                enviarMenssagem(mensagem);
                
                this.painel.mantemListaOnlines(mensagem);
                Servidor.painel.exibirLogTela("[" + servidorUtil.obtemDataEHoraAtual() + "]" + " O Usuário " + nomeUnico + " entrou no chat");
                
            }else{
                /* Envia Comando negando logon ao usuário  */

                usuario.setLogado(false);
                this.baseUsuarios.replace(nomeUnico, usuario);
                mensagem.setTextoMensagem(":ERRO 01");
                enviarMenssagem(mensagem);
                Servidor.painel.exibirLogTela("[" + servidorUtil.obtemDataEHoraAtual() + "]" + " O Usuário " + mensagem.getNomeUnico()+ " Errou a senha!");   
            }    
        }else{
            usuario.setLogado(true);
            this.baseUsuarios.put(nomeUnico, usuario);

            /* Envia Comando de logon ao usuário  */
            mensagem.setTextoMensagem("[" + servidorUtil.obtemDataEHoraAtual() + "] " + nomeExibicao + " entrou no chat");
            enviarMenssagem(mensagem);

            this.painel.mantemListaOnlines(mensagem);
            Servidor.painel.exibirLogTela("[" + servidorUtil.obtemDataEHoraAtual() + "]" + " O Usuário " + nomeUnico + " entrou no chat");            
        }
    }

}
