/**
 * 
 */
package cdg.dev.sportstix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cdg.dev.sportstix.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	@Query("select e from Event e where lower(e.name) like lower(concat('%', ?1,'%'))")
	List<Event> findAllByNameLike(String name);

}
