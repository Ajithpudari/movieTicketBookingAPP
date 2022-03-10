package moviecom.example.movieapp.service;


import moviecom.example.movieapp.constants.Constants;
import moviecom.example.movieapp.model.Movie;
import moviecom.example.movieapp.model.Registration;
import moviecom.example.movieapp.model.Theatre;
import moviecom.example.movieapp.model.TheatreDB;
import moviecom.example.movieapp.repository.IMoviesRepo;
import moviecom.example.movieapp.repository.IRegistrationRepository;
import moviecom.example.movieapp.repository.ITheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TheatreServiceImplementation implements ITheatreService {

    @Autowired
    IRegistrationRepository iRegistrationRepository;

    @Autowired
    ITheatreRepo theatreRepo;

    @Autowired
    IMoviesRepo moviesRepo;

    @Override
    public List<TheatreDB> getAllTheaters() {
        {
            return theatreRepo.getAllTheatrs();
        }
    }

    @Override
    public String deleteTheatre(int theatreId, int accessId) {
        Registration regDel = iRegistrationRepository.getOne(accessId);
        try {
            if (Objects.equals(regDel.getRole(), "manager")) {
                return theatreRepo.deleteThatre(theatreId, accessId);
            } else {
                return "You  Are Not The Manager";
            }
        } catch (NullPointerException e) {
            return Constants.USER_NOT;
        } catch (Exception e) {
            return "Something is Wrong";
        }
    }

    @Override
    public int theatre(int accessId, Theatre theatre) {
        Registration regAdd = iRegistrationRepository.getOne(accessId);
        //get movie details by movieId
        Movie movie = moviesRepo.getMovieById(theatre.getMovieId());
        TheatreDB theatreDB = new TheatreDB();
        theatreDB.setTheatreId(theatre.getTheatreId());
        theatreDB.setTheatreName(theatre.getTheatreName());
        theatreDB.setLocation(theatre.getLocation());
        theatreDB.setShowType(theatre.getShowType());
        theatreDB.setDate(theatre.getDate());
        theatreDB.setTickets(theatre.getTickets());
        theatreDB.setMovieId(theatre.getMovieId());
        theatreDB.setMovieName(movie.getMovieName());
        theatreDB.setMovieGenre(movie.getMovieGenre());
        if (Objects.equals(regAdd.getRole(), "admin")) {
            theatreRepo.theatre(accessId, theatreDB);
            return 1;
        } else return 0;
    }

    @Override
    public TheatreDB getTheatreById(int theatreId) {
        return theatreRepo.getTheatreById(theatreId);
    }

    @Override
    public String updateTheatreDetails(int accessId, int theatreId, String theatreName, String theatreLocation) {
        Registration regUpdate = iRegistrationRepository.getOne(accessId);

        try {
            if (Objects.equals(regUpdate.getRole(), "admin")) {
                return theatreRepo.updateTheatrs(accessId, theatreId, theatreName, theatreLocation);
            } else return "You are not an Admin";
        } catch (NullPointerException e) {
            return Constants.USER_NOT;
        } catch (Exception e) {
            return "Something Is Wrong";
        }
    }

    @Override
    public TheatreDB getTheatreByName(String movieName) {
        return theatreRepo.getTheatreByMovieName(movieName);
    }


    @Override
    public TheatreDB getTheatreByMovieId(int movieId) {
        return theatreRepo.getTheatreByMovieId(movieId);
    }


}
