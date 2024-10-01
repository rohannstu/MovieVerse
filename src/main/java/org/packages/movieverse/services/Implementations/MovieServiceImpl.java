package org.packages.movieverse.services.Implementations;

import org.packages.movieverse.Entities.Movie;
import org.packages.movieverse.Repositories.MovieRepository;
import org.packages.movieverse.dto.MovieDto;
import org.packages.movieverse.services.FileService;
import org.packages.movieverse.services.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final FileService fileService = new FileServiceImpl();

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Value("${project.poster}")
    private String path;

    @Value("${base.url}")
    private String baseUrl;

    @Override
    public MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException {
        //1. upload the file
        String uploadedFileName = fileService.uploadFile(path, file);
        //2. set the field 'poster' as filename
        movieDto.setPoster(uploadedFileName);
        //3. map dto to movie object
        Movie movie = new Movie(
                movieDto.getMovieId(),
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );
        //4. save the movie object --> Saved movie object
        Movie savedMovie = movieRepository.save(movie);

        //5. generate the posterUrl
        String posterUrl = baseUrl + "/file" + uploadedFileName;

        //6. map movie object to DTO object and return it
        MovieDto response = new MovieDto(
                savedMovie.getMovieId(),
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getStudio(),
                savedMovie.getMovieCast(),
                savedMovie.getReleaseYear(),
                savedMovie.getPoster(),
                posterUrl
        );
        return response;
    }

    @Override
    public MovieDto getMovie(Integer movieId) {
        return null;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return List.of();
    }
}
