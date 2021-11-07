/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.HashMap;
import java.util.List;
import model.Category;
import model.Tree;

/**
 *
 * @author ACER
 */
public class NewClass {
    public static void main(String[] args) {
        TreeDao treeDao = new TreeDao();
       
      
        
       List<Category> ca = treeDao.getCategorys();
        for (Category category : ca) {
            System.out.println(category.getCategory());
        }
    }
}
