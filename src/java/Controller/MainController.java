/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Define.Define;
import Entity.CategoryDTO;
import Entity.ProductDTO;
import Model.CategoryDAO;
import Model.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duong
 */
@MultipartConfig
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

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
        String url = Define.INDEX_PAGE;
        try {
            String action = request.getParameter("btnAction");
            if (action != null && action != "") {
                if (action.equals("Login")) {
                    url = Define.LOGIN_CONTROLLER;
                } else if (action.equals("Logout")) {
                    url = Define.LOGOUT_CONTROLLER;
                } else if (action.equals("Search Product")) {
                    url = Define.SEARCH_PRODUCT_CONTROLLER;
                } else if (action.equalsIgnoreCase("Go To Update Page")
                        || action.equalsIgnoreCase("Update Product")) {
                    url = Define.UPDATE_PRODUCT_CONTROLLER;
                } else if (action.equals("New Product")) {
                    url = Define.ADD_PRODUCT_CONTROLLER;
                } else if (action.equals("Delete Product")) {
                    url = Define.DELETE_PRODUCT_CONTROLLER;
                } else if (action.equals("Add To Cart")) {
                    url = Define.ADD_TO_CART_CONTROLLER;
                } else if (action.equals("Details Product")) {
                    url = Define.DETAILS_PRODUCT_CONTROLLER;
                } else if (action.equals("Search History Product")) {
                    url = Define.HISTORY_ORDER_CONTROLLER;
                } else if (action.equals("Category")
                        || action.equals("Search Product By Category")) {
                    url = Define.CATEGORY_CONTROLLER;
                } else if (action.equals("Shopping Cart")) {
                    url = Define.SHOPPING_CART_PAGE;
                } else if (action.equals("Update Your Cart")) {
                    url = Define.UPDATE_YOUR_CART_CONTROLLER;
                } else if (action.equals("Delete Your Cart")) {
                    url = Define.DELETE_YOUR_CART_CONTROLLER;
                } else if (action.equals("Check Out Your Cart")) {
                    url = Define.CHECK_OUT_YOUR_CART_CONTROLLER;
                }
            }
            //get all list product
            ArrayList<ProductDTO> listProduct = new ArrayList<>();
            ProductDAO productDAO = new ProductDAO();
            listProduct = productDAO.getProductByParam(Define.IS_EMPTY_DEFAUL, Define.NUMBER_DEFAUL);
            request.setAttribute("LIST_PRODUCT", listProduct);

            //get all type category
            CategoryDAO categoryDAO = new CategoryDAO();
            ArrayList<CategoryDTO> listCategory = categoryDAO.getAllCategorys();
            request.setAttribute("LIST_CATEGORY", listCategory);
        } catch (Exception e) {
            log("Error At MainController " + e.getLocalizedMessage());
            request.setAttribute("error", e.getLocalizedMessage());
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
