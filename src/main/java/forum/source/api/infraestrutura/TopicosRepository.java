package forum.source.api.infraestrutura;

import forum.source.api.dominio.topicos.Topicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface TopicosRepository extends JpaRepository<Topicos, Long> {
}
