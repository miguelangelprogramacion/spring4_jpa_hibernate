package world.we.deserve.jpabasicsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import world.we.deserve.dao.JpaConceptDAOImpl;
import world.we.deserve.dto.jpa.Concept;

@Component
public class App 
{
	@Autowired
	private JpaConceptDAOImpl injectionStrategy;
	
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(JPAComponentScan.class);
    	App app = context.getBean(App.class);
		app.insertSyntheticConcept();
		
    	System.out.println("Nobody is dead until they are warm and dead");
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
