package forum.source.api.service.topicos;

import forum.source.api.aplicacao.exceptions.IdNotFoundException;
import forum.source.api.aplicacao.topicos.payload.AtualizarTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import forum.source.api.dominio.topicos.Topicos;
import forum.source.api.dominio.topicos.TopicosFactory;
import forum.source.api.dominio.topicos.service.AtualizarTopico;
import forum.source.api.infraestrutura.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AtualizarTopicoService implements AtualizarTopico {

    private TopicosRepository topicosRepository;

    @Autowired
    public AtualizarTopicoService(TopicosRepository topicosRepository) {
        this.topicosRepository = topicosRepository;
    }

    @Override
    @Transactional
    public TopicoResponse execute(AtualizarTopicoRequest request, Long id) {
        Topicos topicos  = topicosRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id.toString()));
        topicos.atualizar(request);
        topicosRepository.save(topicos);
        return new TopicoResponse(topicos);
    }
}
