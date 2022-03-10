package moviecom.example.movieapp.repository;


import moviecom.example.movieapp.constants.Constants;
import moviecom.example.movieapp.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviesRepository implements IMoviesRepo {

    @Autowired
    JdbcTemplate template;

    @Override
    public int movie(int accessId, Movie movie) {

        String query = Constants.CREATE_MOVIE;
        return template.update(query, movie.getMovieId(), movie.getMovieName(), movie.getMovieGenre(), movie.getLanguage());
    }

    @Override
    public Movie getMovieById(int id) {
        String query = Constants.SELECT_MOVIES;
        Movie movie = template.queryForObject(query, new Object[]{id}, new
                BeanPropertyRowMapper<>(Movie.class));
        return movie;
    }

    @Override
    public List<Movie> getAllMovies(int accessId) {
        List<Movie> movies = template.query("select movieId, movieName ,movieGenre,language from movie", (result, rowNum) -> new Movie(result.getInt("movieId"),
                result.getString("movieName"), result.getString("movieGenre"), result.getString("language")));
        return movies;
    }

    @Override
    public String updateMovieDetails(int accessId, int movieId, String movieName, String movieGenre, String language) {
        String query = Constants.UPDATE_MOVIE;
        template.update(query, movieId, movieName, movieGenre, movieId);
        return "Movie: " + movieId + " details updated";
    }



    @Override
    public String deleteMovie(int id, int accessId) {
        String query = Constants.DELETE_MOVIE;
        template.update(query, accessId);
        return "Deleted Room Details with id :" + accessId;
    }
}



/* public int addMovie(int id,String date,int ,String availability) {
        String query = "INSERT INTO new_table VALUES(?,?,?,?)";
        return template.update(query,id,date, roomNO, availability);
    }*/

/**/

