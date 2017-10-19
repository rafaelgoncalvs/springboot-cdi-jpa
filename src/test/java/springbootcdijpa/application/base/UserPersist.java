package springbootcdijpa.application.base;

import org.springframework.transaction.annotation.Transactional;
import springbootcdijpa.domain.User;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class UserPersist {

    @PersistenceContext
    private EntityManager  entityManager;

    @Transactional
    public void persist(User user) {
        entityManager.persist(user);
    }
}
