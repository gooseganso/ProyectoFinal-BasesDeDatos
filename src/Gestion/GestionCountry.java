/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import conection.conection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tablas.Country;

/**
 *
 * @author Eduen
 */
public class GestionCountry 
{
    private conection conexion;
    private Connection cn;
    private Statement st;
    ObservableList<Country> misCountry = FXCollections.observableArrayList();
    
    public ObservableList<Country> llenarTablaPaises() 
    {
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.misCountry = FXCollections.observableArrayList();
        
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
    
       return this.misCountry;
    }
     public ArrayList getPaisCode() 
    
     {
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.misCountry = FXCollections.observableArrayList();
        String registro=null;
        ArrayList<String> CodePais= new ArrayList<String>();
        
        try
        {
          ResultSet rs= cn.createStatement().executeQuery("Select * from country");
          while (rs.next())
            {
          String[] campos = registro.split("_");
          CodePais.add(campos[1]);
            }
        }
        
        catch (Exception e) 
        {
            System.out.println("Falló buscando la base datos");
        }
        
        return CodePais;
     }
    
}

