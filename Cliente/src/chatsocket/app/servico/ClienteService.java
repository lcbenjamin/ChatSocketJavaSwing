package chatsocket.app.servico;

import chatsocket.app.bean.Mensagem;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Costa
 */
public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket conectar(String servidor,Integer porta) throws UnknownHostException, IOException{

            this.socket = new Socket(servidor, porta);
            this.output = new ObjectOutputStream(socket.getOutputStream());
 
        return socket;
    }
    
    /**
     * Método responsavel para enviar mensagem ao servidor
     * @param message
     */
    public void enviar(Mensagem message) {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
