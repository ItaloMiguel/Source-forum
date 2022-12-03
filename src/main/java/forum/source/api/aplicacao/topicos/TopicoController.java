package forum.source.api.aplicacao.topicos;

import forum.source.api.aplicacao.topicos.payload.*;
import forum.source.api.dominio.topicos.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/topicos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicoController {

    private CriarNovoTopico criarNovoTopico;
    private BuscarTodosTopicos buscarTodosTopicos;
    private BuscarTopicoPorNome buscarTopicoPorNome;
    private BuscarTopicoPorId buscarTopicoPorId;
    private AtualizarTopico atualizarTopico;
    private DeletarTopico deletarTopico;

    @Autowired
    public TopicoController(CriarNovoTopico criarNovoTopico,
                            BuscarTodosTopicos buscarTodosTopicos,
                            BuscarTopicoPorNome buscarTopicoPorNome,
                            BuscarTopicoPorId buscarTopicoPorId, AtualizarTopico atualizarTopico, DeletarTopico deletarTopico) {
        this.criarNovoTopico = criarNovoTopico;
        this.buscarTodosTopicos = buscarTodosTopicos;
        this.buscarTopicoPorNome = buscarTopicoPorNome;
        this.buscarTopicoPorId = buscarTopicoPorId;
        this.atualizarTopico = atualizarTopico;
        this.deletarTopico = deletarTopico;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> adicionarTopicos(@RequestBody @Valid CriarNovoTopicoRequest request) {
        criarNovoTopico.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tópico criado com sucesso!");
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<TopicoResponse>> listarTopicos(
            @PageableDefault(sort = {"dataCriacao"}, direction = Sort.Direction.DESC, size = 5) Pageable paginacao) {
        Page<TopicoResponse> response = buscarTodosTopicos.execute(paginacao);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/procurar", produces = "application/json")
    public ResponseEntity<Page<TopicoResponse>> buscarPorTitulo(
            @PageableDefault(sort = {"dataCriacao"}, direction = Sort.Direction.DESC, size = 5) Pageable paginacao,
            @RequestBody @Valid ProcurarTopicoRequest request) {
        Page<TopicoResponse> response = buscarTopicoPorNome.execute(request, paginacao);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}/procurar", produces = "application/json")
    public ResponseEntity<DetalharTopicoResponse> detalharTopico(@PathVariable("id") Long id) {
        DetalharTopicoResponse response = buscarTopicoPorId.execute(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(path = "/{id}/atualizar",produces = "application/json")
    public ResponseEntity<String> atualizarTopico(@RequestBody @Valid AtualizarTopicoRequest request, @PathVariable("id") Long id) {
        TopicoResponse response = atualizarTopico.execute(request, id);
        return ResponseEntity.ok().body("Topico atualizado com sucesso!");
    }

    @DeleteMapping(path = "/{id}/deletar", produces = "application/json")
    public ResponseEntity<String> deletarTopico(@PathVariable("id") Long id) {
        deletarTopico.execute(id);
        return ResponseEntity.ok().body("Topico deletado com sucesso!");
    }
}
