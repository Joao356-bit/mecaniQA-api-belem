package br.com.mecaniQA.model;

import java.util.ArrayList;
import java.util.List;

public class PedidoPecas {

    private Long codigo;
    private StatusPedidoPecas status;
    private List<ItemPedidoPecas> itens;

    public PedidoPecas() {
        this.itens = new ArrayList<>();
    }

    public PedidoPecas(Long codigo,
                       StatusPedidoPecas status,
                       List<ItemPedidoPecas> itens) {

        this.codigo = codigo;
        this.status = status;
        this.itens = itens;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public StatusPedidoPecas getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoPecas status) {
        this.status = status;
    }

    public List<ItemPedidoPecas> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoPecas> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemPedidoPecas item) {
        itens.add(item);
    }
}