package moviecom.example.movieapp.controllers;


import moviecom.example.movieapp.model.Movie;
import moviecom.example.movieapp.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    IMovieService movieService;


    @PostMapping("/admin/add")
    public String addMovieDetails(@RequestParam("accessId") int accessId, @RequestBody Movie movie) {
        int i = movieService.movie(accessId, movie);
        if (i == 1) {
            return "movie Details Added Successfully";
        } else {
            return "movie Details Not added Successfully";
        }

    }

    //Gives list of all movies
    @GetMapping("/getallmovies")
    public List<Movie> getAllmovies(@RequestParam("accessId") int accessId) {
        return movieService.getAllMovies(accessId);
    }

    //Admin can update Movie details
    @PutMapping("/admin/update")
    public String updateRoomDetails(@RequestParam("accessId") int accessId, @RequestParam("id") int id, String date, String roomNo, String availability) {
        return movieService.updateMovieDetails(accessId, id, date, roomNo, availability);
    }


    @DeleteMapping("/manager/disable")
    public String deleteMovieDetails(@RequestParam("movieId") int movieId, @RequestParam("accessId") int accessId) {
        return movieService.deleteMovie(movieId, accessId);
    }

    //Get movie by id
    @GetMapping("/{id}")
    public Movie getById(@PathVariable("movieId") int movieId) {
        return movieService.getMovieById(movieId);
    }

}