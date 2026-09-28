package br.com.mecaniQA.mapper;

import br.com.mecaniQA.dto.ItemPedidoPecasDTO;
import br.com.mecaniQA.dto.PedidoPecasDTO;
import br.com.mecaniQA.model.ItemPedidoPecas;
import br.com.mecaniQA.model.Peca;
import br.com.mecaniQA.model.PedidoPecas;
import br.com.mecaniQA.repository.PecaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoPecasMapper {

    private static final PecaRepository pecaRepository =
            PecaRepository.getInstance();

    public static PedidoPecasDTO toDTO(PedidoPecas pedidoPecas) {

        if (pedidoPecas == null) {
            return null;
        }

        PedidoPecasDTO dto = new PedidoPecasDTO();

        dto.setCodigo(pedidoPecas.getCodigo());
        dto.setStatus(pedidoPecas.getStatus());

        List<ItemPedidoPecasDTO> itensDTO = new ArrayList<>();

        if (pedidoPecas.getItens() != null) {

            itensDTO = pedidoPecas.getItens()
                    .stream()
                    .map(item -> {

                        ItemPedidoPecasDTO itemDTO =
                                new ItemPedidoPecasDTO();

                        if (item.getPeca() != null) {
                            itemDTO.setCodigoPeca(
                                    item.getPeca().getCodigo()
                            );
                        }

                        itemDTO.setQuantidade(
                                item.getQuantidade()
                        );

                        return itemDTO;
                    })
                    .collect(Collectors.toList());
        }

        dto.setItens(itensDTO);

        return dto;
    }

    public static PedidoPecas toEntity(PedidoPecasDTO dto) {

        if (dto == null) {
            return null;
        }

        PedidoPecas pedidoPecas =
                new PedidoPecas();

        pedidoPecas.setCodigo(dto.getCodigo());
        pedidoPecas.setStatus(dto.getStatus());

        List<ItemPedidoPecas> itens =
                new ArrayList<>();

        if (dto.getItens() != null) {

            for (ItemPedidoPecasDTO itemDTO : dto.getItens()) {

                Peca peca =
                        pecaRepository.buscarPorCodigo(
                                itemDTO.getCodigoPeca()
                        );

                if (peca == null) {
                    throw new IllegalArgumentException(
                            "Peça não encontrada: "
                                    + itemDTO.getCodigoPeca()
                    );
                }

                ItemPedidoPecas item =
                        new ItemPedidoPecas(
                                peca,
                                itemDTO.getQuantidade()
                        );

                itens.add(item);
            }
        }

        pedidoPecas.setItens(itens);

        return pedidoPecas;
    }

    public static ItemPedidoPecas toEntity(
            ItemPedidoPecasDTO dto) {

        if (dto == null) {
            return null;
        }

        Peca peca =
                pecaRepository.buscarPorCodigo(
                        dto.getCodigoPeca()
                );

        if (peca == null) {
            throw new IllegalArgumentException(
                    "Peça não encontrada: "
                            + dto.getCodigoPeca()
            );
        }

        return new ItemPedidoPecas(
                peca,
                dto.getQuantidade()
        );
    }
}