/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question;

import answer.AnswerBean;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author Admin
 */
public class QuestionDAO implements Serializable {

    public boolean saveNewQuestion(Question question) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(question);

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            System.err.println(ex);

            return false;
        }

        return true;
    }
    
    public boolean updateQuestion(Question question){
        Transaction transaction = null;
       

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.update(question);

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            System.err.println(ex);

            return false;
        }

        return true;
    }
    
    public Question getQuestion(int questionID){
        Transaction transaction = null;
        
        Question question = null;
        
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            question = (Question) session.get(Question.class, questionID);
            
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            System.err.println(ex);

        }
        
        return question;
    }

    public List<Question> getAllQuestions(int quizID) {
        List<Question> listOfQuestions = null;

        Transaction transaction = null;
        
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select * "
                    + "from tblQuestion "
                    + "where quiz_id = :id");
            query.setParameter("id", quizID);
            query.addEntity(Question.class);

            listOfQuestions = query.list();

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            System.err.println(ex);

        }

        return listOfQuestions;
    }
    
    public boolean isRightAnswer(AnswerBean answerBean){
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Question question = (Question) session.get(Question.class, answerBean.getQuestionID());
            if(question != null){
                if(question.getAnswer() == answerBean.getAnswer()){
                    return true;
                }
            }

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            System.err.println(ex);

            return false;
        }

        return false;
    }
    
    public boolean deleteQuestion(int questionID){
        Transaction transaction = null;
        boolean success = false;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Question question = (Question) session.get(Question.class, questionID);
            if(question != null){
                session.delete(question);
                success = true;
            }

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            System.err.println(ex);

            return false;
        }

        return success;
    }
    
    public boolean deleteAllQuestions(int quizID){
        Transaction transaction = null;
        boolean success = false;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            SQLQuery query = session.createSQLQuery("select * from tblQuestion where quiz_id = :id");
            query.setParameter("id", quizID);
            query.addEntity(Question.class);

            List<Question> listOfQuestions = query.list();
            
            if(listOfQuestions != null && !listOfQuestions.isEmpty()){
                for (Question question : listOfQuestions) {
                    session.delete(question);
                }
                success = true;
            }
            

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            System.err.println(ex);

            return false;
        }

        return success;
    }
}
