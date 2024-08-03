package br.ufpb.amigo.secreto.miguel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new ArrayList<Mensagem>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        ;
        if (amigos.containsKey(nomeAmigo)) {
            throw new AmigoJaExisteException("Amigo já existe no banco de dados.");
        }

        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.put(emailAmigo, amigo);
    }


    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        if (amigos.containsKey(emailAmigo)) {
            return amigos.get(emailAmigo);
        }
        throw new AmigoInexistenteException("Amigo inexistente.");
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
        } else {
            throw new AmigoInexistenteException("Amigo não encontrado");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoSorteadoException, AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo != null) {
            return amigo.getEmailAmigoSorteado();
        }
        if (amigo.getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException("Amigo não sorteado");
        }
        throw new AmigoInexistenteException("Amigo não cadastrado");
    }
}
