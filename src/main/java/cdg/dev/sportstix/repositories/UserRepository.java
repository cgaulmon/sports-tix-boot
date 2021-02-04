package cdg.dev.sportstix.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cdg.dev.sportstix.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserId(String userId);
}
