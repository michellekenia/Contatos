package br.com.zup.Contato.config;

public class MensagemDeErro {

    public String mensagem;


    public MensagemDeErro(String message, String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
