package moviecom.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDB {

        private int bId;
        private int userId;
        private int theatreId;
        private int movieId;
        private String movieName;
        private int price;
        private int bookedTickets;

}
