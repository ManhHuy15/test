/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Area;
import entity.Customer;
import entity.MyClass;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HUY
 */
public class CustomerDBContext extends DBContext {

    public void InsertCus(Customer c) {
        String sql = "INSERT INTO [dbo].[Customer]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[dob]\n"
                + "           ,[gender]\n"
                + "           ,[classid]\n"
                + "           ,[areaid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getName());
            st.setDate(3, c.getDob());
            st.setBoolean(4, c.isGender());
            st.setInt(5, c.getClas().getId());
            st.setInt(6, c.getArea().getId());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
