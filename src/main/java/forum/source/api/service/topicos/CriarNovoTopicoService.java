package forum.source.api.service.topicos;

import forum.source.api.aplicacao.exceptions.UserNotFoundException;
import forum.source.api.aplicacao.topicos.payload.CriarNovoTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.TopicoResponse;
import forum.source.api.dominio.topicos.Topicos;
import forum.source.api.dominio.topicos.TopicosFactory;
import forum.source.api.dominio.topicos.service.CriarNovoTopico;
import forum.source.api.dominio.users.UserModel;
import forum.source.api.infraestrutura.TopicosRepository;
import forum.source.api.infraestrutura.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriarNovoTopicoService implements CriarNovoTopico {

    private TopicosRepository topicosRepository;

    @Autowired
    public CriarNovoTopicoService(TopicosRepository topicosRepository) {
        this.topicosRepository = topicosRepository;
    }

    @Override
    @Transactional
    public void execute(CriarNovoTopicoRequest request) {
        Topicos factory = new TopicosFactory().execute(request).build();
        topicosRepository.save(factory);
    }
}
