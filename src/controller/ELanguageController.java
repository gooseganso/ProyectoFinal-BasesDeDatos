/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionLanguage;
import Gestion.crudCountryLanguage;
import Gestion.showMessages;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tablas.CountryLanguage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ELanguageController implements Initializable {

    @FXML
    private TableView<CountryLanguage> tableLang;
    @FXML
    private TableColumn<CountryLanguage, ?> colCountry;
    @FXML
    private TableColumn<CountryLanguage, ?> colLang;
    @FXML
    private TableColumn<CountryLanguage, ?> colOficial;
    @FXML
    private TableColumn<CountryLanguage, ?> colPorcentaje;
    private GestionLanguage llenar;
    ObservableList<CountryLanguage> misLanguages = FXCollections.observableArrayList();
    @FXML
    private JFXButton btnEliminar;
    private showMessages showMessages;
    private crudCountryLanguage eliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.llenar= new GestionLanguage();
        this.misLanguages = this.llenar.llenarTablaLanguage();
        this.showMessages = new showMessages();
        this.eliminar= new crudCountryLanguage();
        this.modelaTabla();
    }    
    private void modelaTabla() 
    {
        
        this.llenarTablaPaises();
        
        this.colCountry.setCellValueFactory(new PropertyValueFactory("countryCode"));
        this.colLang.setCellValueFactory(new PropertyValueFactory("language"));
        this.colOficial.setCellValueFactory(new PropertyValueFactory("isOfficial"));
        this.colPorcentaje.setCellValueFactory(new PropertyValueFactory("percentage"));
        
        
    }
    
    
    public void llenarTablaPaises() 
    {
      tableLang.setItems(misLanguages);
    }

    @FXML
    private void doEliminar(ActionEvent event) 
    {
      String cod,lang,mesg;
      boolean confi;
      CountryLanguage ELang= this.tableLang.getSelectionModel().getSelectedItem();
      mesg = "Quiere borrar esta ciudad?   " + ELang.getLanguage() ;
      confi = this.showMessages.showMessages(mesg, 3);
      try {
        if(confi)
        {
            ELang= this.tableLang.getSelectionModel().getSelectedItem();
            this.eliminar.eliminarLang(ELang);
            this.misLanguages.remove(this.tableLang.getSelectionModel().getSelectedItem());
            this.tableLang.refresh();
        }
          }
      catch (NumberFormatException nfe) 
        {
            mesg = "Falló la eliminación";
            this.showMessages.showMessages(mesg, 1);
        }
    }
}
