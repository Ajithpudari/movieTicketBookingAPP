package moviecom.example.movieapp.service;

import moviecom.example.movieapp.model.*;
import moviecom.example.movieapp.repository.IMoviesRepo;
import moviecom.example.movieapp.repository.IRegistrationRepository;
import moviecom.example.movieapp.repository.ITheatreRepo;
import moviecom.example.movieapp.repository.IbookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    IRegistrationRepository iRegistrationRepository;

    @Autowired
    ITheatreRepo iTheatreRepo;

    @Autowired
    IMoviesRepo moviesRepo;

    @Autowired
    IbookingRepo ibookingRepo;

    @Override
    public List<BookingRequest> bookedList(int userId) {
        return null;
    }


    @Override
    public int deleteBooking(int bId) {
        return 0;
    }

    @Override
    public String addBooking(BookingRequest bookingRequest) {

        Random rand = new Random();
        int randomId = rand.nextInt(10000);
        bookingRequest.setBId(randomId);
        Registration reg1 = iRegistrationRepository.getOne(bookingRequest.getUserId());
        if (reg1 != null) {
            TheatreDB theatre = iTheatreRepo.getTheatreById(bookingRequest.getTheatreId());
            /*if (bookingRequest.getRequiredTickets() <= theatre.getTickets()) {*/
                Movie movie = moviesRepo.getMovieById(theatre.getMovieId());
                BookingDB bookingDB = new BookingDB();
                bookingDB.setBId(bookingRequest.getBId());
                bookingDB.setUserId(bookingRequest.getUserId());
                bookingDB.setTheatreId(bookingRequest.getTheatreId());
                bookingDB.setMovieId(theatre.getMovieId());
                bookingDB.setMovieName(movie.getMovieName());
                //Logic for Ticket prices
                int oneTicketCost = 100;
                int totalBookedTicketsCost = (bookingRequest.getRequiredTickets() * oneTicketCost);
                bookingDB.setBookedTickets(bookingRequest.getRequiredTickets());
                bookingDB.setPrice(totalBookedTicketsCost);
                boolean isBooked = ibookingRepo.addBooking(bookingDB);
                if (isBooked) {
                    iTheatreRepo.updateTickets(theatre.getTheatreId(), bookingRequest.getRequiredTickets());
                    return "Successfully Booked the Ticket your Id : " + bookingRequest.getBId();
                } else {
                    return "Fail";
                }
            /*} else
                return "Tickets not available, Available tickets are " + theatre.getTickets();*/
        } else
            return "You are not a user";
    }

    @Override
    public BookingResponse getBookingDetails(int bId) {
        BookingDB bookingDB = ibookingRepo.getBookingDetails(bId);
        Registration registration = iRegistrationRepository.getOne(bookingDB.getUserId());
        TheatreDB theatreDB = iTheatreRepo.getTheatreById(bookingDB.getTheatreId());
        BookingResponse response = new BookingResponse();
        response.setBId(bId);
        response.setUserName(registration.getFirstName());
        response.setTheatreName(theatreDB.getTheatreName());
        response.setLocation(theatreDB.getLocation());
        response.setMovieName(theatreDB.getMovieName());
        response.setDate(theatreDB.getDate());
        response.setShowType(theatreDB.getShowType());
        response.setBookedTickets(bookingDB.getBookedTickets());
        response.setPrice(bookingDB.getPrice());
        return response;
    }


}
