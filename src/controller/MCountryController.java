/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCity;
import Gestion.GestionCountry;
import Gestion.crudCountry;
import Gestion.showMessages;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import tablas.City;
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
    private TextField tagCapi;
    @FXML
    private TextField tagSuperfi;
    @FXML
    private Label tagInd;
    @FXML
    private JFXButton btnModify;
    @FXML
    private JFXComboBox<String> comboGob;
    private crudCountry EliC;
    private showMessages showMessages;
    private Country mCountry;
    private ObservableList<City> combosCiudad2=FXCollections.observableArrayList();
    Country nCountry;
    @FXML
    private JFXComboBox<String> comboCity;
    private GestionCity district;
    private GestionCountry pais;
    
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.city= new GestionCity();
        this.country = new GestionCountry();
        this.combosPais = this.country.getCodigosPais();
        this.llenarComboPaises();
        this.showMessages = new showMessages();
        this.district= new GestionCity();
        this.pais = new GestionCountry();
        
        
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
        this.tagCod1.clear();
        this.tagCod1.setText(codigoPS);
        
        this.tagCod2.clear();
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
      
        
        this.comboGob.getItems().clear();
        this.comboGob.setDisable(false);
        this.comboGob.getItems().clear();
        ArrayList<String> comboGobiernos;
        this.EliC= new crudCountry();
        comboGobiernos = this.EliC.comboGobierno();
        for(int i=0; i<comboGobiernos.size(); i++){
        this.comboGob.getItems().add(comboGobiernos.get(i));}
        this.comboGob.getSelectionModel().select(this.EliC.getGov(codigoPS));
        
        this.comboCity.getItems().clear();
         this.comboCity.setDisable(false);
         this.combosCiudad2= this.district.llenarTablaCity();
         Vector nomCiudad = new Vector<String>(); 
         
         for(City ciudad : this.combosCiudad2){
             String nom= ciudad.getName();
             nomCiudad.add(nom);
         }
         this.comboCity.getItems().addAll(nomCiudad);
         
         String codCapi = this.pais.getCapi(codigoPS);
         this.comboCity.getSelectionModel().select(this.district.getCapi(codCapi));
        
        
        
        
        
        
        
        
        
    }

    private void llenarComboPaises() {
        this.comboCountry.getItems().addAll(combosPais);   
    }

    @FXML
    private void doModify(ActionEvent event) {
        String mesg,nomP,codp1,codp2,region,continente,nomLoc,presi,capi, gob;
        int indepYear, pobla;
        float exp, PIB, PIB2,superfi;
        
        if(this.tagNom.getText().isEmpty() || this.tagCod1.getText().isEmpty() || this.tagCod2.getText().isEmpty() ||
                this.comboContinente.getSelectionModel().getSelectedItem()==null || this.comboRegion.getSelectionModel().getSelectedItem()==null
                || this.tagPobla.getText().isEmpty() || this.tagPobla.getText().isBlank() || this.tagPIB.getText().isEmpty()
                || this.tagPIB2.getText().isEmpty() || this.tagLocNom.getText().isEmpty() || this.tagSuperfi.getText().isEmpty() ||
                this.tagPresi.getText().isEmpty() || this.comboCity.getSelectionModel().getSelectedItem()==null || this.comboGob.getSelectionModel().getSelectedItem()==null){
            
            mesg = "Los campos deben estar llenos";
            this.showMessages.showMessages(mesg, 1);
            
        } else {  
            if(this.tagCod1.getText().length() > 3 || this.tagCod2.getText().length() > 2 ){
            mesg = "Un codigo o los 2 tienen un largo mayor al permitido";
            this.showMessages.showMessages(mesg, 1); 
            } else {
                try{
                    nomP = this.tagNom.getText();
                    codp1 = this.tagCod1.getText();
                    codp2 = this.tagCod2.getText();
                    region = this.comboRegion.getSelectionModel().getSelectedItem();
                    continente = this.comboContinente.getSelectionModel().getSelectedItem();
                    pobla = Integer.parseInt(this.tagPobla.getText());
                    indepYear = (int) this.sliderInd.getValue();
                    exp = this.spinnerExp.getValue();
                    PIB = Float.parseFloat(this.tagPIB.getText());
                    PIB2 = Float.parseFloat(this.tagPIB2.getText());
                    nomLoc = this.tagLocNom.getText();
                    capi = this.comboCity.getSelectionModel().getSelectedItem();
                    presi = this.tagPresi.getText();
                    superfi = Float.parseFloat(this.tagSuperfi.getText());
                    gob = this.comboGob.getSelectionModel().getSelectedItem();
                    this.EliC= new crudCountry();
                    this.pais = new GestionCountry();
                    
                    
                    
                    this.mCountry =new Country(codp1,nomP,continente,region,superfi,indepYear,pobla,exp,PIB,PIB2,nomLoc,gob,presi,this.district.getCodCity(capi),codp2,"a");
                    
                    this.EliC.modifyCountry(mCountry,codp1);
                    
                    
                }catch (NumberFormatException nfe) 
                {

                    mesg = "Tipo de datos inccorrecto";
                    this.showMessages.showMessages(mesg, 1);

                }
            }
        
    }
    
}
}
