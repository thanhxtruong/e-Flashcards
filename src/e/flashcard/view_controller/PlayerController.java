/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.flashcard.view_controller;

import e.flashcard.MainApp;
import e.flashcard.model.CardList;
import e.flashcard.model.QuizCard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author thanhtruong
 */
public class PlayerController implements Initializable {

     @FXML
    private MenuItem openMenu;

    @FXML
    private MenuItem newMenu;

    @FXML
    private MenuItem addMenu;
    
    @FXML
    private MenuItem exitMenu;

    @FXML
    private TextArea playerTextArea;

    @FXML
    private Button playerButton;

    @FXML
    private TableView<QuizCard> cardTable;

    @FXML
    private TableColumn<QuizCard, String> cardTableColumn;    
    
    private CardList readCardList = new CardList();
    private MainApp mainApp;
    private Stage dialogStage;
//    Path fileDir = Paths.get("C:\\Users\\thanhtruong\\Documents\\NetBeansProjects\\e-FlashCard\\src\\e\\flashcard\\model\\cardFiles");

    @FXML
    void handleAddCard(ActionEvent event) {

    }

    @FXML
    void handleNewFile(ActionEvent event) {

    }

    /**
     * Prompt user to select a file to load the list of cards.
     * Display list of "question" under Table.
     * @param event not used
     */
    @FXML
    void handleOpenCard(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        File file = fileChooser.showOpenDialog(dialogStage);
        if (file != null) {
            loadFile(file);
        }
        
        cardTableColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        cardTable.setItems(readCardList.getCardList());
        cardTable.getSelectionModel().select(0);
    }

    @FXML
    void handlePlayerButton(ActionEvent event) {

    }
    
    @FXML
    void handleExit(ActionEvent event) {

    }  
       
    public void showCardList() {
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(fileDir)) {
//            for (Path file:stream) {
//                cardTableColumn.setCellValueFactory(value);
//            }
//        } catch(IOException | DirectoryIteratorException x) {
//        System.err.println(x);
//        }
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
    
    /**
     * Load and read in a file.
     * Create a new Card for each read line.
     * @param file : selected by user from handleOpenCard()
     */
    private void loadFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                makeCard(line);
            }
            reader.close();
        } catch(Exception ex) {
            // TO DO: Replace the "sout" below with a warning GUI
            System.out.println("Unable to read the file!");
            ex.printStackTrace();
        }
    }
    
    /**
     * Make a new QuizCard using the input String
     * @param lineToParse : "question" and "answer" delimited by a "/"
     */
    private void makeCard(String lineToParse) {
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        readCardList.addCard(card);
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url,
            ResourceBundle rb) {       
        
        // TODO
    }
    
}
