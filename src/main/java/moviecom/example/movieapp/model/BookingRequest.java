package moviecom.example.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingRequest {
        private int bId;
        private int userId;
        private int theatreId;
        private int requiredTickets;

}
