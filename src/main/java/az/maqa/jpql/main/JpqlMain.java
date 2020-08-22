package az.maqa.jpql.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import az.maqa.jpql.model.Nurse;

public class JpqlMain {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

		EntityManager entityManager = factory.createEntityManager();

		// Queries

		Query query = entityManager.createQuery("Select n.name from Nurse n");

		Query maxSalary = entityManager.createQuery("Select MAX(n.salary) from Nurse n");

		Query minSalary = entityManager.createQuery("Select MIN(n.salary) from Nurse n");

		Query nurses = entityManager.createQuery("Select n from Nurse n");

		Query beetween = entityManager.createQuery("Select n from Nurse n where n.salary Between 200 and 1000");

		Query like = entityManager.createQuery("Select n from Nurse n where n.name LIKE '%a%'");

		Query orderByQuery = entityManager.createQuery("Select n from Nurse n  ORDER BY n.age ASC");
		
		

		// Named Query

		Query namedQuery = entityManager.createNamedQuery("find nurse by id");

		namedQuery.setParameter("id", 2L);
		
		Query namedQueryFindBySurname = entityManager.createNamedQuery("find nurse by surname");
		
		namedQueryFindBySurname.setParameter("surname", "Sabirov");

		// Initialization

		List<String> nurseNameList = query.getResultList();

		Double maxSalaryResult = (Double) maxSalary.getSingleResult();

		Double minSalaryResult = (Double) minSalary.getSingleResult();

		List<Nurse> nurseList = nurses.getResultList();

		List<Nurse> beetweenSalary = beetween.getResultList();

		List<Nurse> likeOperator = like.getResultList();

		List<Nurse> orderBy = orderByQuery.getResultList();

		Nurse namedQueryNurse = (Nurse) namedQuery.getSingleResult();
		
		Nurse findNurseBySurname  = (Nurse) namedQueryFindBySurname.getSingleResult();

		// Results
		nurseNameList.stream().forEach(System.out::println);

		System.out.println();
		
		System.out.println("Max Salary : " + maxSalaryResult);

		System.out.println();
		
		System.out.println("Min Salary : " + minSalaryResult);
		
		System.out.println();

		nurseList.stream().forEach(System.out::println);

		System.out.println();
		
		System.out.println("Beetween------------------Salary 200 and 1000");

		beetweenSalary.stream().forEach(System.out::println);

		System.out.println();
		
		System.out.println("Like------------------a character of the name");

		likeOperator.stream().forEach(System.out::println);

		System.out.println();
		
		System.out.println("Order By------------------ASC age");

		orderBy.stream().forEach(System.out::println);
		
		System.out.println();

		System.out.println("Named Query------------------find nurse by id");

		System.out.println(namedQueryNurse);
		
		System.out.println();
		
		System.out.println("Named Query------------------find nurse by surname");

		System.out.println(findNurseBySurname);
		
		entityManager.getTransaction().begin();
		
//		entityManager.createNativeQuery("Insert into Nurse(name,surname,age,salary) "
//				+ " VALUES (?,?,?,?)")
//				.setParameter(1, "Qasim")
//				.setParameter(2, "Qasimli")
//				.setParameter(3, 22)
//				.setParameter(4, 2500).executeUpdate();
		
		
		entityManager.createNativeQuery("Update Nurse SET name = ? , surname = ? , age = ? where id = ?")
						.setParameter(1, "Aslan")
						.setParameter(2, "Aslanov")
						.setParameter(3, 35)
						.setParameter(4, 6L)
						.executeUpdate();
		
		entityManager.getTransaction().commit();
		
		
		

	}

}
