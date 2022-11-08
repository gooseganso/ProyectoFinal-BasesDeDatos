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
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import tablas.CountryLanguage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MLanguageController implements Initializable {

    @FXML
    private JFXComboBox<String> comboPais;
    @FXML
    private Spinner<Double> ComboPorcentaje;
    @FXML
    private JFXComboBox<String> ComboOficial;
    @FXML
    private JFXComboBox<String> comboPais1;
    private GestionCountry codp;
    private GestionCountry llenar;
    private ArrayList<String> combosPais;
    @FXML
    private JFXComboBox<CountryLanguage> comboLang1;
    ObservableList<CountryLanguage> combosLanguages;
    private GestionLanguage llenarL;
    @FXML
    private TextField textLanguage;
    @FXML
    private JFXButton btnModify;
    private showMessages showMessages;
    private crudCountryLanguage ModifyL;
    private CountryLanguage mLang;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
         this.llenar= new GestionCountry();
         this.showMessages = new showMessages();
         this.codp= new GestionCountry();
         this.llenarL= new GestionLanguage();
         this.combosPais= this.codp.getCodigosPais();
         SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100,0.5);
        
         ComboPorcentaje.setValueFactory(valueFactory);
      
         valueFactory.setValue(0.0);
         this.ComboOficial.getItems().add("Sí");
         this.ComboOficial.getItems().add("No");
         
         this.llenarComboPais();
    }    
    
    private void llenarComboPais()
   {
      this.comboPais1.getItems().addAll(combosPais);   
   }

    @FXML
    private void doLlenar(ActionEvent event) 
    {
        String codigoPS= this.comboPais1.getSelectionModel().getSelectedItem();
        this.comboLang1.setDisable(false);
        this.comboLang1.getItems().clear();
        this.combosLanguages= this.llenarL.nomLanguages(codigoPS);
        this.comboPais.getItems().clear();
        this.textLanguage.setText("");
        this.comboLang1.getItems().addAll(this.combosLanguages);
        this.comboLang1.setConverter(new LangConverter());
        
        
    }

    @FXML
    private void doLlenarLang(ActionEvent event) 
    {
        try
        {
            String codigoP= this.comboPais1.getSelectionModel().getSelectedItem();
         String Lang= this.comboLang1.getSelectionModel().getSelectedItem().getLanguage();
         String oficial;
         double percen;
         float percen1;
         
         this.comboPais.setDisable(false);
         this.comboPais.getItems().clear();
         this.comboPais.getItems().addAll(this.combosPais);
         this.comboPais.setValue(codigoP);
         
         
         this.textLanguage.setEditable(true);
         this.textLanguage.setText(Lang);
        
         if(this.comboLang1.getSelectionModel().getSelectedItem().getIsOfficial()=='T')
         {
           oficial="Sí";
         }
         else
         {
           oficial="No";
         }
         this.ComboOficial.setDisable(false);
         this.ComboOficial.setValue(oficial);
         
         percen1= this.comboLang1.getSelectionModel().getSelectedItem().getPercentage();
         percen= (double)percen1;
         SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100,0.5);
         this.ComboPorcentaje.setValueFactory(valueFactory);
         valueFactory.setValue(percen);
         this.ComboPorcentaje.setDisable(false);
        }
        catch (Exception e)
        {
             System.out.print("Error");
        }
         
         
    }

    @FXML
    private void doModify(ActionEvent event) 
    {
       String pais,language,mesg;
       char oficial;
       float porcentaje;
       double porcen;
       
       if(this.comboPais.getSelectionModel().getSelectedItem()==null||this.textLanguage.getText().isEmpty()||this.ComboOficial.getSelectionModel().getSelectedItem()==null)
       {
          mesg = "Los campos deben estar llenos";
          this.showMessages.showMessages(mesg, 1);
       }
       else
       {
          if(this.textLanguage.getText().length()>30)
            {
               mesg = "El nombre excede el número de carácteres permitidos";
               this.showMessages.showMessages(mesg, 1);
            
            }
            else
            {
                try 
                   {
                        
                        pais= this.comboPais.getSelectionModel().getSelectedItem();
                        language= this.textLanguage.getText();
                        if(this.ComboOficial.getSelectionModel().getSelectedItem().equals("Sí"))
                        {
                          oficial='T';
                        }
                        else
                        {
                          oficial='F';
                        }
                        porcen= this.ComboPorcentaje.getValue();
                        porcentaje= (float)porcen;
                        this.ModifyL= new crudCountryLanguage();
        
        
                        this.mLang= new CountryLanguage(pais,language,oficial,porcentaje);
        
                        this.ModifyL.modifyLang(mLang,this.comboPais1.getSelectionModel().getSelectedItem(),this.comboLang1.getSelectionModel().getSelectedItem().getLanguage());
                    }
                catch (NumberFormatException nfe) 
                    {

                        mesg = "Tipo de datos inccorrecto";
                        this.showMessages.showMessages(mesg, 1);

                    }
            }
            
       }
        
    }
}
