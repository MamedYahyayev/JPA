package az.maqa.criteriaapi.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import az.maqa.criteriaapi.model.Market;

public class CriteriaApiMain {


	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Market> criteriaQuery = criteriaBuilder.createQuery(Market.class); 

		Root<Market> root = criteriaQuery.from(Market.class);
		
		Path<Double> areaSize  = root.get("areaSize");
		Path<String> location  = root.get("location");
		
		double size = 211;
		
		criteriaQuery.select(root).where(criteriaBuilder.lessThanOrEqualTo(areaSize, size));
		
		criteriaQuery.select(root).where(criteriaBuilder.greaterThanOrEqualTo(areaSize, size));

		criteriaQuery.select(root).where(criteriaBuilder.equal(location, "E.Rehimov"));
		
		TypedQuery<Market> query = entityManager.createQuery(criteriaQuery);
		
		List<Market> markets = query.getResultList();
		
		markets.stream().forEach(m -> System.out.println(m));
		
	}

}
