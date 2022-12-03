package forum.source.api.aplicacao.topicos.payload;

public record AtualizarTopicoRequest(
        String titulo,
        String mensagem,
        String imagem) {
}
