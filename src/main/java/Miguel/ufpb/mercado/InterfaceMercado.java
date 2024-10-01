package Miguel.ufpb.mercado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import Miguel.ufpb.mercado.*;

public class InterfaceMercado extends JFrame {
    private SistemaMercado sistema;

    public InterfaceMercado() {
        sistema = new SistemaMercado();

        // Configurações da janela
        setTitle("Sistema de Mercado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Botão para listar produtos
        JButton listarButton = new JButton("Listar Produtos");
        listarButton.setBounds(50, 30, 150, 30);
        add(listarButton);

        // Botão para cadastrar produto
        JButton cadastrarButton = new JButton("Cadastrar Produto");
        cadastrarButton.setBounds(50, 70, 150, 30);
        add(cadastrarButton);

        // Botão para remover produto
        JButton removerButton = new JButton("Remover Produto");
        removerButton.setBounds(50, 110, 150, 30);
        add(removerButton);

        // Configuração das ações dos botões
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProduto();
            }
        });
    }

    private void listarProdutos() {
        Collection<Produto> produtos = sistema.listarProdutos();
        StringBuilder produtoList = new StringBuilder();
        for (Produto produto : produtos) {
            produtoList.append("Nome: ").append(produto.getNome())
                    .append(", Tipo: ").append(produto.getTipo())
                    .append(", Preço: ").append(produto.getPreco())
                    .append(", Código: ").append(produto.getCodigoDeBarras())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(this, produtoList.toString(), "Produtos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cadastrarProduto() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        String tipo = JOptionPane.showInputDialog(this, "Digite o tipo do produto:");
        String codigoDeBarras = JOptionPane.showInputDialog(this, "Digite o código de barras:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o preço:"));
        Produto produto = new Produto(nome, tipo, codigoDeBarras, preco);
        sistema.cadastrarProduto(produto);
        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }

    private void removerProduto() {
        String codigoDeBarras = JOptionPane.showInputDialog(this, "Digite o código de barras do produto a ser removido:");
        sistema.removerProduto(codigoDeBarras); // Usando hashCode do código de barras como ID
        JOptionPane.showMessageDialog(this, "Produto removido com sucesso!", "Remover", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceMercado().setVisible(true);
            }
        });
    }
}
