package az.maqa.criteriaapi.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import az.maqa.criteriaapi.model.Market;

public class CriteriaApiPaging {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Market> criteriaQuery = criteriaBuilder.createQuery(Market.class);

		Root<Market> root = criteriaQuery.from(Market.class);
		criteriaQuery.select(root);
		
		int pageNumber = 1;
		int pageSize = 3;
		
		TypedQuery<Market> query = entityManager.createQuery(criteriaQuery);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		
		List<Market> markets = query.getResultList();

		markets.stream().forEach(m -> System.out.println(m));
	}
}
