package forum.source.api.dominio.topicos.service;

import forum.source.api.aplicacao.topicos.payload.ProcurarTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuscarTopicoPorNome {
    Page<TopicoResponse> execute(ProcurarTopicoRequest request, Pageable paginacao);
}
