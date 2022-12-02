package forum.source.api.aplicacao.topicos;

import forum.source.api.aplicacao.MessagemResponse;
import forum.source.api.aplicacao.topicos.payload.CriarNovoTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import forum.source.api.dominio.topicos.service.CriarNovoTopico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/topicos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicoController {

    private CriarNovoTopico criarNovoTopico;

    public TopicoController(CriarNovoTopico criarNovoTopico) {
        this.criarNovoTopico = criarNovoTopico;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> criar(@RequestBody CriarNovoTopicoRequest request) {
        criarNovoTopico.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Topico criado com sucesso!");
    }
}
