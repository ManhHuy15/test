/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Area;
import entity.MyClass;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HUY
 */
public class ClassAreaDBContext extends DBContext {

    public ArrayList<MyClass> getAllClass() {
        ArrayList<MyClass> classes = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Class]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                MyClass c = new MyClass();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                
                classes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassAreaDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return classes;
    }

     public ArrayList<Area> getAlArea() {
        ArrayList<Area> areas = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Area]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Area a = new Area();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                
                areas.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassAreaDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return areas;
    }
    
}
