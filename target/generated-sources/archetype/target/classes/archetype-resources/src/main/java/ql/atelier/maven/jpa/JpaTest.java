#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.maven.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ${package}.Adresse;
import ${package}.Department;
import ${package}.Employe;
import ${package}.Projet;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEmployees();
		} catch (Exception e) {
			System.out.println("Employés errors : ");
			e.printStackTrace();
		}
		tx.commit();
		
		tx.begin();
		try{
			test.createProjets();
		}catch(Exception e){
			System.out.println("Projets errors : ");
			e.printStackTrace();
		}
        tx.commit();
        
		test.listEmployees();
		test.listProjets();

		System.out.println(".. Terminé");
	}




	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select e From Employe e", Employe.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("Master Qualité Du Logiciel");
			manager.persist(department);
            Adresse adresse1 = new Adresse("Vestibulum egestas sollicitudin augue, eu."
                                          +"Vestibulum ut sapien odio. Suspendisse ligula lectus, cursus id purus.");
            Adresse adresse2 = new Adresse("In id posuere ante, facilisis."
                                          +"Nullam congue metus eu accumsan tincidunt. In consequat.");
            Adresse adresse3=  new Adresse("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce a.");
            
            Employe employe1 = new Employe("Dumzhuo Tsauch aa2aa1",department);
            employe1.setAdresse(adresse1);
            Employe employe2 = new Employe("Nifoizfii Tramaa3",department);
            employe2.setAdresse(adresse2);
            Employe employe3 = new Employe("Uha Dhizaddaaa2aa1aa3",department);
            employe3.setAdresse(adresse3);
            Employe employe4 = new Employe("Faencapom Zhaingham aa1",department);
            employe4.setAdresse(new Adresse("Vivamus accumsan purus vitae condimentum varius. Proin accumsan maximus sem et."));
            Employe employe5 = new Employe("Baakhaad Ghishaadaa1",department);
            employe5.setAdresse(new Adresse("Pellentesque auctor, ante quis euismod."));
            
			manager.persist(employe1);
			manager.persist(employe2);
			manager.persist(employe3);
			manager.persist(employe4);
			manager.persist(employe5);

		}
	}

	private void createProjets() {
		
		List <Employe> employees1  = manager.createQuery("Select e From Employe e where e.name like '%aa1%'", Employe.class).getResultList();
		List <Employe> employees2  = manager.createQuery("Select e From Employe e where e.name like '%aa2%'", Employe.class).getResultList();
		List <Employe> employees3  = manager.createQuery("Select e From Employe e where e.name like '%aa3%'", Employe.class).getResultList();
		
		int nbrProjets = manager.createQuery("Select p From Projet p", Projet.class).getResultList().size();
		if (nbrProjets == 0) {
			Projet projet1 = new Projet();
			projet1.setName("Lorem ipsum dolor sit amet");
			projet1.setEmployees(employees1);
			
			Projet projet2 = new Projet();
			projet2.setName("Suspendisse in risus vitae augue");
			projet2.setEmployees(employees2);
			
			Projet projet3 = new Projet();
			projet3.setName("Sed suscipit ligula vitae feugiat");
			projet3.setEmployees(employees3);
			
			manager.persist(projet1);
			manager.persist(projet2);
			manager.persist(projet3);
		}
	}
	
	private void listEmployees() {
		List<Employe> resultList = manager.createQuery("Select a From Employe a", Employe.class).getResultList();
		System.out.println("nombre Employés :" + resultList.size());
		for (Employe next : resultList) {
			System.out.println("- " + next);
		}
	}
	
	private void listProjets() {
		System.out.println("${symbol_escape}n");
		List<Projet> resultList = manager.createQuery("Select p From Projet p", Projet.class).getResultList();
		System.out.println("nombre Projets :" + resultList.size());
		for (Projet next : resultList) {
			System.out.println("- " + next);
		}
	}


}
