/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCity;
import Gestion.GestionCountry;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import tablas.Country;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MCountryController implements Initializable {

    @FXML
    private JFXComboBox<String> comboCountry;
    private ArrayList<String> combosPais;
    private GestionCountry country;
    private GestionCity city;
   private ArrayList<String> combosCiudad;
    @FXML
    private TextField tagNom;
    @FXML
    private TextField tagCod1;
    @FXML
    private TextField tagCod2;
    @FXML
    private JFXComboBox<String> comboContinente;
    @FXML
    private JFXComboBox<String> comboRegion;
    @FXML
    private JFXSlider sliderInd;
    @FXML
    private Spinner<Integer> spinnerExp;
    @FXML
    private TextField tagLocNom;
    @FXML
    private TextField tagPresi;
    @FXML
    private TextField tagPobla;
    @FXML
    private TextField tagPIB;
    @FXML
    private TextField tagPIB2;
    @FXML
    private TextField tagCapi;
    @FXML
    private TextField tagSuperfi;
    @FXML
    private Label tagInd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.city= new GestionCity();
        this.country = new GestionCountry();
        this.combosPais = this.country.getCodigosPais();
        this.llenarComboPaises();
        
        
      SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 150);
      
      valueFactory.setValue(1);
      
      spinnerExp.setValueFactory(valueFactory);
      this.comboContinente.getItems().add("Asia");
      this.comboContinente.getItems().add("Europe");
      this.comboContinente.getItems().add("North America");
      this.comboContinente.getItems().add("Africa");
      this.comboContinente.getItems().add("Oceania");
      this.comboContinente.getItems().add("Antartica");
      this.comboContinente.getItems().add("South America");
    }    

    @FXML
    private void doRegion() {
        this.comboRegion.getItems().clear();
        
        this.comboRegion.setDisable(false);
    
        if(this.comboContinente.getSelectionModel().getSelectedItem().equals("Asia"))
        {
          this.comboRegion.getItems().add("Southern and central Asia");
          this.comboRegion.getItems().add("Middle East");
          this.comboRegion.getItems().add("Southeast Asia");
          this.comboRegion.getItems().add("Eastern Asia");
        
        }
        
        else
        {
          if (this.comboContinente.getSelectionModel().getSelectedItem().equals("Europe"))
          {
           this.comboRegion.getItems().add("Southern Europe");
           this.comboRegion.getItems().add("Western Europe");
           this.comboRegion.getItems().add("Eastern Europe");
           this.comboRegion.getItems().add("Nordic Countries");
           this.comboRegion.getItems().add("Baltic Countries");
           this.comboRegion.getItems().add("British Islands");
          
          }
          
          else
          {
            if(this.comboContinente.getSelectionModel().getSelectedItem().equals("North America"))
            {
             this.comboRegion.getItems().add("Caribbean");
             this.comboRegion.getItems().add("Central America");
             this.comboRegion.getItems().add("North America");
            }
            
            else
            {
              if(this.comboContinente.getSelectionModel().getSelectedItem().equals("Africa"))
              {
               this.comboRegion.getItems().add("Central Africa");
               this.comboRegion.getItems().add("Eastern Africa");
               this.comboRegion.getItems().add("Western Africa");
               this.comboRegion.getItems().add("Southern Africa");
               this.comboRegion.getItems().add("Northern Africa");
              
              }
              
              else
              {
                if(this.comboContinente.getSelectionModel().getSelectedItem().equals("Oceania"))
                {
                  this.comboRegion.getItems().add("Polynesia");
                  this.comboRegion.getItems().add("Australia and New Zealand");
                  this.comboRegion.getItems().add("Melanesia");
                  this.comboRegion.getItems().add("Micronesia");
                  this.comboRegion.getItems().add("Micronesia/Caribbean");
                
                }
                
                else
                {
                 if(this.comboContinente.getSelectionModel().getSelectedItem().equals("Antartica"))
                 {
                  this.comboRegion.getItems().add("Antartica");
                 }
                 
                 else
                 {
                   this.comboRegion.getItems().add("South America");
                 }
                }
              }
            }
          }
        }
    }

    @FXML
    private void doActAll(ActionEvent event) {
 
        String codigoPS =this.comboCountry.getSelectionModel().getSelectedItem();
        
        this.tagCod1.clear();
        this.tagCod1.setDisable(false);
        this.tagCod1.clear();
        this.tagCod1.setText(codigoPS);
        
        this.tagCod2.clear();
        this.tagCod2.setDisable(false);
        this.tagCod2.clear();
        this.tagCod2.setText(this.country.getCode2(codigoPS));
        
        this.tagNom.clear();
        this.tagNom.setDisable(false);
        this.tagNom.clear();
        this.tagNom.setText(this.country.getName(codigoPS));
        
        this.tagLocNom.clear();
        this.tagLocNom.setDisable(false);
        this.tagLocNom.clear();
        this.tagLocNom.setText(this.country.getLocName(codigoPS));
        
        
        this.comboRegion.setDisable(false);
        this.comboRegion.setValue(this.country.getRegion(codigoPS));
        
        this.comboContinente.setDisable(false);
        this.comboContinente.setValue(this.country.getContinente(codigoPS));
        
        this.tagPobla.clear();
        this.tagPobla.setDisable(false);
        this.tagPobla.clear();
        this.tagPobla.setText(this.country.getPobla(codigoPS));
        
        this.sliderInd.adjustValue(0);
        this.sliderInd.setDisable(false);
        this.sliderInd.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               tagInd.setText(Integer.toString((int)sliderInd.getValue()));
            }
        });
        this.sliderInd.adjustValue(this.country.getInd(codigoPS));
        
        this.spinnerExp.getEditor().clear();
        this.spinnerExp.setDisable(false);
        this.spinnerExp.getEditor().clear();
        this.spinnerExp.getValueFactory().setValue(this.country.getExp(codigoPS));
        
        this.tagPresi.clear();
        this.tagPresi.setDisable(false);
        this.tagPresi.clear();
        this.tagPresi.setText(this.country.getPresi(codigoPS));
        
        this.tagPIB.clear();
        this.tagPIB.setDisable(false);
        this.tagPIB.clear();
        this.tagPIB.setText(this.country.getPIB(codigoPS));
        
        this.tagPIB2.clear();
        this.tagPIB2.setDisable(false);
        this.tagPIB2.clear();
        this.tagPIB2.setText(this.country.getPIB2(codigoPS));
        
        this.tagSuperfi.clear();
        this.tagSuperfi.setDisable(false);
        this.tagSuperfi.clear();
        this.tagSuperfi.setText(this.country.getSuperfi(codigoPS));
        
        this.tagCapi.clear();
        String codCapi = this.country.getCapi(codigoPS);
        this.tagCapi.setDisable(false);
        this.tagCapi.clear();
        this.tagCapi.setText(this.city.getCapi(codCapi));
        
        
        
        
        
        
        
        
    }

    private void llenarComboPaises() {
        this.comboCountry.getItems().addAll(combosPais);   
    }
    
}
