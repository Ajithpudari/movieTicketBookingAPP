package moviecom.example.movieapp.repository;


import moviecom.example.movieapp.model.Movie;

import java.util.List;

public interface IMoviesRepo {


    public int movie(int accessId, Movie movie);

    public Movie getMovieById(int id);


    List<Movie> getAllMovies(int accessId);


    String updateMovieDetails(int accessId, int movieId, String movieName, String movieGenre, String language);

    String deleteMovie(int id, int accessId);

}
