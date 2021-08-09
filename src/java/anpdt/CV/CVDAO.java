/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anpdt.CV;

import anpdt.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class CVDAO implements Serializable {

    private CVDTO UserCV;
    
    public CVDTO getUserCV(){
        return this.UserCV;
    }
    
    public void uploadInfor(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "select birthday,fullname,gender,phoneNumber,email,address,job,expierence,education,certificate from CV where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if(rs.next()){
//                    String ID = rs.getString("username");
//                    Byte image = rs.getByte("image");
                    String birthday = rs.getString("birthday");
                    String fullname = rs.getString("fullname");
                    String gender = rs.getString("gender");
                    String phoneNumber = rs.getString("phoneNumber");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String job = rs.getString("job");
                    String expierence = rs.getString("expierence");
                    String education = rs.getString("education");
                    String certificate = rs.getString("certificate");
                    
                    CVDTO cvDTO = new CVDTO(birthday, fullname, gender, phoneNumber, email, address, job, expierence, education, certificate);
                    this.UserCV = cvDTO;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
}
