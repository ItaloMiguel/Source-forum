package forum.source.api.aplicacao.topicos.payload;

import forum.source.api.dominio.topicos.Resposta;
import forum.source.api.dominio.topicos.TopicoStatus;
import forum.source.api.dominio.topicos.Topicos;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class DetalharTopicoResponse {

    private Long id;
    private String titulo;
    private String autor;
    private String mensagem;
    private String imagem;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private boolean finalized;
    private TopicoStatus status;
    private List<Resposta> respostas;

    public DetalharTopicoResponse(Topicos topicos) {
        this.id = topicos.getId();
        this.titulo = topicos.getTitulo();
        this.mensagem = topicos.getMensagem();
        this.imagem = topicos.getImagem();
        this.dataAtualizacao = topicos.getDataAtualizacao();
        this.dataAtualizacao = topicos.getDataAtualizacao();

    }
}
