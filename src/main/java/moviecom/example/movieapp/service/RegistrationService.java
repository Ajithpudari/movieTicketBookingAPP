package moviecom.example.movieapp.service;


import moviecom.example.movieapp.model.Registration;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {


    ResponseEntity<Object> registration(Registration registration);

    ResponseEntity<Object> getOne(int id);

    public ResponseEntity<Object> delete(int id, int usrId);

    public ResponseEntity<Object> allUsers(int id);

    public ResponseEntity<Object> updateUserById(int id, Registration registration);

}
