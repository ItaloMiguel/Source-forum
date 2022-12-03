package forum.source.api.dominio.topicos.service;

import forum.source.api.aplicacao.topicos.payload.AtualizarTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;

public interface AtualizarTopico {
    TopicoResponse execute(AtualizarTopicoRequest request, Long id);
}
