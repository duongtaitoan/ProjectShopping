/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Define.Define;
import Entity.CategoryDTO;
import Entity.ProductDTO;
import Model.CategoryDAO;
import Model.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryController"})
public class CategoryController extends HttpServlet {

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
        String url = Define.CATEGORY_PAGE;
        Integer slCategory = null;
        HttpSession session = request.getSession();
        try {

            String role = (String) session.getAttribute("ROLE");
            //get all list product
            ProductDAO productDAO = new ProductDAO();
            ArrayList<ProductDTO> listProduct = 
                    productDAO.getProductByParam(Define.IS_EMPTY_DEFAUL, Define.NUMBER_DEFAUL);
            request.setAttribute("LIST_PRODUCT", listProduct);

            //get all type category
            CategoryDAO categoryDAO = new CategoryDAO();

            slCategory = Integer.parseInt(request.getParameter("selectCategory"));

            if (slCategory > 0 && slCategory != null) {
                listProduct = productDAO.getProductByParam(Define.IS_EMPTY_DEFAUL, slCategory);
                request.setAttribute("LIST_PRODUCT", listProduct);
                session.setAttribute("searchedCategoryID", slCategory);
            }
            ArrayList<CategoryDTO> listCategory = categoryDAO.getAllCategorys();
            request.setAttribute("LIST_CATEGORY", listCategory);

        } catch (Exception e) {
            log("Error At Category Controller " + e.getLocalizedMessage());
//            request.setAttribute("ERROR_SMS", "Something is wrong here please back home page!!");
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
