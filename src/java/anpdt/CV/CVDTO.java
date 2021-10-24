/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anpdt.CV;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class CVDTO implements Serializable{
    private String username;
    private String image;
    private String birthday;
    private String fullname;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String job;
    private String expierence;
    private String education;
    private String certificate;

    public CVDTO() {
    }

    public CVDTO(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }
    


    public CVDTO(String username, String birthday, String fullname, String gender, String phoneNumber, String email, String address, String job, String expierence, String education, String certificate, String image) {
        this.username = username;
        this.birthday = birthday;
        this.fullname = fullname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.job = job;
        this.expierence = expierence;
        this.education = education;
        this.certificate = certificate;
        this.image = image;
    }

    public CVDTO(String username, String birthday, String fullname, String phoneNumber, String email, String address, String job, String expierence, String education, String certificate) {
        this.username = username;
        this.birthday = birthday;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.job = job;
        this.expierence = expierence;
        this.education = education;
        this.certificate = certificate;
    }

    public CVDTO(String username, String birthday, String fullname, String gender, String phoneNumber, String email, String address, String job, String expierence, String education, String certificate) {
        this.username = username;
        this.birthday = birthday;
        this.fullname = fullname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.job = job;
        this.expierence = expierence;
        this.education = education;
        this.certificate = certificate;
    }
    
    
    
    
    
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addfress) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getExpierence() {
        return expierence;
    }

    public void setExpierence(String expierence) {
        this.expierence = expierence;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    
    
    
}
