package moviecom.example.movieapp.repository;


import moviecom.example.movieapp.constants.Constants;
import moviecom.example.movieapp.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationRepository implements IRegistrationRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int registration(Registration registration) {
        String query = Constants.CREATE_REG;
        try {
            return jdbcTemplate.update(query, registration.getId(), registration.getFirstName(), registration.getLastName(), registration.getPhoneNumber(), registration.getRole());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public Registration getOne(int id) {
        String query = Constants.SELECT_REG;
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{id}, new
                    BeanPropertyRowMapper<>(Registration.class));

        } catch (Exception e) {

          return null;
        }
    }

    @Override
    public String delete(int id) {
        String query = Constants.DELETE_REG;
        int deleted = jdbcTemplate.update(query, id);
        return deleted == 1 ? "success" : "Failure";
    }

    @Override
    public List<Registration> allUsers() {
        {
            return jdbcTemplate.query(Constants.SELECT_REG_BY_ROLE, (result, rowNum) -> new Registration(result.getInt("id"),
                    result.getString("firstName"), result.getString("lastName"), result.getString("phoneNumber"), result.getString("role")));
        }
    }

    @Override
    public int updatebyId(Registration registration) {
        return jdbcTemplate.update(Constants.UPDATE_REG,
                registration.getFirstName(), registration.getLastName(), registration.getPhoneNumber(), registration.getId());
    }

}
