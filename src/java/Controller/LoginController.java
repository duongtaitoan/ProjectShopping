/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Define.Define;
import Entity.CategoryDTO;
import Entity.UserDTO;
import Model.CategoryDAO;
import Model.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duong
 */
public class LoginController extends HttpServlet {

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
          String url = Define.LOGIN_PAGE;
        HttpSession session = request.getSession();
        try {
            String txtEmail = request.getParameter("txtEmail");
            String txtPassword = request.getParameter("txtPassword");

            UserDAO userDAO = new UserDAO();
            
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(txtEmail);
            userDTO.setPassword(txtPassword);

            UserDTO role = userDAO.getRole(userDTO);
            if (role.getRole_name() != null) {
                session.setAttribute("USER", role.getFull_name());
                session.setAttribute("EMAIL", role.getEmail());
                session.setAttribute("ROLE", role.getRole_name());
                url = Define.INDEX_PAGE;

                CategoryDAO categoryDAO = new CategoryDAO();
                ArrayList<CategoryDTO> listCategory = categoryDAO.getAllCategorys();
                request.setAttribute("LIST_CATEGORY", listCategory);
            } else {
                request.setAttribute("LOGIN_MSG", "Wrong username/passwrod");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log("Error at Login Controller " + e.getLocalizedMessage());
            request.setAttribute("ERROR_MSG", e.getLocalizedMessage());
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
