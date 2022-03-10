package moviecom.example.movieapp.service;


import moviecom.example.movieapp.model.Show;

import java.util.List;

public interface IShowService {

    List<Show>getAllShows(int accessId);

    String deleteShow(int showId, int accessId);

    int show(int accessId, Show show);

    Show getShowById( int theatreId);

    String updateShow(int accessId, int showId, String showName);
}
