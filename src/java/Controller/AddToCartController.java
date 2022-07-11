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
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

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
        String url = Define.SEARCH_PRODUCT_CONTROLLER;
        HttpSession session = request.getSession();
        try {
            int txtProductID = Integer.parseInt(request.getParameter("txtProductID"));
            ProductDAO productDAO = new ProductDAO();
            ProductDTO productDTO = productDAO.getProductByID(txtProductID);
            ArrayList<ProductDTO> cart = (ArrayList<ProductDTO>) session.getAttribute("CART");
            boolean isPicked = false;
            if (cart == null) {
                cart = new ArrayList<ProductDTO>();
            }
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getProductId() == txtProductID) {
                    request.setAttribute("ADD_TO_CART_MSG","This product "+ productDTO.getProductName() + " is already in your cart");
                    isPicked = true;
                    break;
                }
            }

            if (isPicked == false) {
                request.setAttribute("ADD_TO_CART_MSG", productDTO.getProductName() + " is added to your cart");
                productDTO.setQuantity(1);
                cart.add(productDTO);
            }
            session.setAttribute("CART", cart);
        } catch (Exception e) {
            e.printStackTrace();
            log("Error At Add To Cart Controller " + e.getLocalizedMessage());
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
