package forum.source.api.service.topicos;


import forum.source.api.dominio.topicos.Topicos;
import forum.source.api.infraestrutura.TopicosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


class BuscarTodosTopicosServiceTest {

    private BuscarTodosTopicosService service;

    @Mock
    private TopicosRepository repository;

    private Pageable pageable;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.service = new BuscarTodosTopicosService(repository);
    }


    @Test
    void quandoChamarOMetodoExecutarDeveTerSucesso() {
//        Mockito.when(repository.findAll(pageable)).thenReturn()
    }
}