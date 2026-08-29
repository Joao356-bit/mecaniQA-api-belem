package br.com.mecaniQA.controller;

import br.com.mecaniQA.model.Servico;
import br.com.mecaniQA.repository.ServicoRepository;
import br.com.mecaniQA.request.ServicoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoRepository repository = ServicoRepository.getInstance();

    @PostMapping
    public ResponseEntity<Servico> cadastrar(@RequestBody ServicoRequest request) {

        Servico servico = new Servico();

        servico.setNome(request.getNome());
        servico.setTempoEstimadoMinutos(request.getTempoEstimadoMinutos());
        servico.setCusto(request.getCusto());

        Servico novoServico = repository.cadastrar(servico);

        return ResponseEntity.status(201).body(novoServico);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listar() {
        return ResponseEntity.ok(repository.listar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Servico> buscarPorCodigo(@PathVariable Long codigo) {

        Servico servico = repository.buscarPorCodigo(codigo);

        if (servico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(servico);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Servico> atualizar(
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

        return ResponseEntity.ok(servicoAtualizado);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluir(@PathVariable Long codigo) {

        boolean excluido = repository.excluir(codigo);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}