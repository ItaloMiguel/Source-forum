package forum.source.api.service.topicos;

import forum.source.api.aplicacao.topicos.payload.ProcurarTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import forum.source.api.dominio.topicos.Topicos;
import forum.source.api.dominio.topicos.service.BuscarTopicoPorNome;
import forum.source.api.infraestrutura.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarTopicoPorNomeService implements BuscarTopicoPorNome {

    private TopicosRepository topicosRepository;

    @Autowired
    public BuscarTopicoPorNomeService(TopicosRepository topicosRepository) {
        this.topicosRepository = topicosRepository;
    }

    @Override
    public Page<TopicoResponse> execute(ProcurarTopicoRequest request, Pageable paginacao) {
        Optional<Page<Topicos>> optionalTopicos = topicosRepository.findByTitulo(request.title(), paginacao);
        if (optionalTopicos.get().isEmpty()) {
            Page<Topicos> topicos = topicosRepository.findAll(paginacao);
            return topicos.map(TopicoResponse::new);
        }

        Page<Topicos> topicos = optionalTopicos.get();
        return topicos.map(TopicoResponse::new);
    }
}