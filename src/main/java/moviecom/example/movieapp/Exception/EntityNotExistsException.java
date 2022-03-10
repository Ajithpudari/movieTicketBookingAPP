package moviecom.example.movieapp.Exception;


public class EntityNotExistsException extends RuntimeException {


    private static final long serialVersionID = 1l;
    private int errorCode;
    private String errorMessage;


    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public static long getSerialVersionID() {
        return serialVersionID;
    }


    public EntityNotExistsException(Integer errorCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
    public EntityNotExistsException(){

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
