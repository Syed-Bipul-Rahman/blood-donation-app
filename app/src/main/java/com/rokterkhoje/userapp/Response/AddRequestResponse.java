package com.rokterkhoje.userapp.Response;

public class AddRequestResponse {
    String status;
    String massage;

    public AddRequestResponse(String status, String massage) {
        this.status = status;
        this.massage = massage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
