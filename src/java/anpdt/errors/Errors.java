/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anpdt.errors;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Errors implements Serializable{
    private String wrongUsernamePassword;
    private String usernameLengthErr;
    private String usernameIsExisted;
    private String passwordLengthErr;
    private String confirmNotMatched;
    private String fullnameLengthErr;
    private String notCheckedAcceptBox;
    
    public String getWrongUsernamePassword() {
        return wrongUsernamePassword;
    }

    public void setWrongUsernamePassword(String wrongUsernamePassword) {
        this.wrongUsernamePassword = wrongUsernamePassword;
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmNotMatched() {
        return confirmNotMatched;
    }

    public void setConfirmNotMatched(String confirmNotMatched) {
        this.confirmNotMatched = confirmNotMatched;
    }

    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    public String getNotCheckedAcceptBox() {
        return notCheckedAcceptBox;
    }

    public void setNotCheckedAcceptBox(String notCheckedAcceptBox) {
        this.notCheckedAcceptBox = notCheckedAcceptBox;
    }
    
    

    public Errors() {
    }


    
    
}
