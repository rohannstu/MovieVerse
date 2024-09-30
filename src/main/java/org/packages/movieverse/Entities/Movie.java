package org.packages.movieverse.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.IDENTITY) used for sequential auto ID
    //generation in DB
    private Integer movieId;

    //Validations
    //DB level validation --> Application level validations
    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide movies title")
    private String title;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide Director name")
    private String director;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide Studio name")
    private String studio;

    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private Set<String> movieCast;

    @Column(nullable = false)
    @NotBlank(message = "Please provide release date")
    private Integer releaseYear;

    @Column(nullable = false)
    @NotBlank(message = "PLease provide poster name")
    private String poster;
}
