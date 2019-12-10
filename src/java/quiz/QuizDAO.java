/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

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
public class QuizDAO implements Serializable {

    public boolean saveNewQuiz(Quiz quiz) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(quiz);

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

    public boolean deleteQuiz(int quizID) {
        Transaction transaction = null;
        boolean success = false;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Quiz quiz = (Quiz) session.get(Quiz.class, quizID);
            if (quiz != null) {
                session.delete(quiz);
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

    public boolean updateQuiz(Quiz quiz) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.update(quiz);

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

    public List<Quiz> getAllQuiz() {
        List<Quiz> listOfQuiz = null;

        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            listOfQuiz = session.createQuery("from Quiz").list();

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex);

        }

        return listOfQuiz;
    }

    public Quiz getQuiz(int id) {
        Quiz quiz = null;

        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            quiz = (Quiz) session.get(Quiz.class, id);

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex);

        }

        return quiz;
    }

    public int getNumOfQuestions(int quizID) {
        Transaction transaction = null;

        int numOfQuestions = 0;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select count(q.id) "
                    + "from tblQuestion q join tblQuiz qz on q.quiz_id = qz.id "
                    + "where q.quiz_id = :id");
            query.setParameter("id", quizID);

            numOfQuestions = (int) query.uniqueResult();

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex);
            return -1;
        }

        return numOfQuestions;
    }
}
