package springbootcdijpa.infra.repository;

import springbootcdijpa.domain.User;
import springbootcdijpa.domain.UserRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Named
public class UserJpaRepository implements UserRepository {

	private EntityManager entityManager;

	@Inject
    public UserJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
