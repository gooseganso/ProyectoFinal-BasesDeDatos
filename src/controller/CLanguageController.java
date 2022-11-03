/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import conection.conection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import tablas.Country;
import Gestion.GestionCountry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Eduen
 */
public class CLanguageController implements Initializable {

    @FXML
    private JFXComboBox<Country> comboPais;
    @FXML
    private Spinner<Integer> ComboPorcentaje;
    @FXML
    private JFXComboBox<String> ComboOficial;
    private GestionCountry llenar;
    ObservableList <Country> misCountry = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    
    {
         this.llenar= new GestionCountry();
         this.misCountry = this.llenar.llenarTablaPaises();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        
        ComboPorcentaje.setValueFactory(valueFactory);
      
         valueFactory.setValue(1);
         this.ComboOficial.getItems().add("Sí");
         this.ComboOficial.getItems().add("No");
         
         this.llenarComboPais();
    }

    
   private void llenarComboPais()
   {
       this.comboPais.getItems().addAll(misCountry);
       this.comboPais.setConverter(new CountryConverter());
       
   }
    
}
