
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/verify"})
public class VerifyController extends HttpServlet {

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
            HttpSession session = request.getSession();
           String r=(String) session.getAttribute("random");
            String code = request.getParameter("authcode");
           Date date=new Date();
         SimpleDateFormat sdf2 = new SimpleDateFormat("ss");
         String q=sdf2.format(date);
       int x1 = Integer.parseInt(q);
       System.out.println(q);
       while(true){
             Date date2=new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("ss");
       String a=sdf.format(date2);
//        System.out.println(a);
        int x = Integer.parseInt(a);
             if(code.equals(r)){
                out.println("Verification Done");
                  response.sendRedirect("draft.jsp");
            }else{
                out.println("Incorrect verification code");
                break;
        }
        if(x1<30){
            int b=x1+30;
            if(x==b){
                System.out.println("da xoa random");
                session.removeAttribute("random");
                break;
            }
        }else{
            int c=x1-30;
            if(x==c){
                
                System.out.println("da xoa random");
                session.removeAttribute("random");
                break;
            }
        }
       }
           
//            if(code.equals(r)){
//                out.println("Verification Done");
//                  response.sendRedirect("draft.jsp");
//            }else{
//                out.println("Incorrect verification code");
//        }

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
