package rafaelgoncalves.application.query.base;

public interface QueryService<R, Q extends Query> {
    R execute(Q q);
}
