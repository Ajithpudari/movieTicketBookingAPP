package moviecom.example.movieapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Registration {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
}
