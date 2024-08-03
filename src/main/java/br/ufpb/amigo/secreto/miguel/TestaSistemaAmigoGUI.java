package br.ufpb.amigo.secreto.miguel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TestaSistemaAmigoGUI{

    public static void main(String[] args) throws AmigoInexistenteException, AmigoJaExisteException, AmigoNaoSorteadoException{
        SistemaAmigoSecreto sistemaAmigo = new SistemaAmigoSecreto();
        List<Amigo> amigos = new ArrayList<>();


        sistemaAmigo = new SistemaAmigoSecreto();


        int totalAmigos = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade total de amigos:"));


        for (int i = 0; i < totalAmigos; i++) {
            String nome = JOptionPane.showInputDialog("Digite o nome do amigo " + (i + 1) + ":");
            String email = JOptionPane.showInputDialog("Digite o email do amigo " + (i + 1) + ":");
            sistemaAmigo.cadastraAmigo(nome, email);
            amigos.add(new Amigo(nome, email));
        }


        for (Amigo amigo : amigos) {
            String emailAmigoSorteado = JOptionPane.showInputDialog("Digite o email do amigo sorteado para " + amigo.getNome() + ":");
            amigo.setAmigoSorteado(emailAmigoSorteado);
            sistemaAmigo.configuraAmigoSecretoDe(amigo.getEmail(), emailAmigoSorteado);
        }


        String emailRemetente = JOptionPane.showInputDialog("Digite o email do remetente da mensagem:");
        String texto = JOptionPane.showInputDialog("Digite o texto da mensagem:");
        int resposta = JOptionPane.showConfirmDialog(null, "A mensagem é anônima?", "Mensagem Anônima", JOptionPane.YES_NO_OPTION);
        boolean ehAnonima = (resposta == JOptionPane.YES_OPTION);

        sistemaAmigo.enviarMensagemParaTodos(texto, emailRemetente, ehAnonima);
        JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
    }
}
