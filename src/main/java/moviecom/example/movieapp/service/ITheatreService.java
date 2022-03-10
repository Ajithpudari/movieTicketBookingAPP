package moviecom.example.movieapp.service;


import moviecom.example.movieapp.model.Theatre;
import moviecom.example.movieapp.model.TheatreDB;

import java.util.List;

public interface ITheatreService {


    String deleteTheatre(int theatreId, int accessId);

    int theatre(int accessId, Theatre theatre);

    TheatreDB getTheatreById(int theatreId);

    String updateTheatreDetails(int accessId, int theatreId, String theatreName, String theatreLocation);

    TheatreDB getTheatreByName(String movieName);

    TheatreDB getTheatreByMovieId(int movieId);


    List<TheatreDB> getAllTheaters();

}
