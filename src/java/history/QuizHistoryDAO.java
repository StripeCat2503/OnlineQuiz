/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package history;

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
public class QuizHistoryDAO implements Serializable{
    public boolean saveNewQuizHistory(QuizHistory quizHistory) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(quizHistory);

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
    
    public List<QuizHistory> getAllQuizHistories(String username){
        Transaction transaction = null;
        List<QuizHistory> listOfHistories = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            SQLQuery query = session.createSQLQuery("select * from tblQuizHistory where username = :username");
            query.setParameter("username", username);
            query.addEntity(QuizHistory.class);

            listOfHistories = query.list();

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex);
           
        }

        return listOfHistories;
    }
    
    public boolean deleteAllQuizHistories(String username){
        Transaction transaction = null;
        
        boolean success = false;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            List<QuizHistory> listOfQuizHistories = getAllQuizHistories(username);
            if(listOfQuizHistories != null && !listOfQuizHistories.isEmpty()){
                for (QuizHistory quizHistory : listOfQuizHistories) {
                    session.delete(quizHistory);
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
