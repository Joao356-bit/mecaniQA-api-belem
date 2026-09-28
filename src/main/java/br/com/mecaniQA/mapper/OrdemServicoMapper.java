package br.com.mecaniQA.mapper;

import br.com.mecaniQA.dto.OrdemServicoDTO;
import br.com.mecaniQA.model.OrdemServico;
import br.com.mecaniQA.model.Peca;
import br.com.mecaniQA.model.Servico;
import br.com.mecaniQA.repository.PecaRepository;
import br.com.mecaniQA.repository.ServicoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrdemServicoMapper {

    private static final PecaRepository pecaRepository =
            PecaRepository.getInstance();

    private static final ServicoRepository servicoRepository =
            ServicoRepository.getInstance();

    public static OrdemServicoDTO toDTO(OrdemServico ordemServico) {

        if (ordemServico == null) {
            return null;
        }

        OrdemServicoDTO dto = new OrdemServicoDTO();

        dto.setCodigo(ordemServico.getCodigo());
        dto.setStatus(ordemServico.getStatus());

        List<Long> codigosPecas = new ArrayList<>();

        if (ordemServico.getPecas() != null) {
            codigosPecas = ordemServico.getPecas()
                    .stream()
                    .map(Peca::getCodigo)
                    .collect(Collectors.toList());
        }

        dto.setPecas(codigosPecas);

        List<Long> codigosServicos = new ArrayList<>();

        if (ordemServico.getServicos() != null) {
            codigosServicos = ordemServico.getServicos()
                    .stream()
                    .map(Servico::getCodigo)
                    .collect(Collectors.toList());
        }

        dto.setServicos(codigosServicos);

        return dto;
    }

    public static OrdemServico toEntity(OrdemServicoDTO dto) {

        if (dto == null) {
            return null;
        }

        List<Peca> pecas = new ArrayList<>();

        if (dto.getPecas() != null) {

            for (Long codigoPeca : dto.getPecas()) {

                Peca peca =
                        pecaRepository.buscarPorCodigo(codigoPeca);

                if (peca == null) {
                    throw new IllegalArgumentException(
                            "Peça não encontrada: " + codigoPeca
                    );
                }

                pecas.add(peca);
            }
        }

        List<Servico> servicos = new ArrayList<>();

        if (dto.getServicos() != null) {

            for (Long codigoServico : dto.getServicos()) {

                Servico servico =
                        servicoRepository.buscarPorCodigo(codigoServico);

                if (servico == null) {
                    throw new IllegalArgumentException(
                            "Serviço não encontrado: " + codigoServico
                    );
                }

                servicos.add(servico);
            }
        }

        return OrdemServico.builder()
                .codigo(dto.getCodigo())
                .status(dto.getStatus())
                .pecas(pecas)
                .servicos(servicos)
                .build();
    }
}