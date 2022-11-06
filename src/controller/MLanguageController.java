/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCountry;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MLanguageController implements Initializable {

    @FXML
    private JFXComboBox<String> comboPais;
    @FXML
    private Spinner<Integer> ComboPorcentaje;
    @FXML
    private JFXComboBox<String> ComboOficial;
    @FXML
    private JFXComboBox<String> comboPais1;
    private GestionCountry codp;
    private GestionCountry llenar;
    private ArrayList<String> combosPais;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
         this.llenar= new GestionCountry();
         this.codp= new GestionCountry();
         this.combosPais= this.codp.getCodigosPais();
         SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        
        ComboPorcentaje.setValueFactory(valueFactory);
      
         valueFactory.setValue(1);
         this.ComboOficial.getItems().add("Sí");
         this.ComboOficial.getItems().add("No");
         
         this.llenarComboPais();
    }    
    
    private void llenarComboPais()
   {
      this.comboPais1.getItems().addAll(combosPais);   
   }
}
