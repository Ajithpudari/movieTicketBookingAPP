package moviecom.example.movieapp.repository;


import moviecom.example.movieapp.model.Show;

import java.util.List;

public interface IShowRepo {


    public int show(int accessId, Show show);

    public Show getShowById(int showId);


    List<Show> getAllShows(int accessId);


    String updateShows(int accessId, int showId, String showName);

    String deleteShow(int showId, int accessId);

}
