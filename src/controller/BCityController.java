/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

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
import tablas.City;
import tablas.Country;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class BCityController implements Initializable {

    @FXML
    private TableView<City> tableCity;
    @FXML
    private TableColumn<City, ?> colID;
    @FXML
    private TableColumn<City, ?> colNomb;
    @FXML
    private TableColumn<City, ?> colPais;
    @FXML
    private TableColumn<City, ?> colDistri;
    @FXML
    private TableColumn<City, ?> colPobla;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton btn_Volver;
    private LlenarTablas llenar;
    ObservableList<City> misCities = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       this.llenar= new LlenarTablas(); 
       this.misCities=this.llenar.llenarTablaCity();
       this.modelaTabla();
    }
    public void constructorNuevo(ArrayList<Country> caso) 
    {
        this.tableCity.getItems().clear();
        this.modelaTabla();

    }

    @FXML
    private void back(ActionEvent event)  throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaz/HCity.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    private void modelaTabla() 
    {
       this.llenarTablaCities();
       this.colID.setCellValueFactory(new PropertyValueFactory("ID"));
       this.colNomb.setCellValueFactory(new PropertyValueFactory("name"));
       this.colPais.setCellValueFactory(new PropertyValueFactory("countryCode"));
       this.colDistri.setCellValueFactory(new PropertyValueFactory("district"));
       this.colPobla.setCellValueFactory(new PropertyValueFactory("population"));
        
        
    }

    private void llenarTablaCities() 
    {
      tableCity.setItems(misCities);
    }
    
}
