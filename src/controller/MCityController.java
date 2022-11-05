/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCity;
import Gestion.GestionCountry;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MCityController implements Initializable {

    @FXML
    private JFXComboBox<String> comboPais;
    private ArrayList<String> combosPais;
    private GestionCountry llenar;
    private GestionCountry codp;
    private GestionCity district;
    @FXML
    private JFXComboBox<String> comboDistric;
    private ArrayList<String> combosDistrito;
    @FXML
    private JFXComboBox<String> comboCity;
    private ArrayList<String> combosCiudad;
    @FXML
    private TextField tagPobla;
    @FXML
    private JFXComboBox<String> comboCodPais;
    @FXML
    private TextField tagNom;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void doActivarNomDep(ActionEvent event) {
        String codigoCD=this.comboCity.getSelectionModel().getSelectedItem();
        String codigoPS=this.comboPais.getSelectionModel().getSelectedItem();
          
      this.comboDistric.getItems().clear();
      this.comboDistric.setDisable(false);
      this.combosDistrito= this.district.codigoDistritos(codigoPS);
      this.comboDistric.getItems().addAll(combosDistrito);
      this.comboDistric.setValue(this.district.getDistrict(codigoCD));
      
      this.comboCodPais.getItems().clear();
      this.comboCodPais.setDisable(false);
      this.comboCodPais.getItems().clear();
      this.comboCodPais.getItems().addAll(combosPais); 
      this.comboCodPais.setValue(codigoPS);
      
      this.tagNom.clear();
      this.tagNom.setDisable(false);
      this.tagNom.clear();
      this.tagNom.setText(codigoCD);
      
      this.tagPobla.clear();
      this.tagPobla.setDisable(false);
      this.tagPobla.clear();
      this.tagPobla.setText(this.district.getPobla(codigoCD));
      
      
        
        
        
    }

    @FXML
    private void doActivarCity(ActionEvent event) {
        String codigoPS=this.comboPais.getSelectionModel().getSelectedItem();
        
         this.comboCity.getItems().clear();
         this.comboCity.setDisable(false);
         this.combosCiudad= this.district.nomCiudades(codigoPS);
         this.comboCity.getItems().addAll(combosCiudad);
          
         
         
    }
    
}
