package br.com.mecaniQA.dto;

import br.com.mecaniQA.model.StatusOrdemServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDTO {

    private Long codigo;
    private StatusOrdemServico status;

    private List<Long> pecas = new ArrayList<>();
    private List<Long> servicos = new ArrayList<>();

    public OrdemServicoDTO() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public List<Long> getPecas() {
        return pecas;
    }

    public void setPecas(List<Long> pecas) {
        this.pecas = pecas;
    }

    public List<Long> getServicos() {
        return servicos;
    }

    public void setServicos(List<Long> servicos) {
        this.servicos = servicos;
    }
}