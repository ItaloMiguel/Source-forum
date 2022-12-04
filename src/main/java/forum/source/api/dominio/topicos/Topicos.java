package forum.source.api.dominio.topicos;

import forum.source.api.aplicacao.topicos.payload.AtualizarTopicoRequest;
import forum.source.api.aplicacao.topicos.payload.CriarNovoTopicoRequest;
import lombok.*;

import javax.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Topicos(Long id, String titulo, String autor, String mensagem, String imagem) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.mensagem = mensagem;
        this.imagem = imagem;
        this.dataCriacao = LocalDateTime.now();
        this.finalized = false;
        this.status = TopicoStatus.NAO_SOLUCIONADO;
    }
    public void atualizar(AtualizarTopicoRequest request) {
        if(request.titulo() != null) {
            this.titulo = request.titulo();
        }
        if(request.mensagem() != null) {
            this.mensagem = request.mensagem();
        }
        if(request.imagem() != null) {
            this.imagem = request.imagem();
        }
    }
}
