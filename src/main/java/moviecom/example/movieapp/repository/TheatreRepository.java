package moviecom.example.movieapp.repository;


import moviecom.example.movieapp.constants.Constants;
import moviecom.example.movieapp.model.TheatreDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheatreRepository implements ITheatreRepo {

    @Autowired
    JdbcTemplate template;


    @Override
    public int theatre(int accessId, TheatreDB theatreDB) {
        String query = Constants.CREATE_THEATRE;
        return template.update(query, theatreDB.getTheatreId(), theatreDB.getTheatreName(), theatreDB.getLocation(), theatreDB.getDate(), theatreDB.getShowType(), theatreDB.getTickets(), theatreDB.getMovieId(), theatreDB.getMovieName(), theatreDB.getMovieGenre());
    }

    @Override
    public TheatreDB getTheatreById(int theatreId) {
        String query = Constants.SELECT_THEATRE;
        TheatreDB theatreDB = template.queryForObject(query, new Object[]{theatreId}, new
                BeanPropertyRowMapper<>(TheatreDB.class));
        return theatreDB;
    }


    @Override
    public String updateTheatrs(int accessId, int theatreId, String theatreName, String location) {
        String query = Constants.UPDATE_THEATRE;
        template.update(query, theatreId, theatreName, location);
        return "Movie: " + theatreId + " details updated";
    }

    @Override
    public String deleteThatre(int theatreId, int accessId) {
        String query = Constants.DELETE_THEATRE;
        template.update(query, accessId);
        return "Deleted theatre Details with id :" + accessId;
    }

    @Override
    public TheatreDB getTheatreByMovieName(String movieName) {
        String query = Constants.GET_THEATRE;
        return template.queryForObject(query, new Object[]{movieName}, new
                BeanPropertyRowMapper<>(TheatreDB.class));
    }

    @Override
    public TheatreDB getTheatreByMovieId(int movieId) {
        String query = Constants.GETBYMID_THEATRE;
        TheatreDB theatreDB = template.queryForObject(query, new Object[]{movieId}, new
                BeanPropertyRowMapper<>(TheatreDB.class));
        return theatreDB;
    }

    @Override
    public List<TheatreDB> getAllTheatrs() {
        List<TheatreDB> theatreDBS = template.query("select theatreId, theatreName, location, date, showType, tickets, movieId, movieName, movieGenre from theatre", (result, rowNum) -> new TheatreDB(result.getInt("theatreId"),
                result.getString("theatreName"), result.getString("location"), result.getString("date"), result.getString("showType"), result.getInt("tickets"), result.getInt("movieId"), result.getString("movieName"), result.getString("movieGenre")));
        return theatreDBS;
    }

    @Override
    public void updateTickets(int theatreId, int requiredTickets) {
        template.update(Constants.UPDATE_TICKETS_THEATRE, requiredTickets, theatreId);
    }
}



