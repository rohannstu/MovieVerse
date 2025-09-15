package org.example.movieapi.Auth.repository;
import org.example.movieapi.Auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}