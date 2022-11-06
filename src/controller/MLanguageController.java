/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCountry;
import Gestion.GestionLanguage;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MLanguageController implements Initializable {

    @FXML
    private JFXComboBox<String> comboPais;
    @FXML
    private Spinner<Double> ComboPorcentaje;
    @FXML
    private JFXComboBox<String> ComboOficial;
    @FXML
    private JFXComboBox<String> comboPais1;
    private GestionCountry codp;
    private GestionCountry llenar;
    private ArrayList<String> combosPais;
    @FXML
    private JFXComboBox<String> comboLang1;
    private ArrayList<String> combosLanguages;
    private GestionLanguage llenarL;
    @FXML
    private TextField textLanguage;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
         this.llenar= new GestionCountry();
         this.codp= new GestionCountry();
         this.llenarL= new GestionLanguage();
         this.combosPais= this.codp.getCodigosPais();
         SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100,0.5);
        
        ComboPorcentaje.setValueFactory(valueFactory);
      
         valueFactory.setValue(0.0);
         this.ComboOficial.getItems().add("Sí");
         this.ComboOficial.getItems().add("No");
         
         this.llenarComboPais();
    }    
    
    private void llenarComboPais()
   {
      this.comboPais1.getItems().addAll(combosPais);   
   }

    @FXML
    private void doLlenar(ActionEvent event) 
    {
        String codigoPS= this.comboPais1.getSelectionModel().getSelectedItem();
        this.comboLang1.setDisable(false);
        this.comboLang1.getItems().clear();
        this.combosLanguages= this.llenarL.nomLanguages(codigoPS);
        
        this.comboLang1.getItems().addAll(this.combosLanguages);
        
        
    }

    @FXML
    private void doLlenarLang(ActionEvent event) 
    {
         String codigoP= this.comboPais1.getSelectionModel().getSelectedItem();
         String Lang= this.comboLang1.getSelectionModel().getSelectedItem();
         
         this.comboPais.setDisable(false);
         this.comboPais.getItems().clear();
         this.comboPais.getItems().addAll(this.combosPais);
         this.comboPais.setValue(codigoP);
         
         
         this.textLanguage.setEditable(true);
         this.textLanguage.setText(Lang);
         
    }
}
