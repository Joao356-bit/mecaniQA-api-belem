package br.com.mecaniQA.model;

public class ItemPedidoPecas {

    private Peca peca;
    private Integer quantidade;

    public ItemPedidoPecas() {
    }

    public ItemPedidoPecas(Peca peca, Integer quantidade) {
        this.peca = peca;
        this.quantidade = quantidade;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}