package chatsocket.app.util;

import chatsocket.app.bean.Mensagem;
import chatsocket.app.bean.Usuario;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Classe utilitaria para o serviço de Servidor
 * 
 * @author Lucas Costa - lcbenjamin
 */
public class ServidorUtilImpl implements ServidorUtil {

    /**
     *
     * Valida nova Conexão
     *
     * @param mensagem Objeto enviado pelo usuário na tentativa de conexão
     * @param baseUsuarios Relação com os usuário logados no sistema
     * @return boolean
     */
    @Override
    public boolean validaNovaConexao(Mensagem mensagem, Map<String, Usuario> baseUsuarios) {    
        
        if(isCadastrado(mensagem,baseUsuarios)){
            if(isSenhaValida(mensagem,baseUsuarios)){
               return true; 
            } else{
                return false;
            }
        } else {
            return true;
        }
    }

     /**
     * Obtem a data e a hora atual
     * 
     * @return String no formato dd/MM/yy HH:mm:ss
     */
    @Override
    public String obtemDataEHoraAtual() {
        Date dataDeHoje = new Date();
        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        
        String dataHoraAtual = dataFormatada.format(dataDeHoje);
        return dataHoraAtual;
    }
    
    /** 
    *  Verifica se o usuário já esta na base
    *
    *  @param mensagem Objeto enviado pelo usuário na tentativa de conexão
    *  @param baseUsuarios Relação com os usuário logados no sistema
    *  @return boolean
    */
    public boolean isCadastrado(Mensagem mensagem, Map<String, Usuario> baseUsuarios){
          
        /* Varre base de usuário verificando ser o login já esta sendo usado */
        for (Map.Entry<String, Usuario> usuario : baseUsuarios.entrySet()) {
            if(usuario.getKey().equalsIgnoreCase(mensagem.getNomeUnico())){
                return true;
            }
        }
        /* Caso o login não esteja na base de usuários*/
        return false;
    }
    
    /** 
    *  Verifica a senha informada é igual a cadastrada na base
    *
    *  @param mensagem Objeto enviado pelo usuário na tentativa de conexão
    *  @param baseUsuarios Relação com os usuário logados no sistema
    *  @return boolean
    */
    public boolean isSenhaValida(Mensagem mensagem, Map<String, Usuario> baseUsuarios){
        
        /* Varre base de usuário verificando ser o login já esta sendo usado */
        for (Map.Entry<String, Usuario> usuario : baseUsuarios.entrySet()) {
            if(usuario.getValue().getSenha().equals(mensagem.getSenha())){
                return true;
            }
        }
        
        /* Caso o login não esteja na base de usuários*/
        return false;    
    }    
}
