package forum.source.api.aplicacao.topicos.payload;

import forum.source.api.dominio.topicos.Resposta;
import forum.source.api.dominio.topicos.TopicoStatus;
import forum.source.api.dominio.topicos.Topicos;
import forum.source.api.dominio.users.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
