package moviecom.example.movieapp.repository;

import moviecom.example.movieapp.model.BookingDB;


public interface IbookingRepo {
    boolean addBooking(BookingDB booking);

    BookingDB getBookingDetails(int bId);

}
