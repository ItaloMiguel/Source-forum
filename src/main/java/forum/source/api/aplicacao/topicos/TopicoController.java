package forum.source.api.aplicacao.topicos;

import forum.source.api.aplicacao.topicos.payload.CriarNovoTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import forum.source.api.dominio.topicos.service.CriarNovoTopico;
import forum.source.api.dominio.topicos.service.BuscarTodosTopicos;
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

    @Autowired
    public TopicoController(CriarNovoTopico criarNovoTopico, BuscarTodosTopicos buscarTodosTopicos) {
        this.criarNovoTopico = criarNovoTopico;
        this.buscarTodosTopicos = buscarTodosTopicos;
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
}
