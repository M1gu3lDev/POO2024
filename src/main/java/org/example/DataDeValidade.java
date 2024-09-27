package org.example;

public class DataDeValidade {
        private String data;
        private String lote;
        public int quantidade;
        public DataDeValidade(String data, int quantidade){
            this.data = data;
            this.quantidade = quantidade;
        }
        public String getData(){
            return data;
        }
        public int getQuantidade(){
            return quantidade;
        }
        public void setData(String data){
            this.data = data;
        }
        public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
        }
        public String getLote(){
            return lote;
        }
        public void setLote(String lote){
            this.lote = lote;
        }
    }
