package forum.source.api.dominio.topicos.service;

import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BuscarTodosTopicos {
    Page<TopicoResponse> execute(Pageable paginacao);
}
