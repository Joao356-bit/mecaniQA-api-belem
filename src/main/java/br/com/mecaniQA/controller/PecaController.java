package br.com.mecaniQA.controller;

import br.com.mecaniQA.dto.PecaDTO;
import br.com.mecaniQA.mapper.PecaMapper;
import br.com.mecaniQA.model.Peca;
import br.com.mecaniQA.repository.PecaRepository;
import br.com.mecaniQA.request.PecaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pecas")
public class PecaController {

    private final PecaRepository repository = PecaRepository.getInstance();

    @PostMapping
    public ResponseEntity<PecaDTO> cadastrar(
            @RequestBody PecaRequest request) {

        Peca peca = new Peca();

        peca.setCodigoBarras(request.getCodigoBarras());
        peca.setFornecedor(request.getFornecedor());
        peca.setQuantidadeEstoque(request.getQuantidadeEstoque());
        peca.setPrecoCusto(request.getPrecoCusto());
        peca.setPrecoVenda(request.getPrecoVenda());
        peca.setTamanho(request.getTamanho());
        peca.setCor(request.getCor());
        peca.setCategoria(request.getCategoria());

        Peca novaPeca = repository.cadastrar(peca);

        return ResponseEntity
                .status(201)
                .body(PecaMapper.toDTO(novaPeca));
    }

    @GetMapping
    public ResponseEntity<List<PecaDTO>> listar() {

        List<PecaDTO> pecas = repository.listar()
                .stream()
                .map(PecaMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(pecas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PecaDTO> buscarPorCodigo(
            @PathVariable Long codigo) {

        Peca peca = repository.buscarPorCodigo(codigo);

        if (peca == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(PecaMapper.toDTO(peca));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PecaDTO> atualizar(
            @PathVariable Long codigo,
            @RequestBody PecaRequest request) {

        Peca pecaAtualizada = repository.atualizar(
                codigo,
                request.getPrecoCusto(),
                request.getPrecoVenda(),
                request.getQuantidadeEstoque()
        );

        if (pecaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(PecaMapper.toDTO(pecaAtualizada));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long codigo) {

        boolean excluida = repository.excluir(codigo);

        if (!excluida) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}