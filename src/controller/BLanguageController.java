/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Gestion.GestionCountry;
import Gestion.GestionLanguage;
import Gestion.crudCountryLanguage;
import Gestion.showMessages;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    @FXML
    private JFXRadioButton radioAscen;
    @FXML
    private JFXRadioButton radioDescen;
    @FXML
    private Spinner<Integer> spinnerLimit;
    @FXML
    private JFXComboBox<String> comboFiltro;
    @FXML
    private JFXCheckBox checkPercen;
    @FXML
    private JFXCheckBox checkPais;
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
    private JFXComboBox<String> comboOficial;
    @FXML
    private JFXButton btnFiltro;
    @FXML
    private TextField percentage;
    @FXML
    private JFXCheckBox checkOficial;
    private GestionCountry codp;
    private ArrayList<String> combosPais;
    private String comparador;
    private crudCountryLanguage filtrar;
    private showMessages showMessages;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.llenar= new GestionLanguage();
        this.codp= new GestionCountry();
        this.comparador="";
        this.misLanguages = this.llenar.llenarTablaLanguage();SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000);
        this.spinnerLimit.setValueFactory(valueFactory);
        this.combosPais= this.codp.getCodigosPais();
        valueFactory.setValue(1);
        this.comboOficial.getItems().add("Sí");
        this.comboOficial.getItems().add("No");
        this.comboFiltro();
        this.modelaTabla();
        this.showMessages = new showMessages();
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
     private void llenarComboPais()
    {
      this.comboPais.getItems().addAll(this.combosPais);
    }
    
    
    public void llenarTablaPaises() 
    {
      tableLang.setItems(misLanguages);
    }
     private void comboFiltro()
    {
      this.comboFiltro.getItems().add("País");
      this.comboFiltro.getItems().add("Lenguaje");
      this.comboFiltro.getItems().add("Porcentaje");
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
    private void doFiltrarpercen(ActionEvent event) 
    {
        this.percentage.setEditable(true);
         this.percentage.setDisable(false);
        this.mayor.setSelected(false);
        this.mayorigual.setSelected(false);
        this.igual.setSelected(false);
        this.menorigual.setSelected(false);
        this.menor.setSelected(false);
        
        if(this.checkPercen.isSelected())
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
          this.percentage.setDisable(true);
        }
    }

    @FXML
    private void dofiltrarPais(ActionEvent event) 
    {
          if(this.checkPais.isSelected())
        {
         this.comboPais.setDisable(false);
         this.llenarComboPais();
        }
        else
        {
          this.comboPais.setDisable(true);
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


    @FXML
    private void doFiltrar(ActionEvent event) 
    {
        this.filtrar= new crudCountryLanguage();
        String filtro,order=" ",filtroSend="",filtroPopul="",filtroPais="",filtroOficial="",pais=this.comboPais.getSelectionModel().getSelectedItem(),filtrototal="",comparar,mesg ;
        int limit;
        float percentage;
        char oficial='0';
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
                case "País" -> filtroSend="order by countrycode";
                case "Lenguaje" -> filtroSend="order by language";
                case "Porcentaje" -> filtroSend="order by percentage";
                default -> {
                } 
         
            }
          }
          else
          {
            validador=false;
          }
          
        }
        if(this.checkPais.isSelected()|| this.checkPercen.isSelected()|| this.checkOficial.isSelected())
              {
            restrict=true;
            if(this.checkPais.isSelected())
                {
                filtroPais="where countrycode='"+pais+"' ";
                }

            if(this.checkPercen.isSelected())
                {
                 percentage=Float.parseFloat(this.percentage.getText()); 
                 if(this.mayor.isSelected()||this.mayorigual.isSelected()||this.menor.isSelected()||this.menorigual.isSelected()||this.igual.isSelected())
                    {
                 if(this.checkPais.isSelected())
                        {
                    filtroPopul=" and percentage "+comparar+percentage+" ";
                        }
                 else
                        {
                    filtroPopul=" where percentage "+comparar+percentage+" ";
                        }
                    }
                 else
                        {
                    validador=false;
                        } 
                }

            if(this.checkOficial.isSelected())
                {
                    if(this.comboOficial.getSelectionModel().getSelectedItem().equals("Sí"))
                        {
                            oficial='T';
                        }
                    else
                        {
                            oficial='F';
                        }
                   if(this.checkPais.isSelected()||this.checkPercen.isSelected())
                        {
                            filtroOficial=" and isOfficial='"+oficial+"'";
                        }
                   else
                        {
                            filtroOficial=" where isOfficial='"+oficial+"'";
                        }
                    
                }
                    filtrototal=filtroPais+filtroPopul+filtroOficial;
        }
        
        if(validador)
        {
           this.misLanguages= this.filtrar.ordenarLang(restrict,filtroSend, order, limit,filtrototal);
        
            if(this.misLanguages.isEmpty())
             {
               mesg = "No hay ningun lenguaje con estas especificaiones";
               this.showMessages.showMessages(mesg, 2);
            }
            else
             {
              this.llenarTablaPaises();
              this.tableLang.refresh();
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
    private void doFiltrarOficial(ActionEvent event) 
    {
          if(this.checkOficial.isSelected())
        {
          this.comboOficial.setDisable(false);
        }
        else
        {
         this.comboOficial.setDisable(true);
        }
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
      
   
}

