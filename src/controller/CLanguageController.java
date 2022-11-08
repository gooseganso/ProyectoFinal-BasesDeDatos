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
import Gestion.crudCity;
import Gestion.crudCountryLanguage;
import Gestion.showMessages;
import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import tablas.City;
import tablas.CountryLanguage;

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
    @FXML
    private JFXButton btnCrear;
    @FXML
    private TextField txtLang;
    private showMessages showMessages;
    private crudCountryLanguage crearL;
    private CountryLanguage nLang;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    
    {
         this.llenar= new GestionCountry();
         this.codp= new GestionCountry();
         this.combosPais= this.codp.getCodigosPais();
         this.showMessages = new showMessages();
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

    @FXML
    private void doCrear(ActionEvent event) 
    {
       String pais,language,mesg;
       char oficial;
       float porcentaje;
       double porcen;
       
       if(this.comboPais.getSelectionModel().getSelectedItem()==null||this.txtLang.getText().isEmpty()||this.ComboOficial.getSelectionModel().getSelectedItem()==null)
       {
          mesg = "Los campos deben estar llenos";
          this.showMessages.showMessages(mesg, 1);
       }
       else
       {
          if(this.txtLang.getText().length()>30)
            {
               mesg = "El nombre excede el número de carácteres permitidos";
               this.showMessages.showMessages(mesg, 1);
            
            }
            else
            {
                try 
                   {
                        
                        pais= this.comboPais.getSelectionModel().getSelectedItem();
                        language= this.txtLang.getText();
                        if(this.ComboOficial.getSelectionModel().getSelectedItem().equals("Sí"))
                        {
                          oficial='T';
                        }
                        else
                        {
                          oficial='F';
                        }
                        porcen= this.ComboPorcentaje.getValue();
                        porcentaje= (float)porcen;
                        this.crearL= new crudCountryLanguage();
        
        
                        this.nLang= new CountryLanguage(pais,language,oficial,porcentaje);
        
                        this.crearL.crearLang(nLang);
                    }
                catch (NumberFormatException nfe) 
                    {

                        mesg = "Tipo de datos inccorrecto";
                        this.showMessages.showMessages(mesg, 1);

                    }
            }
            
       }
    }
    
}
