/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.flashcard.view_controller;

import e.flashcard.MainApp;
import e.flashcard.model.QuizCard;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author thanhtruong
 */
public class BuilderController implements Initializable {
    
    @FXML
    private MenuItem saveMenu;

    @FXML
    private MenuItem newMenu;

    private TextArea questionTextArea;

    private TextArea answerTextArea;

        
    private MainApp mainApp;
    private Stage dialogStage;
    @FXML
    private TextArea playerTextArea;
    @FXML
    private Button playerButton;
    
    @FXML
    void handleNewCard(ActionEvent event) {
        mainApp.getCardListClass().clearList();
        clearCard();
        
        // TO DO: Add alert to confirm saving current list before creating new one
    }

    void handleNextCard(ActionEvent event) {
        QuizCard card = new QuizCard(questionTextArea.getText(), answerTextArea.getText());
        mainApp.getCardListClass().addCard(card);
        clearCard();
    }

    @FXML
    void handleSaveCard(ActionEvent event) {
        QuizCard card = new QuizCard(questionTextArea.getText(), answerTextArea.getText());
        mainApp.getCardListClass().addCard(card);
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Card List");
        File file = fileChooser.showSaveDialog(dialogStage);
        if (file != null) {
            saveFile(file);
        }
    }           
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    
    /**
     * Sets the stage of the "alert.initOwner(dialogStage)". Called by MainApp
     * @param dialogStage 
     */
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    private void saveFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(QuizCard card:mainApp.getCardListClass().getCardList()) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch(IOException ex) {
            System.out.println("Unable to Save file");
            ex.printStackTrace();
        }
    }
    
    private void clearCard() {
        questionTextArea.setText("");
        answerTextArea.setText("");
        questionTextArea.requestFocus();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url,
            ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlePlayerButton(ActionEvent event) {
    }
    
}
