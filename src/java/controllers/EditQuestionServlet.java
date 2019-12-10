/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import question.Question;
import question.QuestionDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditQuestionServlet", urlPatterns = {"/editQuestion"})
public class EditQuestionServlet extends HttpServlet {

    private final String EDIT_QUESTION_PAGE = "editQuestion.jsp";
    
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
        String txtQuestionID = request.getParameter("id");
        
        QuestionDAO dao = new QuestionDAO();
        Question question = dao.getQuestion(Integer.parseInt(txtQuestionID));
        
        request.setAttribute("question", question);
        RequestDispatcher rd = request.getRequestDispatcher(EDIT_QUESTION_PAGE);
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
        
        String content = request.getParameter("txtQuestion");
        String op1 = request.getParameter("txtOption1");
        String op2 = request.getParameter("txtOption2");
        String op3 = request.getParameter("txtOption3");
        String op4 = request.getParameter("txtOption4");
        
        String txtAnswer = request.getParameter("radioAnswer");
        
        String txtQuestionID = request.getParameter("questionID");
        String txtQuizID = request.getParameter("quizID");
        
        String url = "";
        
        
        try{
            QuestionDAO dao = new QuestionDAO();
            Question question = new Question(content, op1, op2, op3, op4, Integer.parseInt(txtAnswer), Integer.parseInt(txtQuizID));
            question.setId(Integer.parseInt(txtQuestionID));
            boolean success = dao.updateQuestion(question);
            
            if(success){
                url = "questions?id=" + txtQuizID;
            }
            else{
                url = EDIT_QUESTION_PAGE;
            }
        }
        finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
