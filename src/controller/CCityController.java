/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCountry;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Gestion.GestionCity;
import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import javafx.scene.control.TextField;
import tablas.City;
import Gestion.crudCity;
import Gestion.showMessages;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class CCityController implements Initializable {

    @FXML
    private JFXComboBox<String> comboPais;
    private ArrayList<String> combosPais;
    private GestionCountry llenar;
    private GestionCountry codp;
    private GestionCity district;
    @FXML
    private JFXComboBox<String> comboDistric;
    private ArrayList<String> combosDistrito;
    private City nCity;
    @FXML
    private TextField tagNom;
    @FXML
    private TextField tagPobla;
    @FXML
    private JFXButton btnCrear;
    private crudCity crearC;
    private showMessages showMessages;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
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
    private void doDistrict(ActionEvent event) 
   {
      String codigoPS=this.comboPais.getSelectionModel().getSelectedItem();
          
      this.comboDistric.getItems().clear();
      this.comboDistric.setDisable(false);
      this.combosDistrito= this.district.codigoDistritos(codigoPS);
      if(this.combosDistrito.isEmpty()){
          this.comboDistric.getItems().add("-");
      
      }
      
      else{this.comboDistric.getItems().addAll(combosDistrito);}
    }

    @FXML
    private void doCrear(ActionEvent event) 
    {
        String mesg,nom,codp,distri;
        int popul;
        
        if(this.tagNom.getText().isEmpty() || this.comboPais.getSelectionModel().getSelectedItem()==null || this.comboDistric.getSelectionModel().getSelectedItem()==null || this.tagPobla.getText().isEmpty())
        {
          mesg = "Los campos deben estar llenos";
          this.showMessages.showMessages(mesg, 1);
        
        }
        else
        {
            if(this.tagNom.getText().length()>35)
            {
               mesg = "El nombre excede el número de carácteres permitidos";
               this.showMessages.showMessages(mesg, 1);
            
            }
            else
            {
                try 
                   {
                        nom= this.tagNom.getText();
                        codp= this.comboPais.getSelectionModel().getSelectedItem();
                        distri= this.comboDistric.getSelectionModel().getSelectedItem();
                        popul= Integer.parseInt(this.tagPobla.getText());
                        this.crearC= new crudCity();
        
        
                        this.nCity= new City(0,nom,codp,distri,popul,"C");
        
                        this.crearC.crearCity(nCity);
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
