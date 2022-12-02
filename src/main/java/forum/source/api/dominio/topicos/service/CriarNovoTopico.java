package forum.source.api.dominio.topicos.service;

import forum.source.api.aplicacao.topicos.payload.CriarNovoTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;

public interface CriarNovoTopico {
    void execute(CriarNovoTopicoRequest request);
}
