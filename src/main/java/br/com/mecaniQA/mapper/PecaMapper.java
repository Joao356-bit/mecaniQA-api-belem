package br.com.mecaniQA.mapper;

import br.com.mecaniQA.dto.PecaDTO;
import br.com.mecaniQA.model.Peca;

public class PecaMapper {

    public static PecaDTO toDTO(Peca peca) {

        if (peca == null) {
            return null;
        }

        PecaDTO dto = new PecaDTO();

        dto.setCodigo(peca.getCodigo());
        dto.setCodigoBarras(peca.getCodigoBarras());
        dto.setFornecedor(peca.getFornecedor());
        dto.setQuantidadeEstoque(peca.getQuantidadeEstoque());
        dto.setPrecoCusto(peca.getPrecoCusto());
        dto.setPrecoVenda(peca.getPrecoVenda());
        dto.setTamanho(peca.getTamanho());
        dto.setCor(peca.getCor());
        dto.setCategoria(peca.getCategoria());

        return dto;
    }

    public static Peca toEntity(PecaDTO dto) {

        if (dto == null) {
            return null;
        }

        Peca peca = new Peca();

        peca.setCodigo(dto.getCodigo());
        peca.setCodigoBarras(dto.getCodigoBarras());
        peca.setFornecedor(dto.getFornecedor());
        peca.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        peca.setPrecoCusto(dto.getPrecoCusto());
        peca.setPrecoVenda(dto.getPrecoVenda());
        peca.setTamanho(dto.getTamanho());
        peca.setCor(dto.getCor());
        peca.setCategoria(dto.getCategoria());

        return peca;
    }
}