package forum.source.api.infraestrutura;

import forum.source.api.dominio.topicos.Topicos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface TopicosRepository extends JpaRepository<Topicos, Long> {
    Optional<Page<Topicos>> findByTitulo(String titulo, Pageable pageable);

    Optional<Page<Topicos>> findByMensagem(String messangem, Pageable pageable);
}
