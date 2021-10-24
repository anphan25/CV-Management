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
                String sql = "select image,username,birthday,fullname,gender,phoneNumber,email,address,job,expierence,education,certificate from CV where username = ?";
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
                    String image = rs.getString("image");

                    CVDTO cvDTO = new CVDTO(ID, birthday, fullname, gender, phoneNumber, email, address, job, expierence, education, certificate,image);
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
                String sql = "Update CV SET fullname =?, birthday =?,gender =?,phoneNumber =?, email =?, address =?, job =?, expierence =?, education =?, certificate =?  "
                        +"where username =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getFullname());
                stm.setString(2, dto.getBirthday());
                stm.setString(3, dto.getGender());
                stm.setString(4, dto.getPhoneNumber());
                stm.setString(5, dto.getEmail());
                stm.setString(6, dto.getAddress());
                stm.setString(7, dto.getJob());
                stm.setString(8, dto.getExpierence());
                stm.setString(9, dto.getEducation());
                stm.setString(10, dto.getCertificate());
                stm.setString(11, dto.getUsername());
                
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
    
    public boolean createCV(CVDTO dto) throws SQLException, NamingException{
       Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "insert  into CV (username,image,birthday,fullname,gender,phoneNumber,email,address,job,expierence,education,certificate) "
                        +"values(?,?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getImage());
                stm.setString(3, dto.getBirthday());
                stm.setString(4, dto.getFullname());
                stm.setString(5, dto.getGender());
                stm.setString(6, dto.getPhoneNumber());
                stm.setString(7, dto.getEmail());
                stm.setString(8, dto.getAddress());
                stm.setString(9, dto.getJob());
                stm.setString(10, dto.getExpierence());
                stm.setString(11, dto.getEducation());
                stm.setString(12, dto.getCertificate());
                
                int row = stm.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        }finally{
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return false;
    }
    public void deleteAccount(String username) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql= "delete from Registration where username =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                int row = stm.executeUpdate();
            }
        }finally{
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
    }
    
    public void deleteCV(String username) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql= "delete from CV where username =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                int row = stm.executeUpdate();
            }
        }finally{
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
    }
}
