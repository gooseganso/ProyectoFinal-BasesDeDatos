/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCountry;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tablas.Country;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class CCityController implements Initializable {

    @FXML
    private JFXComboBox<Country> comboPais;
    ObservableList <Country> misCountry = FXCollections.observableArrayList();
    private GestionCountry llenar;
    @FXML
    private JFXComboBox<?> comboDistric;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       this.llenar= new GestionCountry();
       this.misCountry = this.llenar.llenarTablaPaises();
       this.llenarComboPais();
    }    
    
     private void llenarComboPais()
   {
       this.comboPais.getItems().addAll(misCountry);
       this.comboPais.setConverter(new CountryConverter());
       
   }
     

    @FXML
    private void doDistrict(ActionEvent event) 
    {
        
        this.comboDistric.getItems().clear();
        
        this.comboDistric.setDisable(false);
        
        
    }
}
