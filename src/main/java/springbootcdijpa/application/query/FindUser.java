package springbootcdijpa.application.query;

import springbootcdijpa.application.query.base.Query;

public class FindUser implements Query {

    private Long userId;

    public FindUser(Long userId) {
        this.userId = userId;
    }

    public Long userId() {
        return userId;
    }
}
