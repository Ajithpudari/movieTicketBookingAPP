package moviecom.example.movieapp.controllers;


import moviecom.example.movieapp.model.BookingRequest;
import moviecom.example.movieapp.model.BookingResponse;
import moviecom.example.movieapp.repository.ITheatreRepo;
import moviecom.example.movieapp.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    IBookingService iBookingService;

    @Autowired
    ITheatreRepo iTheatreRepo;


    @PostMapping("/book")
    public String Book(@RequestBody BookingRequest bookingRequest) {
        return iBookingService.addBooking(bookingRequest);

    }

    @GetMapping("/bookingList")
    public List<BookingRequest> allBookedList(@RequestParam("userId") int userId) {
        return iBookingService.bookedList(userId);
    }

    @GetMapping("/getBookingDetails/{bId}")
    public BookingResponse getBookingDetails(@PathVariable("bId") int bId) {
        return iBookingService.getBookingDetails(bId);
    }


}

