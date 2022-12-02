package forum.source.api.service.topicos;

import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import forum.source.api.dominio.topicos.Topicos;
import forum.source.api.dominio.topicos.service.BuscarTodosTopicos;
import forum.source.api.infraestrutura.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarTodosTopicosService implements BuscarTodosTopicos {

    private TopicosRepository topicosRepository;

    @Autowired
    public BuscarTodosTopicosService(TopicosRepository topicosRepository) {
        this.topicosRepository = topicosRepository;
    }

    @Override
    public Page<TopicoResponse> execute(Pageable paginacao) {
        Page<Topicos> topicos = topicosRepository.findAll(paginacao);
        return topicos.map(TopicoResponse::new);
    }
}
