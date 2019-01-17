/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.flashcard.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author thanhtruong
 */
public class QuizCard {
    private StringProperty question = new SimpleStringProperty();
    private StringProperty answer = new SimpleStringProperty();
    
    public QuizCard() {
        this(null, null);
    }
    
    public QuizCard(String question, String answer) {
        this.question.set(question);
        this.answer.set(answer);
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public void setAnswer(String answer) {
        this.answer.set(answer);
    }

    public String getQuestion() {
        return question.get();
    }

    public String getAnswer() {
        return answer.get();
    }
    
    
    
}
