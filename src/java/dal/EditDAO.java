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
public class EditDAO extends BaseDAO {

    public void AddTree(String name, String price, String image, String des, String cid) {
        try {
            String sql = "insert into [ProjectWeb].[dbo].[Tree](\n"
                    + "       [name]\n"
                    + "      ,[price]\n"
                    + "      ,[image]\n"
                    + "      ,[Description]\n"
                    + "      ,[cid])\n"
                    + "VALUES (?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, image);
            ps.setString(4, des);
            ps.setString(5, cid);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EditDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Update(String name, String price, String image, String des, String cid, String id) {
        try {
            String sql = "UPDATE [ProjectWeb].[dbo].[Tree]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[image] = ?\n"
                    + "      ,[Description] = ?\n"
                    + "      ,[cid] = ?\n"
                    + " WHERE [id] = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, image);
            ps.setString(4, des);
            ps.setString(5, cid);
            ps.setString(6, id);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EditDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteTree(String id) {
        try {
            String sql = "DELETE FROM ProjectWeb.dbo.Tree\n"
                    + "\n"
                    + "where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EditDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
