package br.ufpb.amigo.secreto.miguel;

public class MensagemParaTodos extends Mensagem {
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
       super(texto, emailRemetente, anonima);
    }

    @Override
    public String GetTextoCompletoAExibir() {
        if(isAnonima()) {
            return "“Mensagem  para Todos. Texto: " + getTexto();
        }
        return "“Mensagem de"+ getEmailRemetente()+ "para todas. Texto: " + getTexto();
    }
    }

