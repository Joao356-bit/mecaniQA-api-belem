package br.com.mecaniQA.repository;

import br.com.mecaniQA.model.Peca;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PecaRepository {

    private static PecaRepository instance;

    private List<Peca> pecas;
    private Long proximoCodigo = 1L;

    private PecaRepository() {
        pecas = new ArrayList<>();
    }

    public static PecaRepository getInstance() {
        if (instance == null) {
            instance = new PecaRepository();
        }

        return instance;
    }

    public Peca cadastrar(Peca peca) {
        peca.setCodigo(proximoCodigo);
        proximoCodigo++;

        peca.setDataCadastro(LocalDateTime.now());
        peca.setUltimaAtualizacao(LocalDateTime.now());

        pecas.add(peca);

        return peca;
    }

    public List<Peca> listar() {
        return pecas;
    }

    public Peca buscarPorCodigo(Long codigo) {
        for (Peca peca : pecas) {
            if (peca.getCodigo().equals(codigo)) {
                return peca;
            }
        }

        return null;
    }

    public Peca atualizar(Long codigo, Double precoCusto, Double precoVenda, Integer quantidadeEstoque) {
        Peca peca = buscarPorCodigo(codigo);

        if (peca == null) {
            return null;
        }

        peca.setPrecoCusto(precoCusto);
        peca.setPrecoVenda(precoVenda);
        peca.setQuantidadeEstoque(quantidadeEstoque);
        peca.setUltimaAtualizacao(LocalDateTime.now());

        return peca;
    }

    public boolean excluir(Long codigo) {
        Peca peca = buscarPorCodigo(codigo);

        if (peca == null) {
            return false;
        }

        pecas.remove(peca);
        return true;
    }
}