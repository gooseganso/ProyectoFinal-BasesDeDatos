/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import conection.conection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private conection conexion;
    private Connection cn;
    private Statement st;
    ObservableList<Country> misCountry = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.misCountry = FXCollections.observableArrayList();
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
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        
        try
        {
        ResultSet rs= cn.createStatement().executeQuery("Select * from country");
        
        while (rs.next())
        {
          misCountry.add(new Country(rs.getString("Code"),rs.getString("Name"),rs.getString("Continent"),rs.getString("Region"),rs.getFloat("SurfaceArea"),rs.getInt("IndepYear"),rs.getInt("Population"),rs.getFloat("LifeExpectancy"),rs.getFloat("GNP"),rs.getFloat("GNPOld"),rs.getString("LocalName"),rs.getString("GovernmentForm"),rs.getString("HeadOfState"),rs.getString("Capital"),rs.getString("Code2")));
        }
        }
        catch(Exception e)
                     {
                      System.err.println("Error: " +e);
                     }
      tableCountry.setItems(misCountry);
    }
    
}
