package forum.source.api.dominio.topicos.service;

import forum.source.api.aplicacao.topicos.payload.TopicoResponse;

public interface BuscarTopicoPorId {
    TopicoResponse execute(Long id);
}
