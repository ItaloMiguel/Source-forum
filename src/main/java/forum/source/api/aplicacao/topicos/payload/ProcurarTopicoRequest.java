package forum.source.api.aplicacao.topicos.payload;

import jakarta.validation.constraints.Size;

public record ProcurarTopicoRequest(
        @Size(min = 5, max = 80)
        String title
) {
}
