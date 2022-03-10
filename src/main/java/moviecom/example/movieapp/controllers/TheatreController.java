package moviecom.example.movieapp.controllers;


import moviecom.example.movieapp.model.Theatre;
import moviecom.example.movieapp.model.TheatreDB;
import moviecom.example.movieapp.service.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {


    @Autowired
    ITheatreService theatreService;

    //Admin can add theatre details
    @PostMapping("/admin/add1")
    public String addTheatreDetails(@RequestParam("accessId") int accessId, @RequestBody Theatre theatre) {
        int i = theatreService.theatre(accessId, theatre);
        if (i == 1) {
            return "Theatre Details Added Successfully";
        } else {
            return "Theatre Details Not added Successfully";
        }

    }

    //Gives list of all Theatre
    @GetMapping("/getAllTheaters")
    public List<TheatreDB> getAlltheaters() {
        return theatreService.getAllTheaters();
    }

    //Admin can update Theatre details
    @PutMapping("/admin/update")
    public String updateRoomDetails(@RequestParam("accessId") int accessId, @RequestParam("theatreId") int theatreId, String theatreName, String theatreLocation) {
        return theatreService.updateTheatreDetails(accessId, theatreId, theatreName, theatreLocation);
    }

    //Manager is able to  dlt theatre
    @DeleteMapping("/manager/disable1")
    public String deleteMovieDetails(@RequestParam("theatreId") int theatreId, @RequestParam("accessId") int accessId) {
        return theatreService.deleteTheatre(theatreId, accessId);
    }

    //Get theatre by id
    @GetMapping("/get1/{id}")
    public TheatreDB getById(@PathVariable("theatreId") int theatreId) {
        return theatreService.getTheatreById(theatreId);
    }

    @GetMapping("/getMovie/{movieName}")
    public TheatreDB getByMovieName(@PathVariable("movieName") String movieName) {
        return theatreService.getTheatreByName(movieName);
    }

    @GetMapping("/get1/{movieId}")
    public TheatreDB getBymovieId(@PathVariable("movieId") int movieId) {
        return theatreService.getTheatreByMovieId(movieId);
    }


}