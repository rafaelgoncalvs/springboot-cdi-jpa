package rafaelgoncalves.infra.repository;

import rafaelgoncalves.domain.User;
import rafaelgoncalves.domain.UserRepository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Named
public class UserJpaRepository implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<User> getAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

    @Override
    public User get(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void remove(User user) {
        entityManager.remove(user);
    }
}
