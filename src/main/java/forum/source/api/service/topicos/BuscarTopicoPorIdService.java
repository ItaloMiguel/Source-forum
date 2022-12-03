package forum.source.api.service.topicos;

import forum.source.api.aplicacao.exceptions.IdNotFoundException;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import forum.source.api.dominio.topicos.Topicos;
import forum.source.api.dominio.topicos.service.BuscarTopicoPorId;
import forum.source.api.infraestrutura.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarTopicoPorIdService implements BuscarTopicoPorId {

    private TopicosRepository topicosRepository;

    @Autowired
    public BuscarTopicoPorIdService(TopicosRepository topicosRepository) {
        this.topicosRepository = topicosRepository;
    }


    @Override
    public TopicoResponse execute(Long id) {
        Topicos topicos = topicosRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Não foi encontrado nem um tópico com esse ID: " + id));
        return new TopicoResponse(topicos);
    }
}
