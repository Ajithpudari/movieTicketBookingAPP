package moviecom.example.movieapp.constants;

public class Constants {
    public static final String SELECT_REG_ROLE = "SELECT role FROM registration WHERE name =?";

    public static final String SELECT_REG = "SELECT * FROM registration WHERE ID=?";
    public static final String DELETE_REG = "DELETE FROM registration WHERE id=?";
    public static final String SELECT_REG_BY_ROLE = "SELECT id, firstName, lastName, phoneNumber ,role FROM registration WHERE role='user'";
    public static final String UPDATE_REG = "UPDATE registration SET firstName=?, lastName=?, phoneNumber=?  WHERE id=?";
    public static final String CREATE_REG = "INSERT INTO registration VALUES(?,?,?,?,?)";

    public static final String CREATE_MOVIE = "INSERT INTO movie VALUES(?,?,?,?)";
    public static final String UPDATE_MOVIE = "update movie set movieId = ?,movieName = ?,movieGenre = ?,language = ? where movieId = ?";
    public static final String DELETE_MOVIE = "delete from movie where movieId =?";
    public static final String SELECT_MOVIES = "SELECT * FROM movie WHERE movieId=?";

    public static final String CREATE_THEATRE = "INSERT INTO theatre VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_THEATRE = "update  set theatreId = ?,theatreName = ?,location = ?,date = ?,showType = ?,tickets = ?,movieId = ?,movieName = ?,movieGenre = ?,where theatreId = ?";
    public static final String DELETE_THEATRE = "delete from theatre where theatreId =?";
    public static final String SELECT_THEATRE = "SELECT * FROM theatre WHERE theatreID=?";
    public static final String GET_THEATRE = "SELECT * FROM theatre WHERE movieName=?";
    public static final String GETBYMID_THEATRE = "SELECT * FROM movie WHERE theatreID=?";
    public static final String UPDATE_TICKETS_THEATRE = "update theatre set tickets = ? where theatreId = ? ";
    public static final String CREATE_SHOW = "INSERT INTO show VALUES(?,?,?,?)";
    public static final String DELETE_SHOW = "delete from show where showId =?";
    public static final String SELECT_SHOW = "SELECT * FROM show WHERE showId=?";


    public static final String ADD_BOOK = "INSERT INTO bookingdb VALUES(?,?,?,?,?,?,?)";

    public static final String GET_BOOK = " SELECT * FROM bookingdb WHERE bId=?";

    public static final String USER_NOT = "User Details Not Found";

}
