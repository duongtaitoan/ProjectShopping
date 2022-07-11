/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Define.DateUitils;
import Define.Define;
import Entity.OrderDTO;
import Model.OrderDAO;
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
@WebServlet(name = "HistoryController", urlPatterns = {"/HistoryController"})
public class HistoryController extends HttpServlet {

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
        String url = Define.HISTORY_PAGE;
        HttpSession session = request.getSession();
        String fromDate = null;
        String toDate = null;
        String txtProductName = null;
        try {
            String user = (String) session.getAttribute("EMAIL");
            fromDate = request.getParameter("txtFromDate");
            toDate = request.getParameter("txtToDate");
            txtProductName = request.getParameter("txtProductName");

            if (fromDate == null || fromDate.isEmpty()) {
                fromDate = "";
            }
            if (toDate == null || toDate.isEmpty()) {
                toDate = "";
            }
            if (txtProductName == null || txtProductName.isEmpty()) {
                txtProductName = "";
            }
            DateUitils date = new DateUitils();

            OrderDAO bookingDAO = new OrderDAO();
//            check day not < 0
            int dayDiffs = date.checkDay(fromDate, toDate);
            // date && name == null
            if ((fromDate.equals("") && toDate.equals("")) && txtProductName.equals("")) {
                ArrayList<OrderDTO> listOrder = new ArrayList<>();
                listOrder = bookingDAO.getOrderHistory(user, "", "", "");
                request.setAttribute("LIST_ORDER", listOrder);
                // date || name # null
            } else if (((!fromDate.isEmpty() && !toDate.isEmpty())) || !txtProductName.isEmpty()) {
                // name == null
                if (txtProductName.equals("")) {
                    // date > 0
                    if (dayDiffs > 0) {
                        ArrayList<OrderDTO> listOrder = new ArrayList<>();
                        listOrder = bookingDAO.getOrderHistory(user, fromDate, toDate, txtProductName);
                        request.setAttribute("LIST_ORDER", listOrder);
                    } else {
                        request.setAttribute("DATE_HISTORY_MSG", "Invalid from date is bigger than to date");
                    }
                    // name != null
                } else {
                    ArrayList<OrderDTO> listOrder = new ArrayList<>();
                    listOrder = bookingDAO.getOrderHistory(user, fromDate, toDate, txtProductName);
                    request.setAttribute("LIST_ORDER", listOrder);
                }
                // date && name # null
            } else if ((!fromDate.equals("") && !toDate.equals("")) && !txtProductName.equals("")) {
                ArrayList<OrderDTO> listOrder = new ArrayList<>();
                listOrder = bookingDAO.getOrderHistory(user, fromDate, toDate, txtProductName);
                request.setAttribute("LIST_ORDER", listOrder);
            }

            request.setAttribute("txtFromDate", fromDate);
            request.setAttribute("txtToDate", toDate);
            request.setAttribute("searchedProductByName", txtProductName);
        } catch (Exception e) {
            log("Error At Order History Controller" + e.getLocalizedMessage());
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
