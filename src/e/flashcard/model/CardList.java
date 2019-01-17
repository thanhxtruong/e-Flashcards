/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.flashcard.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.smartcardio.Card;

/**
 *
 * @author thanhtruong
 */
public class CardList {
    private static ObservableList<QuizCard> cardList;
    
    public CardList() {
        this.cardList = FXCollections.observableArrayList();
    }   

    public void addCard(QuizCard card) {
        cardList.add(card);
    }    

    public ObservableList<QuizCard> getCardList() {
        return cardList;
    }
    
    public void clearList() {
        cardList.clear();
    }
    
}
