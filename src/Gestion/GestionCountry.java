/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import conection.conection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private ArrayList<String> combosPais;
    
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
    
    public ArrayList<String> getCodigosPais() 
    {
     this.conexion = new conection();
     this.cn = this.conexion.getconection();
     this.combosPais= new ArrayList<String>();
      try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select code from country");
            System.out.print("Conexion estable");
        
            while(rc.next())
                {
                this.combosPais.add(rc.getString("code"));   
                }
          }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
        return this.combosPais;
    }
    
    
}

