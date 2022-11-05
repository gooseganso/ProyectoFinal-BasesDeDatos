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
import Gestion.GestionCity;
import java.util.ArrayList;
import javafx.util.StringConverter;

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
    private GestionCity district;
    @FXML
    private JFXComboBox<String> comboDistric;
    private ArrayList<String> combosDistrito;

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
     
    public Country comboPais()
    {
      Country codigoP= this.comboPais.getSelectionModel().getSelectedItem();
      
      return codigoP;
              
    }
     
    @FXML
    private void doDistrict(ActionEvent event) 
    {
        Country codigoP= this.comboPais.getSelectionModel().getSelectedItem();
        String codigoPS=codigoP.getCode();
        
        
        System.out.print(codigoPS);
        
       this.district= new GestionCity();
        
       this.comboDistric.getItems().clear();
        
       this.comboDistric.setDisable(false);
        
       this.combosDistrito= this.district.codigoDistritos(codigoPS);
        
       this.comboDistric.getItems().addAll(combosDistrito);
    }
}
