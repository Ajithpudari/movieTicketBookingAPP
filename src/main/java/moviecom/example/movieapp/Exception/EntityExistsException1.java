package moviecom.example.movieapp.Exception;


public class EntityExistsException1 extends RuntimeException {


    private static final long serialVersionID = 1l;
    private int errorCode;
    private String errorMessage;

    public EntityExistsException1() {
        super();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public EntityExistsException1(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
