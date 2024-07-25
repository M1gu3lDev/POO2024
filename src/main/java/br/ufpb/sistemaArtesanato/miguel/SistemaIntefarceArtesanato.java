package br.ufpb.sistemaArtesanato.miguel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sistema para gerenciar itens de artesanato
 */
public interface SistemaIntefarceArtesanato {



    boolean cadastarItens(ItemDeArtesanato item);
    public List<ItemDeArtesanato> pesquisarPeloNome(String nome);
    /**
     * pesquisa todos os itens cujo o nome começa com o parâmetro passado
     * @param nome
     * @return
     */

    /**
     *pesquisa itens cujo o preço é menor ou igual a o prametro passado
     *
     */
    public  List<ItemDeArtesanato> pesquisarItensAbaixo(double preço);

    /**
     *pesquisa itens de acordo do código passado como pâmetro
     * @param codigo o codigo a ser pesquisado
     * @return retorna o item encontrodo
     * @throws  ItemNotFoundException se o item não for encontrado
     */
    public ItemDeArtesanato pesquisarItemPeloCodigo(String codigo) throws ItemNotFoundException;
}
