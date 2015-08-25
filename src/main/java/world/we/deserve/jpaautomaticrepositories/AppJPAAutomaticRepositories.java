/**
 * 
 */
package world.we.deserve.jpaautomaticrepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import world.we.deserve.dao.repository.ConceptRepository;
import world.we.deserve.dao.repository.NihilistRepository;
import world.we.deserve.dto.jpa.Concept;
import world.we.deserve.dto.jpa.Nihilist;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@Component
public class AppJPAAutomaticRepositories {
	
	@Autowired
	private ConceptRepository conceptRepository;
	
	@Autowired
	private NihilistRepository nihilistRepository;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(JPAAutomaticReposComponentScan.class);
		AppJPAAutomaticRepositories app = context.getBean(AppJPAAutomaticRepositories.class);
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
			
		Concept out = conceptRepository.save(concept);
		System.out.println(out.getConcept_Id());
		
		Nihilist n = nihilistRepository.findByUsernameAndFetchConceptsEagerly("rust");
		System.out.println(n.getUsername()+" "+n.getRage()+" "+n.getConcepts());
		
	}

}
