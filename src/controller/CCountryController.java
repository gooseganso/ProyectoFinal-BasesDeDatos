/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class CCountryController implements Initializable {

    @FXML
    private Spinner<Integer> spinner_Ezp;
    @FXML
    private JFXComboBox<String> boxContinente;
    @FXML
    private JFXComboBox<String> boxRegion;
    @FXML
    private JFXButton btn_CrearP;
    @FXML
    private TextField tagNom;
    @FXML
    private TextField tagCod;
    @FXML
    private TextField tagCod2;
    @FXML
    private JFXSlider sliderInd;
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
        
     
      SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 150);
      
      valueFactory.setValue(1);
      
      spinner_Ezp.setValueFactory(valueFactory);
      
      
      
      this.boxContinente.getItems().add("Asia");
      this.boxContinente.getItems().add("Europe");
      this.boxContinente.getItems().add("North America");
      this.boxContinente.getItems().add("Africa");
      this.boxContinente.getItems().add("Oceania");
      this.boxContinente.getItems().add("Antartica");
      this.boxContinente.getItems().add("South America");
      
       this.sliderInd.adjustValue(0);
        this.sliderInd.setDisable(false);
        this.sliderInd.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               tagInd.setText(Integer.toString((int)sliderInd.getValue()));
            }
        });
      
      
      
    }    

    @FXML
    private void doRegion(ActionEvent event) {
        
        this.boxRegion.getItems().clear();
        
        this.boxRegion.setDisable(false);
    
        if(this.boxContinente.getSelectionModel().getSelectedItem().equals("Asia"))
        {
          this.boxRegion.getItems().add("Southern and central Asia");
          this.boxRegion.getItems().add("Middle East");
          this.boxRegion.getItems().add("Southeast Asia");
          this.boxRegion.getItems().add("Eastern Asia");
        
        }
        
        else
        {
          if (this.boxContinente.getSelectionModel().getSelectedItem().equals("Europe"))
          {
           this.boxRegion.getItems().add("Southern Europe");
           this.boxRegion.getItems().add("Western Europe");
           this.boxRegion.getItems().add("Eastern Europe");
           this.boxRegion.getItems().add("Nordic Countries");
           this.boxRegion.getItems().add("Baltic Countries");
           this.boxRegion.getItems().add("British Islands");
          
          }
          
          else
          {
            if(this.boxContinente.getSelectionModel().getSelectedItem().equals("North America"))
            {
             this.boxRegion.getItems().add("Caribbean");
             this.boxRegion.getItems().add("Central America");
             this.boxRegion.getItems().add("North America");
            }
            
            else
            {
              if(this.boxContinente.getSelectionModel().getSelectedItem().equals("Africa"))
              {
               this.boxRegion.getItems().add("Central Africa");
               this.boxRegion.getItems().add("Eastern Africa");
               this.boxRegion.getItems().add("Western Africa");
               this.boxRegion.getItems().add("Southern Africa");
               this.boxRegion.getItems().add("Northern Africa");
              
              }
              
              else
              {
                if(this.boxContinente.getSelectionModel().getSelectedItem().equals("Oceania"))
                {
                  this.boxRegion.getItems().add("Polynesia");
                  this.boxRegion.getItems().add("Australia and New Zealand");
                  this.boxRegion.getItems().add("Melanesia");
                  this.boxRegion.getItems().add("Micronesia");
                  this.boxRegion.getItems().add("Micronesia/Caribbean");
                
                }
                
                else
                {
                 if(this.boxContinente.getSelectionModel().getSelectedItem().equals("Antartica"))
                 {
                  this.boxRegion.getItems().add("Antartica");
                 }
                 
                 else
                 {
                   this.boxRegion.getItems().add("South America");
                 }
                }
              }
            }
          }
        }
    }

    @FXML
    private void doCrearP(ActionEvent event) 
    {
        
    }
    
    
    
}
