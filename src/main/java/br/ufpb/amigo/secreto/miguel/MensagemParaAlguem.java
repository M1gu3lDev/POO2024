package br.ufpb.amigo.secreto.miguel;

public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, boolean anonima, String emailDestinatario) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;

    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }
    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String GetTextoCompletoAExibir() {
       if(isAnonima()) {
            return "“Mensagem  para " + emailDestinatario + ". Texto: " + getTexto();
        }
       return "“Mensagem de"+ getEmailRemetente()+ "para " + emailDestinatario + ". Texto: " + getTexto();
    }
}
