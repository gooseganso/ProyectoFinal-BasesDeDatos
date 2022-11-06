/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionLanguage;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import tablas.CountryLanguage;

/**
 * FXML Controller class
 *
 * @author Eduen
 */
public class BLanguageController implements Initializable {

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
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton btn_Volver;
    
    private GestionLanguage llenar;
    ObservableList<CountryLanguage> misLanguages = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.llenar= new GestionLanguage();
        this.misLanguages = this.llenar.llenarTablaLanguage();
        this.modelaTabla();
    }    

    @FXML
    private void volver(ActionEvent event) throws IOException 
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/HLanguage.fxml"));
        
        
        rootPane.getChildren().setAll(pane);
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
      
   
}

