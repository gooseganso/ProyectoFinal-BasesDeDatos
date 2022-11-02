/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Natho
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane top_bar;
    @FXML
    private ImageView lang;
    @FXML
    private ImageView country;
    @FXML
    private ImageView city;
    @FXML
    private AnchorPane tab;
    @FXML
    private AnchorPane principal_tab;
    @FXML
    private JFXButton cerrar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void doHola(ActionEvent event) {
        System.out.println("Prueba de texto");
    }


    @FXML
    private void doLang(MouseEvent event) throws IOException 
    {
        
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/HLanguage.fxml"));
           
         tab.getChildren().setAll(pane);
    }

    @FXML
    private void doCountry(MouseEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/HCountry.fxml"));
           
         tab.getChildren().setAll(pane);
    }

    @FXML
    private void doCity(MouseEvent event) throws IOException
    {
      AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/HCity.fxml"));
           
         tab.getChildren().setAll(pane);
    }

    @FXML
    private void cerrar(ActionEvent event) {
        
        Stage stage = (Stage) this.cerrar.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    
}
