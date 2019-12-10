/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package history;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tblQuizHistory")
public class QuizHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int rightAnswers;
    private float score;
    private Date takenDate;
    private int quiz_id;

    public QuizHistory() {
    }

    public QuizHistory(int id, String username, int rightAnswers, float score, Date takenDate, int quiz_id) {
        this.id = id;
        this.username = username;
        this.rightAnswers = rightAnswers;
        this.score = score;
        this.takenDate = takenDate;
        this.quiz_id = quiz_id;
    }

    public QuizHistory(String username, int rightAnswers, float score, Date takenDate, int quiz_id) {
        this.username = username;
        this.rightAnswers = rightAnswers;
        this.score = score;
        this.takenDate = takenDate;
        this.quiz_id = quiz_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }
    
    
}
