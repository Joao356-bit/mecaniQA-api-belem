package br.com.mecaniQA.dto;

import br.com.mecaniQA.model.StatusPedidoPecas;

import java.util.ArrayList;
import java.util.List;

public class PedidoPecasDTO {

    private Long codigo;
    private StatusPedidoPecas status;

    private List<ItemPedidoPecasDTO> itens = new ArrayList<>();

    public PedidoPecasDTO() {
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

    public List<ItemPedidoPecasDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoPecasDTO> itens) {
        this.itens = itens;
    }
}