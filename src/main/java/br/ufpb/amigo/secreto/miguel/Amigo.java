package br.ufpb.amigo.secreto.miguel;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;



    public Amigo(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.emailAmigoSorteado = "";
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }
    public void setAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }
}
