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

    public String getWrongUsernamePassword() {
        return wrongUsernamePassword;
    }

    public void setWrongUsernamePassword(String wrongUsernamePassword) {
        this.wrongUsernamePassword = wrongUsernamePassword;
    }
    

    public Errors() {
    }


    
    
}
