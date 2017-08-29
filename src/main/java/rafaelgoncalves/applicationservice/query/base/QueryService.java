package rafaelgoncalves.applicationservice.query.base;

public interface QueryService<R, Q extends Query> {
    R execute(Q q);
}
