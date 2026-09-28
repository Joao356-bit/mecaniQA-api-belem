package br.com.mecaniQA.model;

import java.util.ArrayList;
import java.util.List;

public class OrdemServico {

    private Long codigo;
    private StatusOrdemServico status;
    private List<Peca> pecas;
    private List<Servico> servicos;

    private OrdemServico(Builder builder) {
        this.codigo = builder.codigo;
        this.status = builder.status;
        this.pecas = builder.pecas;
        this.servicos = builder.servicos;
    }

    public static Builder builder() {
        return new Builder();
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

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public static class Builder {

        private Long codigo;
        private StatusOrdemServico status;
        private List<Peca> pecas = new ArrayList<>();
        private List<Servico> servicos = new ArrayList<>();

        public Builder codigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder status(StatusOrdemServico status) {
            this.status = status;
            return this;
        }

        public Builder pecas(List<Peca> pecas) {
            this.pecas = pecas;
            return this;
        }

        public Builder servicos(List<Servico> servicos) {
            this.servicos = servicos;
            return this;
        }

        public OrdemServico build() {
            return new OrdemServico(this);
        }
    }
}