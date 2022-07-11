/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Define.Define;
import Entity.ProductDTO;
import Model.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duong
 */
@WebServlet(name = "UpdateCartController", urlPatterns = {"/UpdateCartController"})
public class UpdateCartController extends HttpServlet {

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
        String url = Define.SHOPPING_CART_PAGE;
        HttpSession session = request.getSession();
        try {
            ArrayList<ProductDTO> cart = (ArrayList<ProductDTO>) session.getAttribute("CART");
            ProductDAO productDAO = new ProductDAO();

            int txtProductID = Integer.parseInt(request.getParameter("txtProductID"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getProductId() == txtProductID) {
                    cart.get(i).setQuantity(quantity);
                    break;
                }
            }

            boolean tmpQuantity = false;
            for (ProductDTO f : cart) {
                int maxQuantity = productDAO.getQuantity(txtProductID);
                if (f.getQuantity() > maxQuantity) {
                    f.setQuantity(maxQuantity);
                    tmpQuantity = true;
                }
            }
            if (tmpQuantity) {
                request.setAttribute("CHECK_OUT_MSG", "Some products is out of stock, please check the quantity");
                url = Define.SHOPPING_CART_PAGE;
                return;
            }
            session.setAttribute("CART", cart);
        } catch (Exception e) {
            log("Error At Update Cart Controller " + e.getLocalizedMessage());
            request.setAttribute("CHECK_OUT_ERROR_MSG", "Update product is not valid please check again!!!");
            url = Define.SHOPPING_CART_PAGE;
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
