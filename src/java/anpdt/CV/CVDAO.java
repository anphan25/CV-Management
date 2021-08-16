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

    public CVDTO getUserCV() {
        return this.UserCV;
    }

    public void uploadInfor(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select username,birthday,fullname,gender,phoneNumber,email,address,job,expierence,education,certificate from CV where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String ID = rs.getString("username");
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

                    CVDTO cvDTO = new CVDTO(ID, birthday, fullname, gender, phoneNumber, email, address, job, expierence, education, certificate);
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

    private ArrayList<CVDTO> accounts;

    public ArrayList<CVDTO> getAccoutns() {
        return accounts;
    }

    public void loadAccounts() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select username, fullname from Registration";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String fullname = rs.getString("fullname");
                    CVDTO dto = new CVDTO(username, fullname);
                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    }
                    this.accounts.add(dto);
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

    public boolean isAdmin(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select role from Registration where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    if (role.equals("Admin")) {
                        return true;
                    }
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
        return false;
    }

    public boolean updateInfo(CVDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "Update CV SET fullname =?, birthday =?, phoneNumber =?, email =?, address =?, job =?, expierence =?, education =?, certificate =?  "
                        +"where username =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getFullname());
                stm.setString(2, dto.getBirthday());
                stm.setString(3, dto.getPhoneNumber());
                stm.setString(4, dto.getEmail());
                stm.setString(5, dto.getAddress());
                stm.setString(6, dto.getJob());
                stm.setString(7, dto.getExpierence());
                stm.setString(8, dto.getEducation());
                stm.setString(9, dto.getCertificate());
                stm.setString(10, dto.getUsername());
                
                int row = stm.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
            
        }
        return false;
    }
}
