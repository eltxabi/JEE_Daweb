package data;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LibroDAO {
	private static final String PERSISTENCE_UNIT_NAME = "biblioteca";
    private static EntityManagerFactory factory;
  
		
	public LibroDAO() {
		super();
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Libro> getLibros() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select t from Libro t");
		
		ArrayList<Libro> libros = new ArrayList<Libro>(q.getResultList());
	    em.close();
		
	    return libros;
		
	}

	
	
	
}




