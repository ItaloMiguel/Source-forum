package forum.source.api.aplicacao.topicos.payload;


import javax.validation.constraints.NotBlank;

public record CriarNovoTopicoRequest(
        @NotBlank(message = "Titulo não pode ser vazio")
        String titulo,
        String autor,
        @NotBlank(message = "Mensagem não pode ser vazio")
        String mensagem,
        String imagem) { }