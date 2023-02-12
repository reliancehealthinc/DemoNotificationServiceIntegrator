package com.reliance.integratenotificationservicedemo.pojo;

import java.io.Serializable;

public class SpecificResponseEntity implements Serializable {

    int status;
    String message;
    Object data;

    public SpecificResponseEntity(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SpecificResponseEntity{" + "status='" + status + '\'' + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
