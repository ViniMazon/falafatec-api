package br.com.pifalafatec.repository;

import br.com.pifalafatec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByRaOrEmail(String ra, String email);
    Optional<User> findByRa(String ra);
    Boolean existsByRa(String ra);
    Boolean existsByEmail(String email);
}