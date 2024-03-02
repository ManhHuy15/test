/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Account;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HUY
 */
public class AccountDBContext extends DBContext {

    public Account getAcountByUserPass(String user, String pass) {
        String sql = "SELECT [username]\n"
                + "      ,[password]\n"
                + "  FROM [dbo].[Account]\n"
                + "  Where username = ? AND password = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Account a = new Account();
                a.setUsername(user);
                a.setPassword(pass);
                
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
