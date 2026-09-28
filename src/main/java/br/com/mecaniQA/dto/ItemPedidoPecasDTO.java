package br.com.mecaniQA.dto;

public class ItemPedidoPecasDTO {

    private Long codigoPeca;
    private Integer quantidade;

    public ItemPedidoPecasDTO() {
    }

    public Long getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(Long codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}