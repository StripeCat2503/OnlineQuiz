/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.Quiz;
import quiz.QuizDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditQuizServlet", urlPatterns = {"/editQuiz"})
public class EditQuizServlet extends HttpServlet {
    
    private final String EDIT_QUIZ_PAGE = "editQuiz.jsp";
    private final String QUIZ_PAGE = "listOfQuiz.jsp";

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
        
        String txtQuizID = request.getParameter("id");
                
        QuizDAO dao = new QuizDAO();
        Quiz quiz = dao.getQuiz(Integer.parseInt(txtQuizID));
        
        request.setAttribute("quiz", quiz);
        
        RequestDispatcher rd = request.getRequestDispatcher(EDIT_QUIZ_PAGE);
        rd.forward(request, response);
        
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
        
        String quizTitle = request.getParameter("txtTitle");
        String takenTime = request.getParameter("txtTakenTime");
        String txtQuizID = request.getParameter("quizID");     
        
        String url = "";
        
        try{
            QuizDAO dao = new QuizDAO();
            Quiz quiz = dao.getQuiz(Integer.parseInt(txtQuizID));
            if(quiz != null){
                quiz.setTitle(quizTitle);
                quiz.setTaken_time(Integer.parseInt(takenTime));
                boolean success = dao.updateQuiz(quiz);
                if(success){
                    url = QUIZ_PAGE;
                }
                else{
                    url = EDIT_QUIZ_PAGE;
                }
            }
        }
        finally{
            response.sendRedirect(url);
        }
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
