/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import conection.conection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import tablas.Country;

/**
 * FXML Controller class
 *
 * @author Eduen
 */
public class CLanguageController implements Initializable {

    @FXML
    private JFXComboBox<?> comboPais;
    @FXML
    private Spinner<Integer> ComboPorcentaje;
    @FXML
    private JFXComboBox<String> ComboOficial;
    private conection conexion;
    private Connection cn;
    private Statement st;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    
    {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        
        ComboPorcentaje.setValueFactory(valueFactory);
      
         valueFactory.setValue(1);
         this.ComboOficial.getItems().add("Sí");
         this.ComboOficial.getItems().add("No");
    }

    
   private void llenarComboPais()
   {
     this.conexion = new conection();
     this.cn = this.conexion.getconection();
     Country c = new Country();
     
        String codeC = c.getCode();
     
      try
        {
        ResultSet rs= cn.createStatement().executeQuery("Select Code from country");
        while (rs.next())
        {
          
        }
        }
      
      catch(Exception e)
                     {
                      System.err.println("Error: " +e);
                     }
   
   }    
    
}
