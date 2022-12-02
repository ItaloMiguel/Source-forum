package forum.source.api.aplicacao.topicos.payload;

import forum.source.api.dominio.topicos.Resposta;
import forum.source.api.dominio.topicos.TopicoStatus;
import forum.source.api.dominio.topicos.Topicos;
import forum.source.api.dominio.users.UserModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TopicoResponse {

    private Long id;
    private String titulo;
    private UserModel autor;
    private String mensagem;
    private String imagem;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private boolean finalized;
    private TopicoStatus status;
    private List<Resposta> respostas = new ArrayList<>();

    public TopicoResponse(Topicos topicos) {

    }
}
