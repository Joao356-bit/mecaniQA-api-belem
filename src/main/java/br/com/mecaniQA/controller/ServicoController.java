package br.com.mecaniQA.controller;

import br.com.mecaniQA.dto.ServicoDTO;
import br.com.mecaniQA.mapper.ServicoMapper;
import br.com.mecaniQA.model.Servico;
import br.com.mecaniQA.repository.ServicoRepository;
import br.com.mecaniQA.request.ServicoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoRepository repository = ServicoRepository.getInstance();

    @PostMapping
    public ResponseEntity<ServicoDTO> cadastrar(
            @RequestBody ServicoRequest request) {

        Servico servico = new Servico();

        servico.setNome(request.getNome());
        servico.setTempoEstimadoMinutos(request.getTempoEstimadoMinutos());
        servico.setCusto(request.getCusto());

        Servico novoServico = repository.cadastrar(servico);

        return ResponseEntity
                .status(201)
                .body(ServicoMapper.toDTO(novoServico));
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> listar() {

        List<ServicoDTO> servicos = repository.listar()
                .stream()
                .map(ServicoMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ServicoDTO> buscarPorCodigo(
            @PathVariable Long codigo) {

        Servico servico = repository.buscarPorCodigo(codigo);

        if (servico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ServicoMapper.toDTO(servico));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ServicoDTO> atualizar(
            @PathVariable Long codigo,
            @RequestBody ServicoRequest request) {

        Servico servicoAtualizado = repository.atualizar(
                codigo,
                request.getTempoEstimadoMinutos(),
                request.getCusto()
        );

        if (servicoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                ServicoMapper.toDTO(servicoAtualizado)
        );
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long codigo) {

        boolean excluido = repository.excluir(codigo);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}