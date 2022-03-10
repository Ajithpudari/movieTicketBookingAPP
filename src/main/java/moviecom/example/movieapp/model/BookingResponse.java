package moviecom.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingResponse {

    private int bId;
    private String userName;
    private String theatreName;
    private String location;
    private String movieName;
    private String date;
    private String showType;
    private int bookedTickets;
    private int price;
}
