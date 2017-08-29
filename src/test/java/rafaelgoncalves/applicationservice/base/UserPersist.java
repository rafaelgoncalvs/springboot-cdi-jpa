package rafaelgoncalves.applicationservice.base;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rafaelgoncalves.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserPersist {

    @PersistenceContext
    private EntityManager  entityManager;

    @Transactional
    public void persist(User user) {
        entityManager.persist(user);
    }
}
