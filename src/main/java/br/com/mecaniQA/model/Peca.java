package br.com.mecaniQA.model;

import java.time.LocalDateTime;

public class Peca {

    private Long codigo;
    private String codigoBarras;
    private String fornecedor;
    private Integer quantidadeEstoque;

    private Double precoCusto;
    private Double precoVenda;

    private LocalDateTime dataCadastro;
    private LocalDateTime ultimaAtualizacao;

    private String tamanho;
    private String cor;

    private CategoriaPeca categoria;

    public Peca() {
    }

    public Peca(Long codigo,
                String codigoBarras,
                String fornecedor,
                Integer quantidadeEstoque,
                Double precoCusto,
                Double precoVenda,
                LocalDateTime dataCadastro,
                LocalDateTime ultimaAtualizacao,
                String tamanho,
                String cor,
                CategoriaPeca categoria) {

        this.codigo = codigo;
        this.codigoBarras = codigoBarras;
        this.fornecedor = fornecedor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataCadastro = dataCadastro;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.tamanho = tamanho;
        this.cor = cor;
        this.categoria = categoria;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public CategoriaPeca getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPeca categoria) {
        this.categoria = categoria;
    }
}