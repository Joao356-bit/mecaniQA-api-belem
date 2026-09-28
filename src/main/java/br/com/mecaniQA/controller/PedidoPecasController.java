package br.com.mecaniQA.controller;

import br.com.mecaniQA.dto.ItemPedidoPecasDTO;
import br.com.mecaniQA.dto.PedidoPecasDTO;
import br.com.mecaniQA.mapper.PedidoPecasMapper;
import br.com.mecaniQA.model.PedidoPecas;
import br.com.mecaniQA.model.StatusPedidoPecas;
import br.com.mecaniQA.repository.PedidoPecasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos-pecas")
public class PedidoPecasController {

    private final PedidoPecasRepository repository =
            PedidoPecasRepository.getInstance();

    @PostMapping
    public ResponseEntity<PedidoPecasDTO> cadastrar(
            @RequestBody PedidoPecasDTO dto) {

        PedidoPecas pedidoPecas =
                PedidoPecasMapper.toEntity(dto);

        PedidoPecas novoPedido =
                repository.cadastrar(pedidoPecas);

        return ResponseEntity
                .status(201)
                .body(PedidoPecasMapper.toDTO(novoPedido));
    }

    @GetMapping
    public ResponseEntity<List<PedidoPecasDTO>> listar() {

        List<PedidoPecasDTO> pedidos =
                repository.listar()
                        .stream()
                        .map(PedidoPecasMapper::toDTO)
                        .collect(Collectors.toList());

        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PedidoPecasDTO> buscarPorCodigo(
            @PathVariable Long codigo) {

        PedidoPecas pedido =
                repository.buscarPorCodigo(codigo);

        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                PedidoPecasMapper.toDTO(pedido)
        );
    }

    @PutMapping("/{codigo}/status")
    public ResponseEntity<PedidoPecasDTO> atualizarStatus(
            @PathVariable Long codigo,
            @RequestParam StatusPedidoPecas status) {

        PedidoPecas pedido =
                repository.atualizarStatus(codigo, status);

        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                PedidoPecasMapper.toDTO(pedido)
        );
    }

    @PostMapping("/{codigo}/itens")
    public ResponseEntity<PedidoPecasDTO> adicionarItem(
            @PathVariable Long codigo,
            @RequestBody ItemPedidoPecasDTO dto) {

        try {

            var item = PedidoPecasMapper.toEntity(dto);

            PedidoPecas pedido =
                    repository.adicionarItem(codigo, item);

            if (pedido == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(
                    PedidoPecasMapper.toDTO(pedido)
            );

        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long codigo) {

        boolean excluido =
                repository.excluir(codigo);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}