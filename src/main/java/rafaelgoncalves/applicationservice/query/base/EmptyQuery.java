package rafaelgoncalves.applicationservice.query.base;

public class EmptyQuery implements Query {

    public static EmptyQuery create() {
        return new EmptyQuery();
    }
}
