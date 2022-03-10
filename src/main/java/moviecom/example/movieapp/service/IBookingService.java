package moviecom.example.movieapp.service;


import moviecom.example.movieapp.model.BookingRequest;
import moviecom.example.movieapp.model.BookingResponse;

import java.util.List;

public interface IBookingService {

    List<BookingRequest> bookedList(int userId);

    int deleteBooking(int bId);

    String addBooking(BookingRequest bookingRequest);

    BookingResponse getBookingDetails(int bId);

}
