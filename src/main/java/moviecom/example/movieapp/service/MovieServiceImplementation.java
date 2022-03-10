package moviecom.example.movieapp.service;



import moviecom.example.movieapp.constants.Constants;
import moviecom.example.movieapp.model.Registration;
import moviecom.example.movieapp.model.Movie;
import moviecom.example.movieapp.repository.IRegistrationRepository;
import moviecom.example.movieapp.repository.IMoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImplementation implements IMovieService {

    @Autowired
    IRegistrationRepository iRegistrationRepository;

    @Autowired
    IMoviesRepo iMoviesRepo;



    @Override
    public List<Movie> getAllMovies(int accessId) {
        Registration regGet = iRegistrationRepository.getOne(accessId);
        if (Objects.equals(regGet.getRole(), "user") || Objects.equals(regGet.getRole(), "admin") || Objects.equals(regGet.getRole(), "manager")) {
            return iMoviesRepo.getAllMovies(accessId);
        } else return new ArrayList<>();
    }

    @Override
    public String updateMovieDetails(int accessId, int movieId, String movieName, String movieGenre, String language) {
        Registration regUpdate = iRegistrationRepository.getOne(accessId);

        try {
            if (Objects.equals(regUpdate.getRole(), "admin")) {
                return iMoviesRepo.updateMovieDetails(accessId, movieId, movieName, movieGenre, language);
            } else return "You are not an Admin";
        } catch (NullPointerException e) {
            return Constants.USER_NOT;
        }
        catch (Exception e){
            return "Something Is Wrong";
        }

    }

    @Override
    public String deleteMovie(int id, int accessId) {
        Registration regDel = iRegistrationRepository.getOne(id);
        try {
            if (Objects.equals(regDel.getRole(), "manager")) {
                return iMoviesRepo.deleteMovie(id, accessId);
            } else {
                return "You  Are Not The Manager";
            }
        } catch (NullPointerException e) {
            return Constants.USER_NOT;
        }
        catch (Exception e){
            return "Something is Wrong";
        }
    }

    @Override
    public int movie(int accessId, Movie movie) {
        Registration regAdd = iRegistrationRepository.getOne(accessId);
        if (Objects.equals(regAdd.getRole(), "admin")) {
            iMoviesRepo.movie(accessId, movie);
            return 1;
        } else return 0;

    }
    @Override
    public Movie getMovieById(int id) {
        return iMoviesRepo.getMovieById(id);
    }

}
