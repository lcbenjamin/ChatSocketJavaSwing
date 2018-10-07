package chatsocket.app.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Lucas Costa - lcbenjamin
 */
public class ClienteUtil {

     /**
     * Obtem a data e a hora atual
     * 
     * @return String no formato dd/MM/yy HH:mm:ss
     */
    public String obtemDataEHoraAtual() {
        Date dataDeHoje = new Date();
        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        
        String dataHoraAtual = dataFormatada.format(dataDeHoje);
        return dataHoraAtual;
    }
    
}
