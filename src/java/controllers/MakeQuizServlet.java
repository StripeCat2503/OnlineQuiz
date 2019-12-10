/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "MakeQuizServlet", urlPatterns = {"/makeQuiz"})
public class MakeQuizServlet extends HttpServlet {

    private final String QUIZ_PAGE = "listOfQuiz.jsp";
    private final String CREATE_QUIZ_PAGE = "newQuiz.jsp";

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
        response.sendRedirect(QUIZ_PAGE);
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
        response.setContentType("text/html;charset=UTF-8");

        String url = "";

        String quizTitle = request.getParameter("txtTitle").trim();
        String quizTakenTime = request.getParameter("txtTakenTime");

        if (quizTitle.isEmpty() || quizTakenTime.isEmpty()) {
            return;
        }

        try {
            java.util.Date dateOfNow = new java.util.Date();
            java.sql.Date dateOfNowInSQL = new Date(dateOfNow.getTime());
            Quiz quiz = new Quiz(quizTitle, Integer.parseInt(quizTakenTime), dateOfNowInSQL);
            QuizDAO dao = new QuizDAO();
            boolean success = dao.saveNewQuiz(quiz);
            if (success) {
                url = QUIZ_PAGE;
            } else {
                url = CREATE_QUIZ_PAGE;
            }
        } finally {
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
