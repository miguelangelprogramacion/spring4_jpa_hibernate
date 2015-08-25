/**
 * 
 */
package world.we.deserve.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import world.we.deserve.dto.jpa.Nihilist;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
public interface NihilistRepository extends JpaRepository<Nihilist, Long> {

	@Query("SELECT p FROM Nihilist p JOIN FETCH p.concepts WHERE p.username = (:username)")
	Nihilist findByUsernameAndFetchConceptsEagerly(@Param("username") String username);
}
