/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dal.TreeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.ir.BreakNode;
import model.Account;
import model.Order;
import model.Tree;

/**
 *
 * @author ACER
 */
@WebServlet(name = "OrderController", urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quantity = request.getParameter("sl");
        String tid = request.getParameter("id");
        String c = request.getParameter("change");
        

        int sl = 0;

        dal.TreeDao treeDao = new TreeDao();

        if (quantity == null) {
            sl = 1;
        } else {
            sl = Integer.parseInt(quantity);
        }
        
        if(request.getParameter("sub")!=null){
            sl = -1;
        }
       
     

        HttpSession session = request.getSession();    

        Tree tree = treeDao.getDetail(tid);

        List<Order> orders = new ArrayList<>();
          if (session.getAttribute("orders") == null) {
               Order order = new Order();

            order.setQuantity(sl);
            
            
            order.setTree(tree);
            order.setTotal(tree.getPrice());
            orders.add(order);
            
            session.setAttribute("orders", orders);
          }else{
              orders = (List<Order>) session.getAttribute("orders");
              boolean up = false;

            for (Order order : orders) {
                if (order.getTree().getId() == tree.getId()) {                   
                    order.setQuantity(order.getQuantity() + sl);
                    up = true;                   
                }

            }
            if (up == false) {
                Order order = new Order();

                order.setQuantity(sl);
                order.setTree(tree);
                order.setTotal(tree.getPrice());
                orders.add(order);

            }
            
            session.setAttribute("orders", orders);
            
          }
           session.setAttribute("size", orders.size());
          response.sendRedirect("cart");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int did = Integer.parseInt(request.getParameter("did"));
        
         List<Order> orders = (List<Order>) session.getAttribute("orders");
       
         
         for (Order order : orders) {
            if(order.getTree().getId()==did){
                orders.remove(order);
                break;
            }
        }
         
         session.setAttribute("orders", orders); 
         session.setAttribute("size", orders.size());
         response.sendRedirect("cart");
         
         
      

        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
