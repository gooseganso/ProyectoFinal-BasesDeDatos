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
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
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
    @FXML
    private JFXCheckBox checkSuperfi;
    @FXML
    private JFXRadioButton menorigual1;
    @FXML
    private JFXRadioButton mayor1;
    @FXML
    private JFXRadioButton igual1;
    @FXML
    private JFXRadioButton menor1;
    @FXML
    private JFXRadioButton mayorigual1;
    @FXML
    private JFXCheckBox checkPobla;
    @FXML
    private JFXRadioButton menorigual2;
    @FXML
    private JFXRadioButton mayor2;
    @FXML
    private JFXRadioButton igual2;
    @FXML
    private JFXRadioButton menor2;
    @FXML
    private JFXRadioButton mayorigual2;
    @FXML
    private JFXCheckBox checkInd;
    @FXML
    private JFXCheckBox checkExp;
    @FXML
    private JFXRadioButton menorigual3;
    @FXML
    private JFXRadioButton mayor3;
    @FXML
    private JFXRadioButton igual3;
    @FXML
    private JFXRadioButton menor3;
    @FXML
    private JFXRadioButton mayorigual3;
    @FXML
    private JFXRadioButton menorigual4;
    @FXML
    private JFXRadioButton mayor4;
    @FXML
    private JFXRadioButton igual4;
    @FXML
    private JFXRadioButton menor4;
    @FXML
    private JFXRadioButton mayorigual4;
    private String comparador;
    @FXML
    private Spinner<Integer> spinnerArea;
    @FXML
    private Spinner<Integer> spinnerIndep;
    @FXML
    private Spinner<Integer> spinnerPob;
    @FXML
    private Spinner<Integer> spinnerVida;
    @FXML
    private ToggleGroup ascDesc;
    @FXML
    private ToggleGroup area;
    @FXML
    private ToggleGroup pobla;
    @FXML
    private ToggleGroup ind;
    @FXML
    private ToggleGroup exp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.llenar= new GestionCountry();
        this.showMessages = new showMessages();
       SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 250);
       SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 150);
       SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30000000);
       SpinnerValueFactory<Integer> valueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2000000000);
       SpinnerValueFactory<Integer> valueFactory5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(-2000, 2022);
       
       this.spinnerLimit.setValueFactory(valueFactory1);
       this.spinnerVida.setValueFactory(valueFactory2);
       this.spinnerArea.setValueFactory(valueFactory3);
       this.spinnerPob.setValueFactory(valueFactory4);
       this.spinnerIndep.setValueFactory(valueFactory5);
       valueFactory1.setValue(1);
       valueFactory2.setValue(1);
       valueFactory3.setValue(1);
       valueFactory4.setValue(1);
       valueFactory4.setValue(1);
       
       
        
        this.modelaTabla();
        this.llenarComboFil();
        this.radioAscen.selectedProperty().set(true);
        this.llenarComboConti();
        this.llenarComboLen();
        this.llenarComboGov();
        this.comparador="";
        
        
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
      if(this.misCountry.isEmpty()){
          String mesg = "No existen paises con esas caracteristicas";
          this.showMessages.showMessages(mesg, 1);
      } else{
      tableC.setItems(misCountry);}
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
        this.filtrar();
        this.ordenar();
        this.ocultar();
        this.filtrarIdioma();
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
    private void filtrarIdioma(){
        String idioma = this.comboLeng.getSelectionModel().getSelectedItem();
        FilteredList<Country> filtered = new FilteredList<>(this.misCountry, b -> true);
        filtered.setPredicate(Country -> {
        if(idioma.equals("Seleccionar") || idioma.isEmpty()){
            return true;}
        if(Country.getLenguajeOficial().contains(idioma)){
            return true;
        }
            return false;
           
        });
        
        SortedList<Country> sorted = new SortedList<>(filtered);
        sorted.comparatorProperty().bind(this.tableC.comparatorProperty());
        tableC.setItems(sorted);
        
    }
    
    
    private void filtrar(){
        Query q = new Query();
        boolean and = false;
        this.query = "select * from country ";
        String continente = this.comboConti.getSelectionModel().getSelectedItem();
        String gobierno = this.comboGov.getSelectionModel().getSelectedItem();
        if(!continente.equals("Seleccionar") || this.checkSuperfi.isSelected() || this.checkPobla.isSelected() || this.checkInd.isSelected() ||  this.checkExp.isSelected() || !gobierno.equals("Seleccionar"))
            this.query += "where ";
        if(!continente.equals("Seleccionar")){
            this.query += q.whereContinente(continente);
            and = true;
        }
        if(this.checkSuperfi.isSelected()){
            this.query += q.where(this.doComparador(), 1, and, this.spinnerArea.getValue().toString());
            and = true;
        }
        if(this.checkPobla.isSelected()){
            this.query += q.where(this.doComparador(), 2, and, this.spinnerPob.getValue().toString());
            and = true;
        }
        if(this.checkInd.isSelected()){
            this.query += q.where(this.doComparador(), 3, and, this.spinnerIndep.getValue().toString());
            and = true;
        }
        if(this.checkExp.isSelected()){
            this.query += q.where(this.doComparador(), 5, and, this.spinnerVida.getValue().toString());
            and = true;
        }
        if(!gobierno.equals("Seleccionar")){
            if(and)
                this.query += " and ";
            this.query += "governmentform = '" + gobierno + "'";
            and = true;
        }
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
        this.comboLeng.getItems().add("Seleccionar");
        this.comboLeng.getSelectionModel().select("Seleccionar");
    }

    private void llenarComboGov() {
       crudCountry gestion = new crudCountry();
       ArrayList<String> govs= gestion.comboGobierno();
       for(String gov : govs){
            this.comboGov.getItems().add(gov);
        }
       this.comboGov.getItems().add("Seleccionar");
        this.comboGov.getSelectionModel().select("Seleccionar");
       
        
    }

    @FXML
    private void doActivarSuperfi(ActionEvent event) {
        if(this.checkSuperfi.isSelected()){
        this.menorigual1.setSelected(true);
        this.menor1.setDisable(false);
        this.igual1.setDisable(false);
        this.mayor1.setDisable(false);
        this.mayorigual1.setDisable(false);
        this.menorigual1.setDisable(false);
        this.spinnerArea.setDisable(false);
        } else {
        this.menor1.setDisable(true);
        this.menor1.setSelected(false);
        this.igual1.setDisable(true);
        this.igual1.setSelected(false);
        this.mayor1.setDisable(true);
        this.mayor1.setSelected(false);
        this.mayorigual1.setDisable(true);
        this.menorigual1.setSelected(false);
        this.menorigual1.setDisable(true);
        this.menorigual1.setSelected(false);
         this.spinnerArea.setDisable(true);
            
        }
                
       
    }

    @FXML
    private void doMenorigual(ActionEvent event) {
        this.menor1.setSelected(false);
        this.igual1.setSelected(false);
        this.mayor1.setSelected(false);
        this.mayorigual1.setSelected(false);
    }

    @FXML
    private void doMayor(ActionEvent event) {
        this.menor1.setSelected(false);
        this.igual1.setSelected(false);
        this.menorigual1.setSelected(false);
        this.mayorigual1.setSelected(false);
    }

    @FXML
    private void doIgual(ActionEvent event) {
        this.menor1.setSelected(false);
        this.menorigual1.setSelected(false);
        this.mayor1.setSelected(false);
        this.mayorigual1.setSelected(false);
    }

    @FXML
    private void doMenor(ActionEvent event) {
        this.menorigual1.setSelected(false);
        this.igual1.setSelected(false);
        this.mayor1.setSelected(false);
        this.mayorigual1.setSelected(false);
    }

    @FXML
    private void doMayorIgual(ActionEvent event) {
        this.menor1.setSelected(false);
        this.igual1.setSelected(false);
        this.mayor1.setSelected(false);
        this.menorigual1.setSelected(false);
    }

    @FXML
    private void doActivarPobla(ActionEvent event) {
        if(this.checkPobla.isSelected()){
        this.menorigual2.setSelected(true);
        this.menor2.setDisable(false);
        this.igual2.setDisable(false);
        this.mayor2.setDisable(false);
        this.mayorigual2.setDisable(false);
        this.menorigual2.setDisable(false);
         this.spinnerPob.setDisable(false);
        } else {
       this.menor2.setDisable(true);
        this.menor2.setSelected(false);
        this.igual2.setDisable(true);
        this.igual2.setSelected(false);
        this.mayor2.setDisable(true);
        this.mayor2.setSelected(false);
        this.mayorigual2.setDisable(true);
        this.menorigual2.setSelected(false);
        this.menorigual2.setDisable(true);
        this.menorigual2.setSelected(false);
         this.spinnerPob.setDisable(true);
            
        }
        
    }

    @FXML
    private void doActivarInd(ActionEvent event) {
        if(this.checkInd.isSelected()){
         this.menorigual3.setSelected(true);
        this.menor3.setDisable(false);
        this.igual3.setDisable(false);
        this.mayor3.setDisable(false);
        this.mayorigual3.setDisable(false);
        this.menorigual3.setDisable(false);
         this.spinnerIndep.setDisable(false);
        } else {
       this.menor3.setDisable(true);
        this.menor3.setSelected(false);
        this.igual3.setDisable(true);
        this.igual3.setSelected(false);
        this.mayor3.setDisable(true);
        this.mayor3.setSelected(false);
        this.mayorigual3.setDisable(true);
        this.menorigual3.setSelected(false);
        this.menorigual3.setDisable(true);
        this.menorigual3.setSelected(false);
        this.spinnerIndep.setDisable(true);
            
        }
    }

    @FXML
    private void doActivarExp(ActionEvent event) {
        if(this.checkExp.isSelected()){
        this.menorigual4.setSelected(true);
        this.menor4.setDisable(false);
        this.igual4.setDisable(false);
        this.mayor4.setDisable(false);
        this.mayorigual4.setDisable(false);
        this.menorigual4.setDisable(false);
         this.spinnerVida.setDisable(false);
        } else {
        this.menor4.setDisable(true);
        this.menor4.setSelected(false);
        this.igual4.setDisable(true);
        this.igual4.setSelected(false);
        this.mayor4.setDisable(true);
        this.mayor4.setSelected(false);
        this.mayorigual4.setDisable(true);
        this.menorigual4.setSelected(false);
        this.menorigual4.setDisable(true);
        this.menorigual4.setSelected(false);
         this.spinnerVida.setDisable(true);
        
            
        }
    }

    @FXML
    private void doMenorigual1(ActionEvent event) {
        this.menor2.setSelected(false);
        this.igual2.setSelected(false);
        this.mayor2.setSelected(false);
        this.mayorigual2.setSelected(false);
    }

    @FXML
    private void doMayor1(ActionEvent event) {
        this.menor2.setSelected(false);
        this.igual2.setSelected(false);
        this.menorigual2.setSelected(false);
        this.mayorigual2.setSelected(false);
    }

    @FXML
    private void doIgual1(ActionEvent event) {
        this.menor2.setSelected(false);
        this.menorigual2.setSelected(false);
        this.mayor2.setSelected(false);
        this.mayorigual2.setSelected(false);
    }

    @FXML
    private void doMenor1(ActionEvent event) {
        this.menorigual2.setSelected(false);
        this.igual2.setSelected(false);
        this.mayor2.setSelected(false);
        this.mayorigual2.setSelected(false);
    }

    @FXML
    private void doMayorIgual1(ActionEvent event) {
        this.menor2.setSelected(false);
        this.igual2.setSelected(false);
        this.mayor2.setSelected(false);
        this.menorigual2.setSelected(false);

    }

    @FXML
    private void doMenorigual2(ActionEvent event) {
        this.menor3.setSelected(false);
        this.igual3.setSelected(false);
        this.mayor3.setSelected(false);
        this.mayorigual3.setSelected(false);
    }

    @FXML
    private void doMayor2(ActionEvent event) {
        this.menor3.setSelected(false);
        this.igual3.setSelected(false);
        this.menorigual3.setSelected(false);
        this.mayorigual3.setSelected(false);
    }

    @FXML
    private void doIgual2(ActionEvent event) {
        this.menor3.setSelected(false);
        this.menorigual3.setSelected(false);
        this.mayor3.setSelected(false);
        this.mayorigual3.setSelected(false);
    }

    @FXML
    private void doMenor2(ActionEvent event) {
        this.menorigual3.setSelected(false);
        this.igual3.setSelected(false);
        this.mayor3.setSelected(false);
        this.mayorigual3.setSelected(false);
    }

    @FXML
    private void doMayorIgual2(ActionEvent event) {
        this.menor3.setSelected(false);
        this.igual3.setSelected(false);
        this.mayor3.setSelected(false);
        this.menorigual3.setSelected(false);
    }

    @FXML
    private void doMenorigual3(ActionEvent event) {
        this.menor4.setSelected(false);
        this.igual4.setSelected(false);
        this.mayor4.setSelected(false);
        this.mayorigual4.setSelected(false);
    }

    @FXML
    private void doMayor3(ActionEvent event) {
        this.menor4.setSelected(false);
        this.igual4.setSelected(false);
        this.menorigual4.setSelected(false);
        this.mayorigual4.setSelected(false);
    }

    @FXML
    private void doIgual3(ActionEvent event) {
        this.menor4.setSelected(false);
        this.menorigual4.setSelected(false);
        this.mayor4.setSelected(false);
        this.mayorigual4.setSelected(false);
    }

    @FXML
    private void doMenor3(ActionEvent event) {
        this.menorigual4.setSelected(false);
        this.igual4.setSelected(false);
        this.mayor4.setSelected(false);
        this.mayorigual4.setSelected(false);
    }

    @FXML
    private void doMayorIgual3(ActionEvent event) {
        this.menor4.setSelected(false);
        this.igual4.setSelected(false);
        this.mayor4.setSelected(false);
        this.menorigual4.setSelected(false);
    }
    
        private String doComparador()
    {
      if(this.menorigual1.isSelected() || this.menorigual2.isSelected() || this.menorigual3.isSelected() || this.menorigual4.isSelected() )
      {
        this.comparador="<=";
      }
      else if(this.menor1.isSelected() || this.menor2.isSelected() || this.menor3.isSelected() || this.menor4.isSelected())
      {
       this.comparador="<";
      }
      else if(this.igual1.isSelected() || this.igual2.isSelected() || this.igual3.isSelected() || this.igual4.isSelected())
      {
        this.comparador="=";
      }
      else if(this.mayor1.isSelected() || this.mayor2.isSelected() || this.mayor3.isSelected() || this.mayor4.isSelected())
      {
       this.comparador=">";
      }
      else if(this.mayorigual1.isSelected() || this.mayorigual2.isSelected() || this.mayorigual3.isSelected() || this.mayorigual4.isSelected())
      {
       this.comparador=">=";
      }
      
      return this.comparador;
      
    }
    
      
    }
    
