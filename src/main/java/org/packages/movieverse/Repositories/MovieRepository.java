package org.packages.movieverse.Repositories;

import org.packages.movieverse.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
