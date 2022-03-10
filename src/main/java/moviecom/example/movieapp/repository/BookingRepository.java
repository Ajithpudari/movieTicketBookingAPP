package moviecom.example.movieapp.repository;


import moviecom.example.movieapp.constants.Constants;
import moviecom.example.movieapp.model.BookingDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository implements IbookingRepo {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean addBooking(BookingDB booking) {
        int createdRows = jdbcTemplate.update(Constants.ADD_BOOK, booking.getBId(), booking.getUserId(), booking.getTheatreId(), booking.getMovieId(), booking.getMovieName(), booking.getPrice(), booking.getBookedTickets());
        return createdRows == 1;
    }

    @Override
    public BookingDB getBookingDetails(int bId) {
        return jdbcTemplate.queryForObject(Constants.GET_BOOK, new Object[]{bId}, new
                BeanPropertyRowMapper<>(BookingDB.class));
    }

}


