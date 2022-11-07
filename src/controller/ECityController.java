/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCity;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tablas.City;
import tablas.Country;
import Gestion.crudCity;
import Gestion.showMessages;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ECityController implements Initializable {

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
     private GestionCity llenar;
    ObservableList<City> misCities = FXCollections.observableArrayList();
    @FXML
    private JFXButton btnEliminar;
    
    private crudCity eliminar;
    private showMessages showMessages;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.llenar= new GestionCity(); 
       this.eliminar= new crudCity();
       this.showMessages = new showMessages();
       this.misCities=this.llenar.llenarTablaCity();
       this.modelaTabla();
   
    }    
    public void constructorNuevo(ArrayList<Country> caso) 
    {
        this.tableCity.getItems().clear();
        this.modelaTabla();

    }

    private void modelaTabla() {
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

    @FXML
    private void doEliminar(ActionEvent event) 
    {
      String cod, mesg;
      boolean confi;
      mesg = "Quiere borrar el producto?...";
      confi = this.showMessages.showMessages(mesg, 3);
      try {
        if(confi)
        {
            City Ecity= this.tableCity.getSelectionModel().getSelectedItem();
            this.eliminar.eliminarCiudad(Ecity);
            this.misCities.remove(this.tableCity.getSelectionModel().getSelectedItem());
            this.tableCity.refresh();
        }
          }
      catch (NumberFormatException nfe) 
        {
            mesg = "Falló la eliminación";
            this.showMessages.showMessages(mesg, 1);
        }
      
      
 
    }
    
    
        
    
    
}
