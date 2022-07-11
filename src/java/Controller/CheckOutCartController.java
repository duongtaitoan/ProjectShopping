/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Define.DateUitils;
import Define.Define;
import Entity.CategoryDTO;
import Entity.OrderDTO;
import Entity.OrderDetailsDTO;
import Entity.ProductDTO;
import Model.CategoryDAO;
import Model.OrderDAO;
import Model.OrderDetailsDAO;
import Model.ProductDAO;
import Model.UserDAO;
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
@WebServlet(name = "CheckOutCartController", urlPatterns = {"/CheckOutCartController"})
public class CheckOutCartController extends HttpServlet {

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

        HttpSession session = request.getSession();
        try {
            ArrayList<ProductDTO> cart = (ArrayList<ProductDTO>) session.getAttribute("CART");
            ProductDAO productDAO = new ProductDAO();

            float totalPrice = Float.parseFloat(request.getParameter("txtTotalPrice"));
            UserDAO userDAO = new UserDAO();
            String email = (String) session.getAttribute("EMAIL");
            int userId = userDAO.getUserId(email);

            OrderDAO orderDAO = new OrderDAO();
            OrderDTO orderDTO = new OrderDTO();

            orderDTO.setUserId(userId);
            orderDTO.setTotalPrice(totalPrice);

            int insertedOrderID = orderDAO.insertOrder(orderDTO);
            if (insertedOrderID != 0) {
                OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
                for (ProductDTO f : cart) {
                    OrderDetailsDTO detailDTO = new OrderDetailsDTO();
                    detailDTO.setOrderId(insertedOrderID);
                    detailDTO.setProductId(f.getProductId());
                    detailDTO.setQuantity(f.getQuantity());
                    detailDTO.setUnitPrice(f.getSalePrice());

                    orderDetailsDAO.insertOrderDetail(detailDTO);

                    // minus quantity of product when 
                    productDAO.subQuantity(f.getProductId(), f.getQuantity());
                }
                session.removeAttribute("CART");
                request.setAttribute("CHECK_OUT_CART_MSG", "Your order has been accepted");
            }

            //get all list product
            ArrayList<ProductDTO> listProduct
                    = productDAO.getProductByParam(Define.IS_EMPTY_DEFAUL, Define.NUMBER_DEFAUL);
            request.setAttribute("LIST_PRODUCT", listProduct);

            //get all type category
            CategoryDAO categoryDAO = new CategoryDAO();
            ArrayList<CategoryDTO> listCategory = categoryDAO.getAllCategorys();
            request.setAttribute("LIST_CATEGORY", listCategory);

        } catch (Exception e) {
            e.printStackTrace();
            log("Error At Check Out Controller " + e.getLocalizedMessage());
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
