/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCountry;
import Gestion.Query;
import Gestion.crudCountry;
import Gestion.showMessages;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
    @FXML
    private JFXComboBox<String> comboFiltro;
    @FXML
    private JFXRadioButton radioAscen;
    @FXML
    private JFXRadioButton radioDescen;
    @FXML
    private Spinner<Integer> spinnerLimit;
    @FXML
    private JFXButton btnFiltro;
    private showMessages showMessages;
    private String query = "select * from country ";
    private int Select = 0;
    @FXML
    private JFXRadioButton radioConti;
    @FXML
    private JFXRadioButton radioReg;
    @FXML
    private JFXRadioButton radioSuperfi;
    @FXML
    private JFXRadioButton radioInd;
    @FXML
    private JFXRadioButton radioPobla;
    @FXML
    private JFXRadioButton radioExp;
    @FXML
    private JFXRadioButton radioPIB;
    @FXML
    private JFXRadioButton radioPIB2;
    @FXML
    private JFXRadioButton radioNomLoc;
    @FXML
    private JFXRadioButton radioGov;
    @FXML
    private JFXRadioButton radioPresi;
    @FXML
    private JFXRadioButton radioCapi;
    @FXML
    private JFXRadioButton radioCod2;
    @FXML
    private JFXRadioButton radioLen;
    @FXML
    private JFXComboBox<String> comboConti;
    @FXML
    private JFXComboBox<String> comboLeng;
    @FXML
    private JFXComboBox<String> comboGov;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.llenar= new GestionCountry();
        this.showMessages = new showMessages();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000);
       this.spinnerLimit.setValueFactory(valueFactory);
       valueFactory.setValue(0);
        
        this.modelaTabla();
        this.llenarComboFil();
        this.radioAscen.selectedProperty().set(true);
        this.llenarComboConti();
        this.llenarComboLen();
        this.llenarComboGov();
        
        
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
      this.misCountry = this.llenar.llenarTablaPaises(query);
      tableC.setItems(misCountry);
    }

    @FXML
    private void doFiltroAscen(ActionEvent event) {
        this.radioDescen.setSelected(false);
    }

    @FXML
    private void doFiltroDescen(ActionEvent event) {
        this.radioAscen.setSelected(false);
    }

    @FXML
    private void doFiltrar(ActionEvent event) {
        this.query = "select * from country ";
        this.ordenar();
        this.ocultar();
    }

    private void llenarComboFil() {
         this.comboFiltro.getItems().clear();
         this.comboFiltro.getItems().add("Código");
         this.comboFiltro.getItems().add("Nombre");
         this.comboFiltro.getItems().add("Continente");
         this.comboFiltro.getItems().add("Región");
         this.comboFiltro.getItems().add("Área superficie");
         this.comboFiltro.getItems().add("Año independencia");
         this.comboFiltro.getItems().add("Población");
         this.comboFiltro.getItems().add("Expectativa de vida");
         this.comboFiltro.getItems().add("PIB");
         this.comboFiltro.getItems().add("Nombre local");
         this.comboFiltro.getItems().add("Forma de gobierno");
         this.comboFiltro.getItems().add("Cabeza de estado");
         this.comboFiltro.getItems().add("Capital");
         try{
            this.comboFiltro.getSelectionModel().select(this.Select);
        } catch(Exception e){
            this.comboFiltro.getSelectionModel().select(1);
        }
       }
    private void ordenar(){
        Query q = new Query();
        String combo = "";
        String radio = "";
        String limit = "";
        combo = this.comboFiltro.getSelectionModel().getSelectedItem();
        this.Select = this.comboFiltro.getSelectionModel().getSelectedIndex();
        if(this.radioAscen.isSelected())
            radio = "asc";
        if(this.radioDescen.isSelected())
            radio = "desc";
        if(Integer.parseInt(this.spinnerLimit.getValue().toString()) > 0)
            limit = "limit " + this.spinnerLimit.getValue().toString();
        this.query += q.orderBy(combo, radio, limit);
        this.llenarTablaPaises();
    }

    private void ocultar() {
        
        this.modelaTabla();
        if(this.radioConti.isSelected()){
            this.Continent.setVisible(false);
        }else{
            this.Continent.setVisible(true);
        }
        if(this.radioReg.isSelected()){
            this.Region.setVisible(false);
        }else{
            this.Region.setVisible(true);
        }
        if(this.radioSuperfi.isSelected()){
            this.SurfaceArea.setVisible(false);
        }else{
            this.SurfaceArea.setVisible(true);   
        }
        if(this.radioInd.isSelected()){
            this.IndepYear.setVisible(false);
        }else{
            this.IndepYear.setVisible(true);   
        }
        if(this.radioPobla.isSelected()){
            this.Population.setVisible(false);
        }else{
            this.Population.setVisible(true);   
        }
        if(this.radioExp.isSelected()){
            this.LifeExp.setVisible(false);
        }else{
            this.LifeExp.setVisible(true);   
        }
        if(this.radioPIB.isSelected()){
            this.GNP.setVisible(false);
        }else{
            this.GNP.setVisible(true);   
        }
        if(this.radioPIB2.isSelected()){
            this.GNPOld.setVisible(false);
        }else{
            this.GNPOld.setVisible(true);   
        }
        if(this.radioNomLoc.isSelected()){
            this.LocalName.setVisible(false);
        }else{
            this.LocalName.setVisible(true);   
        }
        if(this.radioGov.isSelected()){
            this.GovermentForm.setVisible(false);
        }else{
            this.GovermentForm.setVisible(true);   
        }
        if(this.radioPresi.isSelected()){
            this.HeadOfState.setVisible(false);
        }else{
            this.HeadOfState.setVisible(true);   
        }
        if(this.radioCapi.isSelected()){
            this.Capital.setVisible(false);
        }else{
            this.Capital.setVisible(true);   
        }
        if(this.radioCod2.isSelected()){
            this.Code2.setVisible(false);
        }else{
            this.Code2.setVisible(true);   
        }
        if(this.radioLen.isSelected()){
            this.lengua.setVisible(false);
        }else{
            this.lengua.setVisible(true);   
        }
    }

    private void llenarComboConti() {
        this.comboConti.getItems().add("Seleccionar");
        this.comboConti.getItems().add("Asia");
        this.comboConti.getItems().add("Europa");
        this.comboConti.getItems().add("América del norte");
        this.comboConti.getItems().add("África");
        this.comboConti.getItems().add("Oceanía");
        this.comboConti.getItems().add("Antártica");
        this.comboConti.getItems().add("América del sur");
               this.comboConti.getSelectionModel().select(0);
    }

    private void llenarComboLen() {
        GestionCountry gestion = new GestionCountry();
        Vector<String> lenguajes = gestion.getOfficial();
        for(String idioma : lenguajes){
            this.comboLeng.getItems().add(idioma);
        }
    }

    private void llenarComboGov() {
       crudCountry gestion = new crudCountry();
       ArrayList<String> govs= gestion.comboGobierno();
       for(String gov : govs){
            this.comboGov.getItems().add(gov);
        }
        
    }
    
      
    }
    
