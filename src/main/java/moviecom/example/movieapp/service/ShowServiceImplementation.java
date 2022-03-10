package moviecom.example.movieapp.service;


import moviecom.example.movieapp.constants.Constants;
import moviecom.example.movieapp.model.Registration;
import moviecom.example.movieapp.model.Show;
import moviecom.example.movieapp.repository.IRegistrationRepository;
import moviecom.example.movieapp.repository.IShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ShowServiceImplementation implements IShowService {

    @Autowired
    IRegistrationRepository iRegistrationRepository;

    @Autowired
    IShowRepo showRepo;

    @Override
    public List<Show> getAllShows(int accessId) {
        Registration regGet = iRegistrationRepository.getOne(accessId);
        if (Objects.equals(regGet.getRole(), "user") || Objects.equals(regGet.getRole(), "admin") || Objects.equals(regGet.getRole(), "manager")) {
            return showRepo.getAllShows(accessId);
        } else return new ArrayList<>();
    }

    @Override
    public String deleteShow(int showId, int accessId) {
        Registration regDel = iRegistrationRepository.getOne(accessId);
        try {
            if (Objects.equals(regDel.getRole(), "manager")) {
                return showRepo.deleteShow(showId,accessId);
            } else {
                return "You  Are Not The Manager";
            }
        } catch (NullPointerException e) {
            return Constants.USER_NOT;
        }
        catch (Exception e){
            return "Something is Wrong";
        }
    }

    @Override
    public int show(int accessId, Show show) {
        Registration regAdd = iRegistrationRepository.getOne(accessId);
        if (Objects.equals(regAdd.getRole(), "admin")) {
            showRepo.show(accessId,show);
            return 1;
        } else return 0;
    }

    @Override
    public Show getShowById(int showId) {
        return showRepo.getShowById(showId);
    }

    @Override
    public String updateShow(int accessId, int showId, String showName) {
        Registration regUpdate = iRegistrationRepository.getOne(accessId);

        try {
            if (Objects.equals(regUpdate.getRole(), "admin")) {
                return showRepo.updateShows(accessId, showId, showName);
            } else return "You are not an Admin";
        } catch (NullPointerException e) {
            return Constants.USER_NOT;
        }
        catch (Exception e){
            return "Something Is Wrong";
        }


    }

}
