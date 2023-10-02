package com.postApi;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostApiResponse<T> {
    private int status;
    private String mess;
    private String serviceName;
    private Body<T> body;

    public PostApiResponse(int status, String mess, String serviceName) {
        this.status = status;
        this.mess = mess;
        this.serviceName = serviceName;
        this.body = new Body<>();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Body<T> getBody() {
        return body;
    }

    public void setBody(Body<T> body) {
        this.body = body;
    }

    public static class Body<T> {
        private T data;
        private String error;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setLData(T postEntities){
            this.data=postEntities;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
