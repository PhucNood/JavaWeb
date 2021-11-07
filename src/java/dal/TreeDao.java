/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Tree;

/**
 *
 * @author ACER
 */
public class TreeDao extends BaseDAO {

    public List<Tree> getAllTree() {
        List<Tree> trees = new ArrayList<>();
        try {

            String sql = "SELECT  [id]\n"
                    + "      ,[name]\n"
                    + "      ,[price]\n"
                    + "      ,[image]\n"
                    + "      ,[Description]\n"
                    + "      ,[cid]\n"
                    + "  FROM [ProjectWeb].[dbo].[Tree]";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setId(rs.getInt("id"));
                tree.setName(rs.getString("name"));
                tree.setDescription(rs.getString("Description"));
                tree.setPrice(rs.getInt("price"));
                tree.setCid(rs.getInt("cid"));
                tree.setImage(rs.getString("image"));
                trees.add(tree);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TreeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trees;
    }

    public List<Tree> getTreesByPage(int page) {
        List<Tree> trees = new ArrayList<>();
        try {

            String sql = "SELECT  [id]\n"
                    + "      ,[name]\n"
                    + "      ,[price]\n"
                    + "      ,[image]\n"
                    + "      ,[Description]\n"
                    + "      ,[cid]\n"
                    + "  FROM [ProjectWeb].[dbo].[Tree]\n"
                    + "  ORDER BY id \n"
                    + "  OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (page - 1) * 9);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setId(rs.getInt("id"));
                tree.setName(rs.getString("name"));
                tree.setDescription(rs.getString("Description"));
                tree.setPrice(rs.getInt("price"));
                tree.setCid(rs.getInt("cid"));
                tree.setImage(rs.getString("image"));
                trees.add(tree);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TreeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trees;
    }

    public List<Tree> getNewTrees() {
        List<Tree> trees = new ArrayList<>();
        try {

            String sql = "SELECT TOP (3) [id]\n"
                    + "      ,[name]\n"
                    + "      ,[price]\n"
                    + "      ,[image]\n"
                    + "      ,[Description]\n"
                    + "      ,[cid]\n"
                    + "  FROM [ProjectWeb].[dbo].[Tree]\n"
                    + "  ORDER BY id desc";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setId(rs.getInt("id"));
                tree.setName(rs.getString("name"));
                tree.setDescription(rs.getString("Description"));
                tree.setPrice(rs.getInt("price"));
                tree.setCid(rs.getInt("cid"));
                tree.setImage(rs.getString("image"));
                trees.add(tree);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TreeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trees;
    }

    public List<Category> getCategorys() {
        List<Category> categorys = new ArrayList<>();
        try {
            String sql = "SELECT  [id]\n"
                    + "      ,[name]\n"
                    + "  FROM [ProjectWeb].[dbo].[Category]";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategory(rs.getString("name"));
                categorys.add(category);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TreeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorys;
    }

    public Category getCategory(String id) {

        try {
            String sql = "SELECT  [id]\n"
                    + "      ,[name]\n"
                    + "  FROM [ProjectWeb].[dbo].[Category]\n"
                    + "  WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategory(rs.getString("name"));
                return category;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TreeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Tree> getTreebyCategory(String cid) {
        List<Tree> trees = new ArrayList<>();
        try {
            String sql = "SELECT TOP (1000) [id]\n"
                    + "      ,[name]\n"
                    + "      ,[price]\n"
                    + "      ,[image]\n"
                    + "      ,[Description]\n"
                    + "      ,[cid]\n"
                    + "  FROM [ProjectWeb].[dbo].[Tree]\n"
                    + "  WHERE [cid] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setId(rs.getInt("id"));
                tree.setName(rs.getString("name"));
                tree.setDescription(rs.getString("Description"));
                tree.setPrice(rs.getInt("price"));
                tree.setCid(rs.getInt("cid"));
                tree.setImage(rs.getString("image"));
                trees.add(tree);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TreeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return trees;
    }

    public Tree getDetail(String id) {

        PreparedStatement ps;
        try {
            String sql = "SELECT  [id]\n"
                    + "      ,[name]\n"
                    + "      ,[price]\n"
                    + "      ,[image]\n"
                    + "      ,[Description]\n"
                    + "      ,[cid]\n"
                    + "  FROM [ProjectWeb].[dbo].[Tree]\n"
                    + "  WHERE id =?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setId(rs.getInt("id"));
                tree.setName(rs.getString("name"));
                tree.setDescription(rs.getString("Description"));
                tree.setPrice(rs.getInt("price"));
                tree.setCid(rs.getInt("cid"));
                tree.setImage(rs.getString("image"));
                return tree;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TreeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Tree> SearchTreebyName(String text) {
        List<Tree> trees = new ArrayList<>();
        try {
            String sql = "SELECT  [id]\n"
                    + "      ,[name]\n"
                    + "      ,[price]\n"
                    + "      ,[image]\n"
                    + "      ,[Description]\n"
                    + "      ,[cid]\n"
                    + "  FROM [ProjectWeb].[dbo].[Tree]\n"
                    + "WHERE [name] like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + text + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setId(rs.getInt("id"));
                tree.setName(rs.getString("name"));
                tree.setDescription(rs.getString("Description"));
                tree.setPrice(rs.getInt("price"));
                tree.setCid(rs.getInt("cid"));
                tree.setImage(rs.getString("image"));
                trees.add(tree);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TreeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return trees;
    }

    public void AddnewCate(String name) {
        try {
            String sql = "INSERT INTO [ProjectWeb].[dbo].[Category] \n"
                    + "      ([name]) VALUES (?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
