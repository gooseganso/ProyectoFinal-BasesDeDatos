/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCountry;
import Gestion.crudCountry;
import Gestion.showMessages;
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
import tablas.Country;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ECountryController implements Initializable {

    @FXML
    private TableView<Country> tableCountry;
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
    private TableColumn<Country, ?> PIB;
    @FXML
    private TableColumn<Country, ?> HeadOfState;
    @FXML
    private TableColumn<Country, ?> Capital;
    private GestionCountry llenar;
    ObservableList<Country> misCountry = FXCollections.observableArrayList();
    @FXML
    private JFXButton btnEliminar;
    private crudCountry eliminar;
    private showMessages showMessages;
    private String query = "select * from country ";
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.llenar= new GestionCountry();
        this.misCountry = this.llenar.llenarTablaPaises(query);
        this.eliminar= new crudCountry();
        this.showMessages = new showMessages();
        this.modelaTabla();
    }    
    public void constructorNuevo(ArrayList<Country> caso) 
    {
        this.tableCountry.getItems().clear();
        this.modelaTabla();
    }
    

    private void modelaTabla() {
        
        this.llenarTablaPaises();
        
        this.Code.setCellValueFactory(new PropertyValueFactory("code"));
        this.Name.setCellValueFactory(new PropertyValueFactory("name"));
        this.Continent.setCellValueFactory(new PropertyValueFactory("continent"));
        this.Region.setCellValueFactory(new PropertyValueFactory("region"));
        this.SurfaceArea.setCellValueFactory(new PropertyValueFactory("surfaceArea"));
        this.IndepYear.setCellValueFactory(new PropertyValueFactory("indepYear"));
        this.Population.setCellValueFactory(new PropertyValueFactory("population"));
        this.LifeExp.setCellValueFactory(new PropertyValueFactory("lifeExpectancy"));
        this.HeadOfState.setCellValueFactory(new PropertyValueFactory("headOfState"));
        this.PIB.setCellValueFactory(new PropertyValueFactory("GNP"));
        this.Capital.setCellValueFactory(new PropertyValueFactory("capital"));
       
        
        
    }

    private void llenarTablaPaises() {
      tableCountry.setItems(misCountry);
    }

    @FXML
    private void doEliminar(ActionEvent event) {
      String cod, mesg;
      boolean confi;
      Country Ecountry= this.tableCountry.getSelectionModel().getSelectedItem();
      mesg = "Quiere borrar este país?   " + Ecountry.getName() ;
      confi = this.showMessages.showMessages(mesg, 3);
      try {
        if(confi)
        {
            Ecountry= this.tableCountry.getSelectionModel().getSelectedItem();
            this.eliminar.eliminarPais(Ecountry);
            this.misCountry.remove(this.tableCountry.getSelectionModel().getSelectedItem());
            this.tableCountry.refresh();
        }
          }
      catch (NumberFormatException nfe) 
        {
            mesg = "Falló la eliminación";
            this.showMessages.showMessages(mesg, 1);
        }
        
    }
    
}
