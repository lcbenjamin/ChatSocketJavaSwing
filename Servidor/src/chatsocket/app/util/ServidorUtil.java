package chatsocket.app.util;

import chatsocket.app.bean.Mensagem;
import chatsocket.app.bean.Usuario;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 *
 * @author lucas
 */
public interface ServidorUtil {
    
    /**
     *
     * Valida nova Conexão
     *
     * @param mensagem Objeto enviado pelo usuário na tentativa de conexão
     * @param baseUsuarios Relação com os usuário logados no sistema
     * @return boolean
     */
    public boolean validaNovaConexao(Mensagem mensagem, Map<String, Usuario> baseUsuarios);

     /**
     * Obtem a data e a hora atual
     * 
     * @return String no formato dd/MM/yy HH:mm:ss
     */
    public String obtemDataEHoraAtual();

}