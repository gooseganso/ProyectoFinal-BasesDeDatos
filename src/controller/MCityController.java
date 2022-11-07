/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCity;
import Gestion.GestionCountry;
import Gestion.crudCity;
import Gestion.showMessages;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tablas.City;

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
    private JFXComboBox<City> comboCity;
    ObservableList<City> combosCiudad=FXCollections.observableArrayList();
    @FXML
    private TextField tagPobla;
    @FXML
    private JFXComboBox<String> comboCodPais;
    @FXML
    private TextField tagNom;
    @FXML
    private JFXButton btnModify;
    private crudCity ModifyC;
    private City mCity;
    private showMessages showMessages;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.codp= new GestionCountry();
       this.llenar= new GestionCountry();
       this.combosPais= this.codp.getCodigosPais();
       this.district= new GestionCity();
       this.showMessages = new showMessages();
       this.llenarComboPais();
    }    
    
    private void llenarComboPais()
   {
       this.comboPais.getItems().addAll(combosPais);   
    
   }

    @FXML
    private void doActivarNomDep(ActionEvent event) {
        String codigoCD=this.comboCity.getSelectionModel().getSelectedItem().getName();
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
    private void doActivarCity(ActionEvent event) 
    {
        String codigoPS=this.comboPais.getSelectionModel().getSelectedItem();
        
         this.comboCity.getItems().clear();
         this.comboCity.setDisable(false);
         this.combosCiudad= this.district.nomCiudades(codigoPS);
         this.comboCity.getItems().addAll(combosCiudad);
         this.comboCity.setConverter(new CityConverter());
          
         
         
    }

    @FXML
    private void doModify(ActionEvent event) 
    {
        String mesg,nom,codp,distri;
        int popul,citySelect;
         if(this.tagNom.getText().isEmpty() || this.comboCodPais.getSelectionModel().getSelectedItem()==null || this.comboDistric.getSelectionModel().getSelectedItem()==null || this.tagPobla.getText().isEmpty())
        {
          mesg = "Los campos deben estar llenos";
          this.showMessages.showMessages(mesg, 1);
        
        }
        else
        {
            try 
            {
            citySelect=this.comboCity.getSelectionModel().getSelectedItem().getID();
            nom= this.tagNom.getText();
            codp= this.comboCodPais.getSelectionModel().getSelectedItem();
            distri= this.comboDistric.getSelectionModel().getSelectedItem();
            popul= Integer.parseInt(this.tagPobla.getText());
            this.ModifyC= new crudCity();
        
        
            this.mCity= new City(0,nom,codp,distri,popul,"C");
        
            this.ModifyC.modifyCity(mCity,citySelect);
            }
            catch (NumberFormatException nfe) 
                {

                    mesg = "Tipo de datos inccorrecto";
                    this.showMessages.showMessages(mesg, 1);

                }
        }
        
    }
    
}
