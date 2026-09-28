package br.com.mecaniQA.repository;

import br.com.mecaniQA.model.OrdemServico;
import br.com.mecaniQA.model.StatusOrdemServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemServicoRepository {

    private static OrdemServicoRepository instance;

    private List<OrdemServico> ordensServico;
    private Long proximoCodigo = 1L;

    private OrdemServicoRepository() {
        ordensServico = new ArrayList<>();
    }

    public static OrdemServicoRepository getInstance() {
        if (instance == null) {
            instance = new OrdemServicoRepository();
        }

        return instance;
    }

    public OrdemServico cadastrar(OrdemServico ordemServico) {
        ordemServico.setCodigo(proximoCodigo);
        proximoCodigo++;

        ordensServico.add(ordemServico);

        return ordemServico;
    }

    public List<OrdemServico> listar() {
        return ordensServico;
    }

    public OrdemServico buscarPorCodigo(Long codigo) {
        for (OrdemServico ordemServico : ordensServico) {
            if (ordemServico.getCodigo().equals(codigo)) {
                return ordemServico;
            }
        }

        return null;
    }

    public OrdemServico atualizarStatus(
            Long codigo,
            StatusOrdemServico status) {

        OrdemServico ordemServico = buscarPorCodigo(codigo);

        if (ordemServico == null) {
            return null;
        }

        ordemServico.setStatus(status);

        return ordemServico;
    }

    public boolean excluir(Long codigo) {
        OrdemServico ordemServico = buscarPorCodigo(codigo);

        if (ordemServico == null) {
            return false;
        }

        ordensServico.remove(ordemServico);

        return true;
    }
}