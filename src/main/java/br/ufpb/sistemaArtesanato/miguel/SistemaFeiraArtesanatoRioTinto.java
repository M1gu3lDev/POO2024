package br.ufpb.sistemaArtesanato.miguel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaFeiraArtesanatoRioTinto implements SistemaIntefarceArtesanato {
    private Map<String, ItemDeArtesanato> itensDeArtesanato;

    public SistemaFeiraArtesanatoRioTinto() {
        this.itensDeArtesanato = new HashMap<String, ItemDeArtesanato>();
    }
    @Override
    public boolean cadastarItens(ItemDeArtesanato item) {
        if (!itensDeArtesanato.containsKey(item.getCodigo())){
            return false;
        }
        this.itensDeArtesanato.put(item.getCodigo(), item);
        return true;
    }

    @Override
    public List<ItemDeArtesanato> pesquisarPeloNome(String nome) {
        List<ItemDeArtesanato> itensPeloNome = new LinkedList<ItemDeArtesanato>();
        for (ItemDeArtesanato item : this.itensDeArtesanato.values()) {
            if (item.getNome().equals(nome)) {
                itensPeloNome.add(item);
            }
            return itensPeloNome;
        }

        return null;
    }

    @Override
    public List<ItemDeArtesanato> pesquisarItensAbaixo(double preço) {
        return null;
    }

    @Override
    public ItemDeArtesanato pesquisarItemPeloCodigo(String codigo) throws ItemNotFoundException {
        ItemDeArtesanato item = this.itensDeArtesanato.get(codigo);
        if (item == null) {
            throw new ItemNotFoundException("Erro 404, item com Código: "+item.getCodigo()+" Não encontrado");
        }
        return null;
    }
}
