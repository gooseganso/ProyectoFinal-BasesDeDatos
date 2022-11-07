/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCity;
import Gestion.GestionCountry;
import Gestion.crudCountry;
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
import Gestion.showMessages;
import java.util.ArrayList;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tablas.City;
import tablas.Country;

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
    private TextField tagSuperfi;
    @FXML
    private Label tagInd;
    private showMessages showMessages;
    @FXML
    private JFXComboBox<String> comboCity;
    private GestionCity district;
    private GestionCountry pais;
    ObservableList<City> combosCiudad=FXCollections.observableArrayList();
    Country nCountry;
    private crudCountry createC;
    @FXML
    private JFXComboBox<String> comboGob;

    /**
     * Initializes the controller class.
     */
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     this.district= new GestionCity();
     
     this.showMessages = new showMessages();
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
        
         this.comboCity.getItems().clear();
         this.comboCity.setDisable(false);
         this.combosCiudad= this.district.llenarTablaCity();
         Vector nomCiudad = new Vector<String>(); 
         
         for(City ciudad : this.combosCiudad){
             String nom= ciudad.getName();
             nomCiudad.add(nom);
         }
         this.comboCity.getItems().addAll(nomCiudad);
         
        this.comboGob.getItems().clear();
        ArrayList<String> comboGobiernos;
        this.createC= new crudCountry();
        comboGobiernos = this.createC.comboGobierno();
        
        for(int i=0; i<comboGobiernos.size(); i++)
        this.comboGob.getItems().add(comboGobiernos.get(i));
      
      
      
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
    private void doCrearP(ActionEvent event) {
        this.validaciones();
        
    }

    private void validaciones() {
        String mesg,nomP,codp1,codp2,region,continente,nomLoc,presi,capi, gob;
        int indepYear, pobla;
        float exp, PIB, PIB2,superfi;
        
        if(this.tagNom.getText().isEmpty() || this.tagCod.getText().isEmpty() || this.tagCod2.getText().isEmpty() ||
                this.boxContinente.getSelectionModel().getSelectedItem()==null || this.boxRegion.getSelectionModel().getSelectedItem()==null
                || this.tagPobla.getText().isEmpty() || this.tagPobla.getText().isBlank() || this.tagPIB.getText().isEmpty()
                || this.tagPIB2.getText().isEmpty() || this.tagLocNom.getText().isEmpty() || this.tagSuperfi.getText().isEmpty() ||
                this.tagPresi.getText().isEmpty() || this.comboCity.getSelectionModel().getSelectedItem()==null || this.comboGob.getSelectionModel().getSelectedItem()==null){
            
            mesg = "Los campos deben estar llenos";
            this.showMessages.showMessages(mesg, 1);
            
        } else {  
            if(this.tagCod.getText().length() > 3 || this.tagCod2.getText().length() > 2 ){
            mesg = "Un codigo o los 2 tienen un largo mayor al permitido";
            this.showMessages.showMessages(mesg, 1); 
            } else {
                try{
                    nomP = this.tagNom.getText();
                    codp1 = this.tagCod.getText();
                    codp2 = this.tagCod2.getText();
                    region = this.boxRegion.getSelectionModel().getSelectedItem();
                    continente = this.boxContinente.getSelectionModel().getSelectedItem();
                    pobla = Integer.parseInt(this.tagPobla.getText());
                    indepYear = (int) this.sliderInd.getValue();
                    exp = this.spinner_Ezp.getValue();
                    PIB = Float.parseFloat(this.tagPIB.getText()+0.00);
                    PIB2 = Float.parseFloat(this.tagPIB2.getText()+0.00);
                    nomLoc = this.tagLocNom.getText();
                    capi = this.comboCity.getSelectionModel().getSelectedItem();
                    presi = this.tagPresi.getText();
                    superfi = Float.parseFloat(this.tagSuperfi.getText());
                    gob = this.comboGob.getSelectionModel().getSelectedItem();
                    this.createC= new crudCountry();
                    this.pais = new GestionCountry();
                    
                    
                    
                    this.nCountry =new Country(codp1,nomP,continente,region,superfi,indepYear,pobla,exp,PIB,PIB2,nomLoc,gob,presi,this.district.getCodCity(capi),codp2,"a");
                    
                   this.createC.crearCountry(nCountry);
                    
                    
                }catch (NumberFormatException nfe) 
                {

                    mesg = "Tipo de datos inccorrecto";
                    this.showMessages.showMessages(mesg, 1);

                }
            }
            
        }
        
    }
        
    
    
    
}
