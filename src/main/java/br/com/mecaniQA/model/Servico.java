package br.com.mecaniQA.model;

import java.time.LocalDateTime;

public class Servico {

    private Long codigo;
    private String nome;
    private Integer tempoEstimadoMinutos;
    private Double custo;

    private LocalDateTime dataCriacao;
    private LocalDateTime ultimaAtualizacao;

    public Servico() {
    }

    public Servico(Long codigo,
                   String nome,
                   Integer tempoEstimadoMinutos,
                   Double custo,
                   LocalDateTime dataCriacao,
                   LocalDateTime ultimaAtualizacao) {

        this.codigo = codigo;
        this.nome = nome;
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
        this.custo = custo;
        this.dataCriacao = dataCriacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTempoEstimadoMinutos() {
        return tempoEstimadoMinutos;
    }

    public void setTempoEstimadoMinutos(Integer tempoEstimadoMinutos) {
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
