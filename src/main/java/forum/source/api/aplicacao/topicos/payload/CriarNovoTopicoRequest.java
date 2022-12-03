package forum.source.api.aplicacao.topicos.payload;

import forum.source.api.dominio.topicos.Resposta;
import forum.source.api.dominio.topicos.TopicoStatus;
import forum.source.api.dominio.users.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record CriarNovoTopicoRequest(
        @NotBlank(message = "Titulo não pode ser vazio")
        String titulo,
        String autor,
        @NotBlank(message = "Mensagem não pode ser vazio")
        String mensagem,
        String imagem) { }