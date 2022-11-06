/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import conection.conection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tablas.CountryLanguage;

/**
 *
 * @author Usuario
 */
public class GestionLanguage {
    
    private conection conexion;
    private Connection cn;
    private Statement st;
    ObservableList<CountryLanguage> misLanguages = FXCollections.observableArrayList();
    private GestionCountry gestion;
    
     public ObservableList<CountryLanguage> llenarTablaLanguage() 
    {
      
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.misLanguages = FXCollections.observableArrayList();
        this.gestion = new GestionCountry();
        
      try
        {
        ResultSet rc= cn.createStatement().executeQuery("Select * from countrylanguage");
        
        while (rc.next())
        {
          misLanguages.add(new CountryLanguage(rc.getString("CountryCode"),rc.getString("language"),rc.getString("IsOfficial").charAt(0),rc.getFloat("percentage")));
        }
        }
        catch(Exception e)
                     {
                      System.err.println("Error: " +e);
                     }
      return this.misLanguages;
    }
     
     
    
}
