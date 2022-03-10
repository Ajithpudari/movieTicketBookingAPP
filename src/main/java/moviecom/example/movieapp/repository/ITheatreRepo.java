package moviecom.example.movieapp.repository;




import moviecom.example.movieapp.model.TheatreDB;

import java.util.List;

public interface ITheatreRepo {


    public int theatre(int accessId, TheatreDB theatreDB);

    public TheatreDB getTheatreById(int theatreId);


    String updateTheatrs(int accessId, int theatreId, String theatreName, String theatreLocation);

    String deleteThatre(int theatreId, int accessId);

    TheatreDB getTheatreByMovieName(String movieName);

    TheatreDB getTheatreByMovieId(int movieId);

    List<TheatreDB> getAllTheatrs();

    void updateTickets(int theatreId, int requiredTickets);
}
