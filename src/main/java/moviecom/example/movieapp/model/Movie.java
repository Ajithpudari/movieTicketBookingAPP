package moviecom.example.movieapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {

    private int movieId;
    private String movieName;
    private String movieGenre;
    private String language;


}
