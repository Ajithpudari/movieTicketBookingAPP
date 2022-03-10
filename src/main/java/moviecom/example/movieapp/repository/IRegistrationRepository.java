package moviecom.example.movieapp.repository;


import moviecom.example.movieapp.model.Registration;

import java.util.List;



public interface IRegistrationRepository {
    int registration(Registration registration);

    Registration getOne(int id);

    String delete(int id);


    List<Registration> allUsers();

    int updatebyId(Registration registration);


}
