package chatsocket.app.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Lucas Costa lcbenjamin
 */
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private String nomeExibicao;
    private String textoMensagem;
    private String nomeUnico;
    private String senha;
    private String avatar;
    private Set<String> listaOnlines = new HashSet<>();
    private Comando comando;
    
    public enum Comando {
        CONECTAR, DESCONECTAR, ENVIAR_UM, ENVIAR_TODOS, USERS_ONLINE
    }

    public String getNomeUnico() {
        return nomeUnico;
    }

    public void setNomeUnico(String nomeUnico) {
        this.nomeUnico = nomeUnico;
    }
    
    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public void setNomeExibicao(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getTextoMensagem() {
        return textoMensagem;
    }

    public void setTextoMensagem(String textoMensagem) {
        this.textoMensagem = textoMensagem;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<String> getListaOnlines() {
        return listaOnlines;
    }

    public void setListaOnlines(Set<String> listaOnlines) {
        this.listaOnlines = listaOnlines;
    }

    public Comando getComando() {
        return comando;
    }

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        String mensagem = ("Nome Exibicao: " + getNomeExibicao() + "\n"+
                           "Texto Mensagem: " + getTextoMensagem()+ "\n"+
                           "Login: " + getNomeUnico()+ "\n"+
                           "Senha: " + getSenha()+ "\n"+
                           "Avatar: " + getAvatar()+ "\n"+
                           "Comando: " + getComando().toString()+ "\n");
        
        return mensagem;
    }
    
}