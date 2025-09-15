package org.example.movieapi.Auth.repository;

import org.example.movieapi.Auth.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

}