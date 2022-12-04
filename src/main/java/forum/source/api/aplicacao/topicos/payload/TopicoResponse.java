package forum.source.api.aplicacao.topicos.payload;

import forum.source.api.dominio.topicos.TopicoStatus;
import forum.source.api.dominio.topicos.Topicos;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class TopicoResponse {

    private Long id;
    private String titulo;
    private String mensagem;
    private TopicoStatus status;

    public TopicoResponse(Topicos topicos) {
        this.id = topicos.getId();
        this.titulo = topicos.getTitulo();
        this.mensagem = topicos.getMensagem();
        this.status = topicos.getStatus();
    }
}
