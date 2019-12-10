/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author Admin
 */
public class UserDAO implements Serializable{
    public boolean saveUser(User user){
        Transaction transaction = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            session.save(user);
            
            transaction.commit();
        }
        catch(HibernateException ex){
            System.err.println(ex);
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }
        
        return true;
    }
    
    public User getUser(String username, String password){
        Transaction transaction = null;
        User user = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            User checkUser = (User) session.get(User.class, username);
            if(checkUser != null){
                if(checkUser.getPassword().equals(password)){
                    user = checkUser;
                }
             
            }
            
            transaction.commit();
        }
        catch(HibernateException ex){
            System.err.println(ex);
            if(transaction != null){
                transaction.rollback();
            }
            return null;
        }
        
        return user;
    }
}
