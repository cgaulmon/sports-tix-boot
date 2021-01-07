package cdg.dev.sportstix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cdg.dev.sportstix.entities.Sport;

public interface SportRepository extends JpaRepository<Sport, Long> {

}
