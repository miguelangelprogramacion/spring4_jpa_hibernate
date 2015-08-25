/**
 * 
 */
package world.we.deserve.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import world.we.deserve.dto.jpa.Concept;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
public interface ConceptRepository extends JpaRepository<Concept, Long> {

}