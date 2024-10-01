package Miguel.ufpb.mercado;


import java.util.Collection;

public interface MercadoInterface {
    public void cadastrarProduto(Produto produto);
    public Collection<Produto> listarProdutos();
    public void removerProduto(String id);
    public void adicionarUnidade(String id,Lote lote);
    public void removerUnidade(String id, String lote, int quantidade) throws LoteNaoEncontradoException;
    public Lote BuscarProdutosPorLote(String id, String lote) throws LoteNaoEncontradoException;
    public Collection<Lote> BuscarPorDataDeValidade(String dataDeValidade) throws LoteNaoEncontradoException;
    public void alterarPreco(String id, int preco);

}
