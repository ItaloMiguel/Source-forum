package forum.source.api.aplicacao.exceptions;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super("Não foi encontrado nem um tópico com esse ID: " + message);
    }
}
