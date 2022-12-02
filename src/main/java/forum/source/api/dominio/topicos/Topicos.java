package forum.source.api.dominio.topicos;

import forum.source.api.aplicacao.topicos.payload.CriarNovoTopicoRequest;
import forum.source.api.dominio.users.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topicos")
public class Topicos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String mensagem;
    private String imagem;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private boolean finalized;
    @Enumerated(EnumType.STRING)
    private TopicoStatus status;
    @OneToMany(mappedBy = "topicos")
    private List<Resposta> respostas = new ArrayList<>();

    public Topicos(CriarNovoTopicoRequest request) {
        this.titulo = request.titulo();
        this.autor = request.autor();
        this.mensagem = request.mensagem();
        this.imagem = request.imagem();
        this.dataCriacao = LocalDateTime.now();
        this.finalized = false;
        this.status = TopicoStatus.NAO_SOLUCIONADO;
    }
}
