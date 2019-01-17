/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.flashcard.view_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author thanhtruong
 */
public class PlayerController implements Initializable {

    @FXML
    private MenuItem saveMenu;
    @FXML
    private MenuItem newMenu;
    @FXML
    private TextArea playerTextArea;
    @FXML
    private Button playerButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url,
            ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSaveCard(ActionEvent event) {
    }

    @FXML
    private void handleNewCard(ActionEvent event) {
    }

    @FXML
    private void handlePlayerButton(ActionEvent event) {
        
    }
    
}
