package forum.source.api.dominio.topicos;

import ch.qos.logback.classic.spi.LoggingEventVO;
import forum.source.api.aplicacao.topicos.payload.CriarNovoTopicoRequest;
import forum.source.api.dominio.users.UserModel;

public class TopicosFactory {

    private Topicos topicos;

    public TopicosFactory execute(CriarNovoTopicoRequest request) {
        this.topicos = new Topicos(request);
        return this;
    }

    public Topicos build() {
        return this.topicos;
    }
}
