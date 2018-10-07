package chatsocket.app.bean;

import java.io.ObjectOutputStream;

public class Usuario {
    
    private String nomeExibicao;
    private String nomeUnico;
    private String senha;
    private String avatar;
    private boolean logado;
    private ObjectOutputStream objetoSaida;

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public void setNomeExibicao(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeUnico() {
        return nomeUnico;
    }

    public void setNomeUnico(String nomeUnico) {
        this.nomeUnico = nomeUnico;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public ObjectOutputStream getObjetoSaida() {
        return objetoSaida;
    }

    public void setObjetoSaida(ObjectOutputStream objetoSaida) {
        this.objetoSaida = objetoSaida;
    }
    
    
}
