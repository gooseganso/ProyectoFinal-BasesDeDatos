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
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Eduen
 */
public class CLanguageController implements Initializable {

    @FXML
    private JFXComboBox<String> comboPais;
    @FXML
    private Spinner<Double> ComboPorcentaje;
    @FXML
    private JFXComboBox<String> ComboOficial;
    private GestionCountry llenar;
    ObservableList <Country> misCountry = FXCollections.observableArrayList();
    private ArrayList<String> combosPais;
    private GestionCountry codp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    
    {
         this.llenar= new GestionCountry();
         this.codp= new GestionCountry();
         this.combosPais= this.codp.getCodigosPais();
        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.5, 100);
        
        ComboPorcentaje.setValueFactory(valueFactory);
      
         valueFactory.setValue(0.0);
         this.ComboOficial.getItems().add("Sí");
         this.ComboOficial.getItems().add("No");
         
         this.llenarComboPais();
    }

    
   private void llenarComboPais()
   {
      this.comboPais.getItems().addAll(combosPais);   
   }
    
}
