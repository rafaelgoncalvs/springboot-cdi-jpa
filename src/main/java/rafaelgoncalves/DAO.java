package rafaelgoncalves;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Named
public class DAO implements Repository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<EntityTest> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EntityTest> criteriaQuery = criteriaBuilder.createQuery(EntityTest.class);
		Root<EntityTest> root = criteriaQuery.from(EntityTest.class);
		criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
