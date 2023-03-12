package com.rokterkhoje.userapp.Models;

public class DataModel {
    int pid;
    String blood_group,hospital_area,details,location,status_time,phone;

    public DataModel(int pid, String blood_group, String hospital_area, String details, String location, String status_time, String phone) {
        this.pid = pid;
        this.blood_group = blood_group;
        this.hospital_area = hospital_area;
        this.details = details;
        this.location = location;
        this.status_time = status_time;
        this.phone = phone;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getHospital_area() {
        return hospital_area;
    }

    public void setHospital_area(String hospital_area) {
        this.hospital_area = hospital_area;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus_time() {
        return status_time;
    }

    public void setStatus_time(String status_time) {
        this.status_time = status_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
