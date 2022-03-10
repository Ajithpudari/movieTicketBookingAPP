package moviecom.example.movieapp.controllers;


import moviecom.example.movieapp.model.Show;
import moviecom.example.movieapp.service.IShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {


    @Autowired
    IShowService showService;

    //Admin can add shows details
    @PostMapping("/admin/add1")
    public String addShowDetails(@RequestParam("accessId") int accessId, @RequestBody Show show) {
        int i = showService.show(accessId, show);
        if (i == 1) {
            return "show  Added Successfully";
        } else {
            return "show Not added Successfully";
        }

    }

    //Gives list of all shows
    @GetMapping("/getallshows")
    public List<Show> getAlltheaters(@RequestParam("accessId") int accessId) {
        return showService.getAllShows(accessId);
    }

    //Admin can update Theatre details
    @PutMapping("/admin/update")
    public String updateShow(@RequestParam("accessId") int accessId, @RequestParam("showId") int showId, String showName) {
        return showService.updateShow(accessId, showId, showName);
    }

    //Manager is able to  dlt theatre
    @DeleteMapping("/manager/disable1")
    public String deleteShowDetails(@RequestParam("showId") int showId, @RequestParam("accessId") int accessId) {
        return showService.deleteShow(showId, accessId);
    }

    //Get theatre by id
    @GetMapping("/get1/{id}")
    public Show getByshowId(@PathVariable("showId") int showId) {
        return showService.getShowById(showId);
    }

}