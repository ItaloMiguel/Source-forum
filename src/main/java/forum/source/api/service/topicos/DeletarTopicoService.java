package forum.source.api.service.topicos;

import forum.source.api.dominio.topicos.service.DeletarTopico;
import forum.source.api.infraestrutura.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarTopicoService implements DeletarTopico {

    private TopicosRepository topicosRepository;

    @Autowired
    public DeletarTopicoService(TopicosRepository topicosRepository) {
        this.topicosRepository = topicosRepository;
    }

    @Override
    public void execute(Long id) {
        topicosRepository.deleteById(id);
    }
}
