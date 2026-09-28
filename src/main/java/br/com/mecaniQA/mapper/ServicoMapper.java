package br.com.mecaniQA.mapper;

import br.com.mecaniQA.dto.ServicoDTO;
import br.com.mecaniQA.model.Servico;

public class ServicoMapper {

    public static ServicoDTO toDTO(Servico servico) {

        if (servico == null) {
            return null;
        }

        ServicoDTO dto = new ServicoDTO();

        dto.setCodigo(servico.getCodigo());
        dto.setNome(servico.getNome());
        dto.setTempoEstimadoMinutos(servico.getTempoEstimadoMinutos());
        dto.setCusto(servico.getCusto());

        return dto;
    }

    public static Servico toEntity(ServicoDTO dto) {

        if (dto == null) {
            return null;
        }

        Servico servico = new Servico();

        servico.setCodigo(dto.getCodigo());
        servico.setNome(dto.getNome());
        servico.setTempoEstimadoMinutos(dto.getTempoEstimadoMinutos());
        servico.setCusto(dto.getCusto());

        return servico;
    }
}