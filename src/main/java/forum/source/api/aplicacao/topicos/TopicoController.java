package forum.source.api.aplicacao.topicos;

import forum.source.api.aplicacao.topicos.payload.CriarNovoTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.ProcurarTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import forum.source.api.dominio.topicos.service.BuscarTopicoPorNome;
import forum.source.api.dominio.topicos.service.CriarNovoTopico;
import forum.source.api.dominio.topicos.service.BuscarTodosTopicos;
import forum.source.api.dominio.topicos.service.BuscarTopicoPorId;
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

    @Autowired
    public TopicoController(CriarNovoTopico criarNovoTopico,
                            BuscarTodosTopicos buscarTodosTopicos,
                            BuscarTopicoPorNome buscarTopicoPorNome,
                            BuscarTopicoPorId buscarTopicoPorId) {
        this.criarNovoTopico = criarNovoTopico;
        this.buscarTodosTopicos = buscarTodosTopicos;
        this.buscarTopicoPorNome = buscarTopicoPorNome;
        this.buscarTopicoPorId = buscarTopicoPorId;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> adicionarTopicos(@RequestBody CriarNovoTopicoRequest request) {
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
            @RequestBody ProcurarTopicoRequest request) {
        Page<TopicoResponse> response = buscarTopicoPorNome.execute(request, paginacao);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}/procurar", produces = "application/json")
    public ResponseEntity<TopicoResponse> detalharTopico(@PathVariable("id") Long id) {
        TopicoResponse response = buscarTopicoPorId.execute(id);
        return ResponseEntity.ok().body(response);
    }
}
