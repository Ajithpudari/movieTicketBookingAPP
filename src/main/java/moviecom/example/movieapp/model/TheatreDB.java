package moviecom.example.movieapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TheatreDB {

    private int theatreId;
    private String theatreName;
    private  String location;
    private String date;
    private String showType;
    private int tickets;
    private int movieId;
    private String  movieName;
    private String movieGenre;

}
