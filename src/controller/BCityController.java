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
import Gestion.GestionCountry;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import Gestion.crudCity;
import Gestion.showMessages;
import javafx.scene.control.TextField;

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
    private JFXComboBox<String> comboPais;
    @FXML
    private JFXComboBox<String> comboDistrito;
    @FXML
    private JFXComboBox<String> comboFiltro;
    @FXML
    private Spinner<Integer> spinnerLimit;
    @FXML
    private JFXButton btnFiltro;
    
    private crudCity filtrar;
    private GestionCountry codp;
    private ArrayList<String> combosPais;
    private String comparador;
    private ArrayList<String> combosDistrito;
    private GestionCity district;
    private showMessages showMessages;
    @FXML
    private TextField population;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       this.llenar= new GestionCity();
       this.comparador="";
       this.misCities=this.llenar.llenarTablaCity();
       this.codp= new GestionCountry();
       this.combosPais= this.codp.getCodigosPais();
       SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000);
       this.spinnerLimit.setValueFactory(valueFactory);
       valueFactory.setValue(1);
       this.comboFiltro();
       this.modelaTabla();
       this.showMessages = new showMessages();
    }
    public void constructorNuevo(ArrayList<Country> caso) 
    {
        this.tableCity.getItems().clear();
        
        this.modelaTabla();

    }
    private void llenarComboPais()
    {
     this.comboPais.getItems().addAll(this.combosPais);
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
        this.population.setEditable(true);
         this.population.setDisable(false);
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
          this.population.setDisable(true);
        }
        
    }

    @FXML
    private void dofiltrarPais(ActionEvent event) 
    {
        if(this.checkPais.isSelected())
        {
         this.comboPais.setDisable(false);
         this.llenarComboPais();
         this.checkDistrict.setDisable(false);
        }
        else
        {
          this.comboPais.setDisable(true);
        }
        
    }

    @FXML
    private void doFiltrarDistrict(ActionEvent event) 
    {
        if(this.checkDistrict.isSelected())
        {
          this.comboDistrito.setDisable(false);
        }
        else
        {
         this.comboDistrito.setDisable(true);
        }
        
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
    private String doComparador()
    {
      if(this.menorigual.isSelected())
      {
        this.comparador="<=";
      }
      else if(this.menor.isSelected())
      {
       this.comparador="<";
      }
      else if(this.igual.isSelected())
      {
        this.comparador="=";
      }
      else if(this.mayor.isSelected())
      {
       this.comparador=">";
      }
      else if(this.mayorigual.isSelected())
      {
       this.comparador=">=";
      }
      
      return this.comparador;
      
    }
    @FXML
    private void doFiltrar(ActionEvent event) 
    {
      this.filtrar= new crudCity();
      String filtro,order=" ",filtroSend="",filtroPopul="",filtroPais="",filtroDistric="",pais=this.comboPais.getSelectionModel().getSelectedItem(),filtrototal="",comparar,distrito=this.comboDistrito.getSelectionModel().getSelectedItem(),mesg ;
      int limit,population;
      boolean restrict=false,validador=true;
      
      try
      {
        
        comparar=this.doComparador();
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
          else
          {
            order=" ";
          }
              
        }
        if(null==filtro)
        {
            filtroSend="";
        }
        else
        {
          if(this.radioAscen.isSelected()||this.radioDescen.isSelected())
          {
            switch (filtro) 
           {
            case "ID" -> filtroSend="order by ID";
            case "Nombre" -> filtroSend="order by name";
            case "País" -> filtroSend="order by countrycode";
            case "Distrito" -> filtroSend="order by district";
            case "Población" -> filtroSend="order by population";
            default -> {
            } 
         
           }
          }
          else
          {
            validador=false;
          }
          
        }
        if(this.checkPais.isSelected()|| this.checkPobla.isSelected()|| this.checkDistrict.isSelected())
        {
            restrict=true;
            if(this.checkPais.isSelected())
                {
                filtroPais="where countrycode='"+pais+"' ";
                }

            if(this.checkPobla.isSelected())
                {
                 population=Integer.parseInt(this.population.getText()); 
                 if(this.mayor.isSelected()||this.mayorigual.isSelected()||this.menor.isSelected()||this.menorigual.isSelected()||this.igual.isSelected())
                    {
                 if(this.checkPais.isSelected())
                        {
                    filtroPopul=" and population "+comparar+population+" ";
                        }
                 else
                        {
                    filtroPopul=" where population "+comparar+population+" ";
                        }
                    }
                 else
                        {
                    validador=false;
                        } 
                }

            if(this.checkDistrict.isSelected())
                {
                    filtroDistric=" and district='"+distrito+"'";
                }
                    filtrototal=filtroPais+filtroPopul+filtroDistric;
        }
        
        if(validador)
        {
            this.misCities= this.filtrar.ordenarCity(restrict,filtroSend, order, limit,filtrototal);
        
            if(this.misCities.isEmpty())
             {
                mesg = "No hay ninguna ciudad con estas especificaiones";
                this.showMessages.showMessages(mesg, 2);
             }
            else
             {
              this.llenarTablaCities();
              this.tableCity.refresh();
             }  
           
        }
        else
        {
            mesg = "Debe seleccionar todos los parámetros requeridos";
            this.showMessages.showMessages(mesg, 1);
        }
        
      }catch (NumberFormatException nfe) 
                    {

                        mesg = "Tipo de datos inccorrecto";
                        this.showMessages.showMessages(mesg, 1);

                    }
          
    }

    @FXML
    private void doFiltrarDistri(ActionEvent event) 
    {
        String codigoPS= this.comboPais.getSelectionModel().getSelectedItem();
                
        this.district= new GestionCity();
        this.combosDistrito= this.district.codigoDistritos(codigoPS);
        this.comboDistrito.getItems().addAll(this.combosDistrito);
    }
    
}
