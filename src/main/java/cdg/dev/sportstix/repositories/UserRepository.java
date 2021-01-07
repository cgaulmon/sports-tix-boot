package cdg.dev.sportstix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cdg.dev.sportstix.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
