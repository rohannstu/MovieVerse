package org.packages.movieverse.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer movieId;

    @NotBlank(message = "Please provide movies title")
    private String title;

    @NotBlank(message = "Please provide Director name")
    private String director;

    @NotBlank(message = "Please provide Studio name")
    private String studio;

    private Set<String> movieCast;

    private Integer releaseYear;

    @NotBlank(message = "PLease provide poster name")
    private String poster;

    @NotBlank(message = "PLease provide poster's url")
    private String posterUrl;
}
