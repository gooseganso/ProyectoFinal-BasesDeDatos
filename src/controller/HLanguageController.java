/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class HLanguageController implements Initializable {

    @FXML
    private JFXButton btn_Pcrear;
    @FXML
    private JFXButton btn_ModificarP;
    @FXML
    private JFXButton btn_EliminarP;
    @FXML
    private JFXButton btn_Buscar;
    @FXML
    private AnchorPane language_Crud;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crear(MouseEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/CLanguage.fxml"));
           
         language_Crud.getChildren().setAll(pane);
    }

    @FXML
    private void doCrear(ActionEvent event) {
    }

    @FXML
    private void doModify(ActionEvent event) throws IOException 
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/MLanguage.fxml"));
           
        language_Crud.getChildren().setAll(pane);
    }

    @FXML
    private void doEliminar(ActionEvent event) throws IOException 
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/ELanguage.fxml"));
           
        language_Crud.getChildren().setAll(pane);
    }

    @FXML
    private void doBuscar(ActionEvent event) throws IOException 
    {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/BLanguage.fxml"));
           
         rootPane.getChildren().setAll(pane);
    }
    
}
