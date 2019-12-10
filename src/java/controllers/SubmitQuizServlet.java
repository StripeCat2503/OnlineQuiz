/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import answer.AnswerBean;
import history.QuizHistory;
import history.QuizHistoryDAO;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import question.QuestionDAO;
import user.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SubmitQuizServlet", urlPatterns = {"/submitQuiz"})
public class SubmitQuizServlet extends HttpServlet {

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
        
    }

    private final String RESULT_PAGE = "result.jsp";
    private final String ERR_PAGE = "saveHistoryErr.jsp";

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

        List<AnswerBean> listOfAnswer = new ArrayList<>();
        String txtNumOfQuestions = request.getParameter("numOfQuestions");
        int numOfQuestion = Integer.parseInt(txtNumOfQuestions);
        float scoreForEachQuestion = 10f / numOfQuestion;
        float totalScore = 0;
        int numOfRightAnswers = 0;
        
        HttpSession session = request.getSession(false);
        
        if(session == null){
            return;
        }
        
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        
        String txtQuizID = request.getParameter("quizID");

        for (int i = 1; i <= numOfQuestion; i++) {
            String radioValue = request.getParameter("radio" + i);
            String txtAnswer = "";
            String txtQuestionID = "";
            if (radioValue != null) {
                String[] arr = radioValue.split("#");
                txtAnswer = arr[0];
                txtQuestionID = arr[1];

                AnswerBean bean = new AnswerBean(Integer.parseInt(txtQuestionID), Integer.parseInt(txtAnswer));
                listOfAnswer.add(bean);
            }

        }

        QuestionDAO dao = new QuestionDAO();

        for (AnswerBean answerBean : listOfAnswer) {
            boolean isRightAnswer = dao.isRightAnswer(answerBean);
            if (isRightAnswer) {
                totalScore += scoreForEachQuestion;
                numOfRightAnswers++;
            }
        }
        
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        
        totalScore = Float.parseFloat(decimalFormat.format(totalScore));

        request.setAttribute("score", totalScore);
        
        // Save quiz history
        java.util.Date dateOfNow = new java.util.Date();
        Date sqlDateOfNow = new Date(dateOfNow.getTime());
        QuizHistory quizHistory = new QuizHistory(username, numOfRightAnswers, totalScore, sqlDateOfNow, Integer.parseInt(txtQuizID));
        QuizHistoryDAO quizHistoryDAO = new QuizHistoryDAO();
        boolean success = quizHistoryDAO.saveNewQuizHistory(quizHistory);
        String url = "";
        
        if(success){
            url = RESULT_PAGE;
        }
        else{
            url = ERR_PAGE;
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
