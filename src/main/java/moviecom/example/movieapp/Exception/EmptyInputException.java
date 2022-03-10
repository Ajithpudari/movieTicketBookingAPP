package moviecom.example.movieapp.Exception;

public class EmptyInputException extends RuntimeException{

    private static final long serialVersionID = 1l;
    private Integer errorCode;
    private String errorMessage;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public  static long getSerialVersionID(){
        return serialVersionID;
    }
    public EmptyInputException(Integer errorCode, String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public EmptyInputException(){

    }
}
