/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class InvoiceDAO extends BaseDAO{
    
    public void invoice(String name,String numberphone,String email,String address,String pay){
        try {
            String sql = "INSERT INTO [ProjectWeb].[dbo].[Invoice](\n" +
                    "      [name]\n" +
                    "      ,[numberphone]\n" +
                    "      ,[email]\n" +
                    "      ,[address]\n" +
                    "      ,[pay])\n" +
                    "VALUES (?,?,?,?,?)";
            
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, numberphone);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, pay);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
}
