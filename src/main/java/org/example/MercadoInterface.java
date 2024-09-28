package org.example;


import java.util.Collection;

public interface MercadoInterface {
    public void cadastrarProduto(Produto produto);
    public Collection<Produto> listarProdutos();
    public void removerProduto(int id);
    public void adicionarUnidade(int id,Lote lote);
    public void removerUnidade(int id, String lote, int quantidade) throws LoteNaoEncontradoException;
    public Lote BuscarProdutosPorLote(int id, String lote) throws LoteNaoEncontradoException;
    public Collection<Lote> BuscarPorDataDeValidade(String dataDeValidade) throws LoteNaoEncontradoException;
    public void alterarPreco(int id, int preco);

}
