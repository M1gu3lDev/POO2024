package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Produto {


    private String nome;
    private String CodigoDeBarras;
    int quantidade;
    Collection<DataDeValidade> datasDeValidade;

    public Produto(String nome, String codigoDeBarras) {
        this.nome = nome;
        this.CodigoDeBarras = codigoDeBarras;
        this.quantidade = 0;
        this.datasDeValidade = new ArrayList<DataDeValidade>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoDeBarras() {
        return CodigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        CodigoDeBarras = codigoDeBarras;
    }

    public Collection<DataDeValidade> getDatasDeValidade() {
        return datasDeValidade;
    }

    public void setDatasDeValidade(DataDeValidade datasDeValidade) {
        this.datasDeValidade.add(datasDeValidade);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
