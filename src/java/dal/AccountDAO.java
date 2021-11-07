/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ACER
 */
public class AccountDAO extends BaseDAO {

    public boolean checkExistAcount(String username) {
        try {
            String sql = "SELECT  [id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[isAdmin]\n"
                    + "  FROM [ProjectWeb].[dbo].[Account]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            HashMap<String, Account> accounts = new HashMap<>();
            while (rs.next()) {
                Account account = new Account();
                account.setAdmin(rs.getBoolean("isAdmin"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setPassword(rs.getString("password"));
                account.setId(rs.getInt("id"));
                accounts.put(account.getUsername(), account);
            }
            if (accounts.containsKey(username)) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void CreateAcount(String username, String password) {
        try {
            String sql = "Insert into \n"
                    + "    dbo.Account( [username]\n"
                    + "      ,[password]\n"
                    + "      ,[isAdmin])\n"
                    + "values(?,?,0)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account login(String username, String pass) {
        try {
            String sql = "SELECT  [id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "      ,[isAdmin]\n"
                    + "  FROM [ProjectWeb].[dbo].[Account]\n"
                    + "\n"
                    + " WHERE [username] = ? and [password] =? ";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setAdmin(rs.getBoolean("isAdmin"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setPassword(rs.getString("password"));
                account.setId(rs.getInt("id"));

                return account;

            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
