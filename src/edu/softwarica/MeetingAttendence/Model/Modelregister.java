package edu.softwarica.MeetingAttendence.Model;

public class Modelregister {

    private String fname, lname, email, pass, address, gender, phone, avtime, unavtime, img;
    private byte[] img1;
    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;

    public byte[] getImg1() {
        return img1;
    }

    public void setImg1(byte[] img1) {
        this.img1 = img1;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvtime() {
        return avtime;
    }

    public void setAvtime(String avtime) {
        this.avtime = avtime;
    }

    public String getUnavtime() {
        return unavtime;
    }

    public void setUnavtime(String unavtime) {
        this.unavtime = unavtime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
