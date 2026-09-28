package br.com.mecaniQA.controller;

import br.com.mecaniQA.dto.OrdemServicoDTO;
import br.com.mecaniQA.mapper.OrdemServicoMapper;
import br.com.mecaniQA.model.OrdemServico;
import br.com.mecaniQA.model.StatusOrdemServico;
import br.com.mecaniQA.repository.OrdemServicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordens-servico")
public class OrdemServicoController {

    private final OrdemServicoRepository repository =
            OrdemServicoRepository.getInstance();

    @PostMapping
    public ResponseEntity<OrdemServicoDTO> cadastrar(
            @RequestBody OrdemServicoDTO dto) {

        OrdemServico ordemServico =
                OrdemServicoMapper.toEntity(dto);

        OrdemServico novaOrdemServico =
                repository.cadastrar(ordemServico);

        return ResponseEntity
                .status(201)
                .body(OrdemServicoMapper.toDTO(novaOrdemServico));
    }

    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> listar() {

        List<OrdemServicoDTO> ordensServico =
                repository.listar()
                        .stream()
                        .map(OrdemServicoMapper::toDTO)
                        .collect(Collectors.toList());

        return ResponseEntity.ok(ordensServico);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<OrdemServicoDTO> buscarPorCodigo(
            @PathVariable Long codigo) {

        OrdemServico ordemServico =
                repository.buscarPorCodigo(codigo);

        if (ordemServico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                OrdemServicoMapper.toDTO(ordemServico)
        );
    }

    @PutMapping("/{codigo}/status")
    public ResponseEntity<OrdemServicoDTO> atualizarStatus(
            @PathVariable Long codigo,
            @RequestParam StatusOrdemServico status) {

        OrdemServico ordemServico =
                repository.atualizarStatus(codigo, status);

        if (ordemServico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                OrdemServicoMapper.toDTO(ordemServico)
        );
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long codigo) {

        boolean excluida =
                repository.excluir(codigo);

        if (!excluida) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}