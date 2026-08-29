package br.com.mecaniQA.repository;

import br.com.mecaniQA.model.Servico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicoRepository {

    private static ServicoRepository instance;

    private List<Servico> servicos;
    private Long proximoCodigo = 1L;

    private ServicoRepository() {
        servicos = new ArrayList<>();
    }

    public static ServicoRepository getInstance() {
        if (instance == null) {
            instance = new ServicoRepository();
        }

        return instance;
    }

    public Servico cadastrar(Servico servico) {
        servico.setCodigo(proximoCodigo);
        proximoCodigo++;

        servico.setDataCriacao(LocalDateTime.now());
        servico.setUltimaAtualizacao(LocalDateTime.now());

        servicos.add(servico);

        return servico;
    }

    public List<Servico> listar() {
        return servicos;
    }

    public Servico buscarPorCodigo(Long codigo) {
        for (Servico servico : servicos) {
            if (servico.getCodigo().equals(codigo)) {
                return servico;
            }
        }

        return null;
    }

    public Servico atualizar(Long codigo, Integer tempoEstimadoMinutos, Double custo) {
        Servico servico = buscarPorCodigo(codigo);

        if (servico == null) {
            return null;
        }

        servico.setTempoEstimadoMinutos(tempoEstimadoMinutos);
        servico.setCusto(custo);
        servico.setUltimaAtualizacao(LocalDateTime.now());

        return servico;
    }

    public boolean excluir(Long codigo) {
        Servico servico = buscarPorCodigo(codigo);

        if (servico == null) {
            return false;
        }

        servicos.remove(servico);
        return true;
    }
}