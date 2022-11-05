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
    private JFXComboBox<String> comboPais;
    private ArrayList<String> combosPais;
    private GestionCountry llenar;
    private GestionCountry codp;
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
       this.codp= new GestionCountry();
       this.llenar= new GestionCountry();
       this.combosPais= this.codp.getCodigosPais();
       this.district= new GestionCity();
       this.llenarComboPais();
    }    
    
     private void llenarComboPais()
   {
       this.comboPais.getItems().addAll(combosPais);   
   }
     
  
    @FXML
    private void doDistrict(ActionEvent event) 
   {
      String codigoPS=this.comboPais.getSelectionModel().getSelectedItem();
          
      this.comboDistric.getItems().clear();
      this.comboDistric.setDisable(false);
      this.combosDistrito= this.district.codigoDistritos(codigoPS);
      this.comboDistric.getItems().addAll(combosDistrito);
    }
  }
