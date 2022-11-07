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
import Gestion.GestionCity;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import Gestion.crudCity;

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
    private GestionCity llenar;
    ObservableList<City> misCities = FXCollections.observableArrayList();
    @FXML
    private JFXRadioButton radioAscen;
    @FXML
    private JFXRadioButton radioDescen;
    @FXML
    private JFXCheckBox checkPobla;
    @FXML
    private JFXCheckBox checkPais;
    @FXML
    private JFXCheckBox checkDistrict;
    @FXML
    private JFXRadioButton menorigual;
    @FXML
    private JFXRadioButton mayor;
    @FXML
    private JFXRadioButton igual;
    @FXML
    private JFXRadioButton menor;
    @FXML
    private JFXRadioButton mayorigual;
    @FXML
    private JFXComboBox<?> comboPais;
    @FXML
    private JFXComboBox<?> comboDistrito;
    @FXML
    private JFXComboBox<String> comboFiltro;
    @FXML
    private Spinner<Integer> spinnerLimit;
    @FXML
    private JFXButton btnFiltro;
    
    private crudCity filtrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       this.llenar= new GestionCity(); 
       this.misCities=this.llenar.llenarTablaCity();
       SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000);
       this.spinnerLimit.setValueFactory(valueFactory);
       valueFactory.setValue(1);
       this.comboFiltro();
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
    
    private void comboFiltro()
    {
      this.comboFiltro.getItems().add("ID");
      this.comboFiltro.getItems().add("Nombre");
      this.comboFiltro.getItems().add("País");
      this.comboFiltro.getItems().add("Distrito");
      this.comboFiltro.getItems().add("Población");
    }

    private void llenarTablaCities() 
    {
      tableCity.setItems(misCities);
    }

    @FXML
    private void doFiltroAscen(ActionEvent event) 
    {
        this.radioDescen.setSelected(false);
    }

    @FXML
    private void doFiltroDescen(ActionEvent event) 
    {
        this.radioAscen.setSelected(false);
    }

    @FXML
    private void doFiltrarpobla(ActionEvent event) 
    {
        this.mayor.setSelected(false);
        this.mayorigual.setSelected(false);
        this.igual.setSelected(false);
        this.menorigual.setSelected(false);
        this.menor.setSelected(false);
        
        if(this.checkPobla.isSelected())
        {
         this.mayor.setDisable(false);
         this.mayorigual.setDisable(false);
         this.menorigual.setDisable(false);
         this.menor.setDisable(false);
         this.igual.setDisable(false);
        }
        else
        {
          this.mayor.setDisable(true);
          this.mayorigual.setDisable(true);
          this.menorigual.setDisable(true);
          this.menor.setDisable(true);
          this.igual.setDisable(true);
        }
        
    }

    @FXML
    private void dofiltrarPais(ActionEvent event) 
    {
        this.comboPais.setDisable(false);
    }

    @FXML
    private void doFiltrarDistrict(ActionEvent event) 
    {
    }

    @FXML
    private void doMenorigual(ActionEvent event) 
    {
        this.menor.setSelected(false);
        this.igual.setSelected(false);
        this.mayor.setSelected(false);
        this.mayorigual.setSelected(false);
    }

    @FXML
    private void doMayor(ActionEvent event) 
    {
        this.menor.setSelected(false);
        this.igual.setSelected(false);
        this.menorigual.setSelected(false);
        this.mayorigual.setSelected(false);
    }

    @FXML
    private void doIgual(ActionEvent event) 
    {
        this.menor.setSelected(false);
        this.menorigual.setSelected(false);
        this.mayor.setSelected(false);
        this.mayorigual.setSelected(false);
    }

    @FXML
    private void doMenor(ActionEvent event) 
    {
        this.menorigual.setSelected(false);
        this.igual.setSelected(false);
        this.mayor.setSelected(false);
        this.mayorigual.setSelected(false);
    }

    @FXML
    private void doMayorIgual(ActionEvent event) 
    {
        this.menor.setSelected(false);
        this.igual.setSelected(false);
        this.mayor.setSelected(false);
        this.menorigual.setSelected(false);
    }

    @FXML
    private void doFiltrar(ActionEvent event) 
    {
        this.filtrar= new crudCity();
        String filtro,order="",filtroSend="" ;
        int limit;
        
        filtro=this.comboFiltro.getSelectionModel().getSelectedItem();
        limit=this.spinnerLimit.getValue();
        if(this.radioAscen.isSelected())
        {
          order="asc";
        }
        else
        {
          if(this.radioDescen.isSelected())
          {
              order="desc";
          }
              
        }
        switch (filtro) 
        {
            case "ID" -> filtroSend="ID";
            case "Nombre" -> filtroSend="name";
            case "País" -> filtroSend="countrycode";
            case "Distrito" -> filtroSend="district";
            case "Población" -> filtroSend="population";
            default -> {
            } 
        }
        
        this.misCities= this.filtrar.ordenarCity(filtroSend, order, limit);
        this.llenarTablaCities();
        this.tableCity.refresh();
        
    }
    
}
