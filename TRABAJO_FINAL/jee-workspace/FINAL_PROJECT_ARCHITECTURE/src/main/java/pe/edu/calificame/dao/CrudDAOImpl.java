package pe.edu.calificame.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class CrudDAOImpl
 */
@Stateless
@LocalBean
public class CrudDAOImpl implements CrudDAO {

	@PersistenceContext(unitName = "JPA_CALIFICAME")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CrudDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> void register(T obj) {
		em.persist(obj);
	}

	@Override
	public <T> void update(T obj) {
		em.merge(obj);
	}

	@Override
	public <T> void delete(T obj) {
		em.remove(em.merge(obj));
	}

}
