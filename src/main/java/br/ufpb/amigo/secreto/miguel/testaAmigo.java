package br.ufpb.amigo.secreto.miguel;

public class testaAmigo {
    public static void main(String[] args) throws AmigoInexistenteException, AmigoNaoSorteadoException, AmigoJaExisteException {
        SistemaAmigoSecreto sistema = new SistemaAmigoSecreto();
        sistema.cadastraAmigo("Maria", "Maria.java@gmail.com");
        sistema.cadastraAmigo("Jose", "Jose.java@gmail.com");
        sistema.configuraAmigoSecretoDe("Maria.java@gmail.com", "Jose.java@gmail.com");
        sistema.configuraAmigoSecretoDe("Jose.java@gmail.com", "Maria.java@gmail.com");
        sistema.enviarMensagemParaAlguem("Bom dia, que seu dia seja abençoado hoje","Maria.java@gmail.com", "Jose.java@gmail.com",true );
        sistema.enviarMensagemParaAlguem("Achei incrível aquele código que você fez Maria","Jose.java@gmail.com", "Maria.java@gmail.com",true );
        for (Mensagem m : sistema.pesquisaMensagensAnonimas()){
            System.out.println(m.GetTextoCompletoAExibir());
        }
        if (sistema.pesquisaAmigoSecretoDe("Maria.java@gmail.com").equals("Jose.java@gmail.com")){
            System.out.println("ok");
        }
    }

}
