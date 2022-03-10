package moviecom.example.movieapp.service;


import moviecom.example.movieapp.Exception.EmptyInputException;
import moviecom.example.movieapp.Exception.EntityExistsException1;
import moviecom.example.movieapp.Exception.EntityNotExistsException;
import moviecom.example.movieapp.Exception.NotFoundException;
import moviecom.example.movieapp.model.AppResponse;
import moviecom.example.movieapp.model.Registration;
import moviecom.example.movieapp.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    IRegistrationRepository registrationRepo;

    @Override
    public ResponseEntity<Object> registration(Registration registration) {
        if (registration.getFirstName().length() != 0) {

            Registration registration1 = registrationRepo.getOne(registration.getId());

            if (registration1 == null) {
                int registrationId = registrationRepo.registration(registration);
                if (registrationId == 1) {

                    return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), true, "Register Success"), HttpStatus.OK);
                } else {

                    return new ResponseEntity<>(new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, "Not registered because Internal"), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                throw new EntityExistsException1(HttpStatus.BAD_REQUEST.value(), "Already Registered");
            }
        }
        throw new EmptyInputException(HttpStatus.BAD_REQUEST.value(), "provide a proper name");
    }


    @Override
    public ResponseEntity<Object> getOne(int id) {
        //   try {

        Registration registration = registrationRepo.getOne(id);
        if (registration != null)
            return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), "Success"), HttpStatus.OK);
        else
            throw new NotFoundException(HttpStatus.NOT_FOUND.value(), "User Not Found");

    }
    //}

    @Override
    public ResponseEntity<Object> delete(int id, int usrId) {

        Registration reg = registrationRepo.getOne(id);
        if (reg == null)
            throw new NotFoundException(HttpStatus.NOT_FOUND.value(), "User Not Found");

        if (Objects.equals(reg.getRole(), "admin") || Objects.equals(reg.getRole(), "manager")) {
            registrationRepo.delete(usrId);
            return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), "User deleted, userId = " + usrId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new AppResponse(HttpStatus.FORBIDDEN.value(), "You Are Not Authorised to do this action"), HttpStatus.FORBIDDEN);
        }

    }

    @Override
    public ResponseEntity<Object> allUsers(int id) {
        Registration registration = registrationRepo.getOne(id);
        if (Objects.equals(registration.getRole(), "admin") || Objects.equals(registration.getRole(), "manager")) {
            // return registrationRepo.allUsers();
            return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), registrationRepo.allUsers()), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(), new ArrayList<>()), HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<Object> updateUserById(int id, Registration registration) {

        Registration adminDetails = registrationRepo.getOne(id);
        if (registrationRepo.getOne(id) != null) {
            if (adminDetails != null && adminDetails.getRole().equals("admin")) {
                int i = registrationRepo.updatebyId(registration);
                if (i == 1) {
                    return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(), registrationRepo.updatebyId(registration)), HttpStatus.OK);
                }
                return new ResponseEntity<>(new AppResponse(HttpStatus.BAD_REQUEST.value(), "user not updated"), HttpStatus.BAD_REQUEST);
            } else {
                throw new NotFoundException(HttpStatus.FORBIDDEN.value(), "you are not Authorised");
            }
        }
        throw new EntityNotExistsException(HttpStatus.NOT_FOUND.value(), "Entity Not found in db");

    }
}
