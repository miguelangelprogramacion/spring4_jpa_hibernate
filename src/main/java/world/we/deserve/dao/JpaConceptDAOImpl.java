/**
 * 
 */
package world.we.deserve.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import world.we.deserve.dto.jpa.Concept;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@Repository
@Transactional
public class JpaConceptDAOImpl {

	@PersistenceContext
	private EntityManager em;
	
	public void addConcept(Concept concept)
	{
		try
		{
			em.persist(concept);
		
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}		
	}

	public Concept getConceptById(Integer id)
	{
		return em.find(Concept.class, id);
	}
	
	public void saveConcept(Concept concept)
	{
		em.merge(concept);
	}
}
