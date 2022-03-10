package moviecom.example.movieapp.model;

import org.springframework.http.HttpStatus;

public class AppResponse {
    private int status;
    private boolean success;
    private Object data;

    public AppResponse(int status, boolean success, Object data) {
        this.status = status;
        this.success = success;
        this.data = data;
    }

    public AppResponse(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return this.status == HttpStatus.OK.value();
    }

    public void setSuccess(boolean success) {
        this.success = this.status == HttpStatus.OK.value();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
