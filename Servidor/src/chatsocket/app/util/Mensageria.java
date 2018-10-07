package chatsocket.app.util;

import chatsocket.app.bean.Mensagem;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Responsavel pelo envio de mensagens
 * 
 * @author Lucas Costa - lcbenjamin
 */
public class Mensageria {

    private void enviar(Mensagem mensagem, ObjectOutputStream saida) {
        try {
            saida.writeObject(mensagem);
        } catch (IOException ex) {
            Logger.getLogger(Mensageria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void enviarUm(Mensagem mensagem, Map<String, ObjectOutputStream> usuariosOnlines) {
        for (Map.Entry<String, ObjectOutputStream> kv : usuariosOnlines.entrySet()) {
            if (kv.getKey().equals(mensagem.getNomeUnico())) {
                try {
                    kv.getValue().writeObject(mensagem);
                } catch (IOException ex) {
                    Logger.getLogger(Mensageria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void enviarTodos(Mensagem mensagem, Map<String, ObjectOutputStream> usuariosOnlines) {
        for (Map.Entry<String, ObjectOutputStream> kv : usuariosOnlines.entrySet()) {
            if (!kv.getKey().equals(mensagem.getNomeUnico())) {
                mensagem.setComando(Mensagem.Comando.ENVIAR_UM);
                try {
                    kv.getValue().writeObject(mensagem);
                } catch (IOException ex) {
                    Logger.getLogger(Mensageria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void enviarListaOnline(Map<String, ObjectOutputStream> usuariosOnlines) {
        Set<String> setNomes = new HashSet<>();
        for (Map.Entry<String, ObjectOutputStream> usuario : usuariosOnlines.entrySet()) {
            
        }

        Mensagem mensagem = new Mensagem();
        mensagem.setComando(Mensagem.Comando.USERS_ONLINE);
        mensagem.setListaOnlines(setNomes);

        for (Map.Entry<String, ObjectOutputStream> kv : usuariosOnlines.entrySet()) {
            mensagem.setNomeExibicao(kv.getKey());
            try {
                kv.getValue().writeObject(mensagem);
            } catch (IOException ex) {
                Logger.getLogger(Mensageria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
