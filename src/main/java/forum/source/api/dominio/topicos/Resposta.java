package forum.source.api.dominio.topicos;

import forum.source.api.dominio.users.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titlo;
    private String messagem;
    @ManyToOne
    private Topicos topicos;
    private String autor;
    private LocalDateTime dataCricao;
    private LocalDateTime dataAtualizacao;
}
