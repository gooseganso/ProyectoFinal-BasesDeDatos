/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCountry;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import tablas.Country;
 
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class BCountryController implements Initializable {

    @FXML
    private JFXButton btn_Volver;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Country> tableC;
    
 
    @FXML
    private TableColumn<Country, ?> Code;
    @FXML
    private TableColumn<Country, ?> Name;
    @FXML
    private TableColumn<Country, ?> Continent;
    @FXML
    private TableColumn<Country, ?> Region;
    @FXML
    private TableColumn<Country, ?> SurfaceArea;
    @FXML
    private TableColumn<Country, ?> IndepYear;
    @FXML
    private TableColumn<Country, ?> Population;
    @FXML
    private TableColumn<Country, ?> LifeExp;
    @FXML
    private TableColumn<Country, ?> GNP;
    @FXML
    private TableColumn<Country, ?> GNPOld;
    @FXML
    private TableColumn<Country, ?> LocalName;
    @FXML
    private TableColumn<Country, ?> GovermentForm;
    @FXML
    private TableColumn<Country, ?> HeadOfState;
    @FXML
    private TableColumn<Country, ?> Code2;
    @FXML
    private TableColumn<Country, ?> Capital;
    
    private GestionCountry llenar;
    
    ObservableList<Country> misCountry = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Country, ?> lengua;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.llenar= new GestionCountry();
        this.misCountry = this.llenar.llenarTablaPaises();
        this.modelaTabla();
        // TODO
    }    
    public void constructorNuevo(ArrayList<Country> caso) 
    {
        this.tableC.getItems().clear();
        this.modelaTabla();

    }
    
    @FXML
    private void back(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/HCountry.fxml"));
        
        
        rootPane.getChildren().setAll(pane);
    }
    
    
    private void modelaTabla() 
    {
        
        this.llenarTablaPaises();
        
        this.Code.setCellValueFactory(new PropertyValueFactory("code"));
        this.Name.setCellValueFactory(new PropertyValueFactory("name"));
        this.Continent.setCellValueFactory(new PropertyValueFactory("continent"));
        this.Region.setCellValueFactory(new PropertyValueFactory("region"));
        this.SurfaceArea.setCellValueFactory(new PropertyValueFactory("surfaceArea"));
        this.IndepYear.setCellValueFactory(new PropertyValueFactory("indepYear"));
        this.Population.setCellValueFactory(new PropertyValueFactory("population"));
        this.LifeExp.setCellValueFactory(new PropertyValueFactory("lifeExpectancy"));
        this.GNP.setCellValueFactory(new PropertyValueFactory("GNP"));
        this.GNPOld.setCellValueFactory(new PropertyValueFactory("GNPOld"));
        this.LocalName.setCellValueFactory(new PropertyValueFactory("localName"));
        this.GovermentForm.setCellValueFactory(new PropertyValueFactory("governmentForm"));
        this.HeadOfState.setCellValueFactory(new PropertyValueFactory("headOfState"));
        this.Capital.setCellValueFactory(new PropertyValueFactory("capital"));
        this.Code2.setCellValueFactory(new PropertyValueFactory("code2"));
        this.lengua.setCellValueFactory(new PropertyValueFactory("lenguajeOficial"));
        
        
    }
    
    
    public void llenarTablaPaises() 
    {
      tableC.setItems(misCountry);
    }
      
    }
    
