/**
 * 
 */
package world.we.deserve.jpaautomaticrepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import world.we.deserve.dao.JpaConceptDAOImpl;
import world.we.deserve.dto.jpa.Concept;
import world.we.deserve.jpabasicsample.App;
import world.we.deserve.jpabasicsample.JPAComponentScan;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@Component
public class AppJPAAutomaticRepositories {

	@Autowired
	private JpaConceptDAOImpl injectionStrategy;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JPAAutomaticReposComponentScan.class);
    	App app = context.getBean(App.class);
		app.insertSyntheticConcept();
	}
	
	/**
	 * 
	 */
	public void insertSyntheticConcept() {
		Concept concept = new Concept();
		concept.setAbstract_("abstract");
		concept.setResume("resume");
//		concept.setGood(new byte[] {(byte)0,});
		
		injectionStrategy.addConcept(concept);		
		
		concept = injectionStrategy.getConceptById(new Integer(1));
		System.out.println(concept.getAbstract_());
	}

}
