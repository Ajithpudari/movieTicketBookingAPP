package moviecom.example.movieapp.service;


import moviecom.example.movieapp.model.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> getAllMovies(int accessId);

    String updateMovieDetails(int accessId, int id, String date, String roomNo, String availability);

    String deleteMovie(int id, int accessId);

    int movie(int accessId, Movie movie);

    Movie getMovieById(int movieId);
}
