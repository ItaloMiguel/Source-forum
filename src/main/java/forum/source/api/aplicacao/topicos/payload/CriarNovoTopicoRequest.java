package forum.source.api.aplicacao.topicos.payload;

import forum.source.api.dominio.topicos.Resposta;
import forum.source.api.dominio.topicos.TopicoStatus;
import forum.source.api.dominio.users.UserModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record CriarNovoTopicoRequest(
        String titulo,
        String autor,
        String mensagem,
        String imagem) { }