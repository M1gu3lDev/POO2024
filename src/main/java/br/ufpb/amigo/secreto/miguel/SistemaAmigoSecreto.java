package br.ufpb.amigo.secreto.miguel;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigoSecreto {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigoSecreto() {
        this.mensagens = new ArrayList<Mensagem>();
        this.amigos = new ArrayList<Amigo>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.add(novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                return amigo;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        MensagemParaAlguem mensagem = new MensagemParaAlguem(texto, emailRemetente, ehAnonima, emailDestinatario);
        mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem mensagem : mensagens) {
            if (mensagem.isAnonima()) {
                mensagensAnonimas.add(mensagem);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo != null) {
            amigo.setAmigoSorteado(emailAmigoSorteado);
        }
        else {
            throw new AmigoInexistenteException("Carta não encontrada");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoSorteadoException, AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo != null) {
            return amigo.getEmailAmigoSorteado();
        }
        if (amigo.getEmailAmigoSorteado() == null) {
            throw new AmigoInexistenteException("Amigo não sorteado");
        }
        throw new AmigoInexistenteException("Amigo não cadastrado");
    }
}
