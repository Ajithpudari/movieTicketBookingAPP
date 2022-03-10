package moviecom.example.movieapp.repository;


import moviecom.example.movieapp.constants.Constants;
import moviecom.example.movieapp.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShowRepository implements IShowRepo {

    @Autowired
    JdbcTemplate template;


    @Override
    public int show(int accessId, Show show) {
        String query = Constants.CREATE_SHOW;
        return template.update(query, show.getShowId(), show.getShowName());
    }

    @Override
    public Show getShowById(int showId) {
        String query = Constants.SELECT_SHOW;
        Show show = template.queryForObject(query, new Object[]{showId}, new
                BeanPropertyRowMapper<>(Show.class));
        return show;
    }

    @Override
    public List<Show> getAllShows(int accessId) {
        List<Show>  show = template.query("select showId, showName , from show", (result, rowNum) -> new Show(result.getInt("showId"),
                result.getString("showName")));
        return show;
    }

    @Override
    public String updateShows(int accessId, int showId, String showName) {
        String query = Constants.UPDATE_THEATRE;
        template.update(query, showId, showName);
        return "Movie: " + showId+ " details updated";
    }

    @Override
    public String deleteShow(int showId, int accessId) {
        String query = Constants.DELETE_SHOW;
        template.update(query, accessId);
        return "Deleted theatre Details with id :" + accessId;
    }
}



