/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class AnswerBean implements Serializable{
    private int questionID;
    private int answer;

    public AnswerBean() {
    }

    public AnswerBean(int questionID, int answer) {
        this.questionID = questionID;
        this.answer = answer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
    
    
}
