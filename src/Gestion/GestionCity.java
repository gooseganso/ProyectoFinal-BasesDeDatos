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
import tablas.City;

/**
 *
 * @author Eduen
 */
public class GestionCity {
    
    private conection conexion;
    private Connection cn;
    private Statement st;
    ObservableList<City> misCities = FXCollections.observableArrayList();
    private ArrayList<String> combosDistrito;
    private String query;
    
    
    public ObservableList<City> llenarTablaCity() 
    {
      
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.misCities = FXCollections.observableArrayList();
        
      try
        {
        ResultSet rc= cn.createStatement().executeQuery("Select * from city");
        
        while (rc.next())
        {
          misCities.add(new City(rc.getInt("ID"),rc.getString("Name"),rc.getString("CountryCode"),rc.getString("District"),rc.getInt("Population")));
        }
        }
        catch(Exception e)
                     {
                      System.err.println("Error: " +e);
                     }
      return this.misCities;
    }
    
    public ArrayList<String> codigoDistritos(String codigoPS)
    {
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.combosDistrito= new ArrayList<String>();
        System.out.println("El código es "+codigoPS);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select district from city where countrycode='"+codigoPS+"'group by District");
            System.out.print("Conexion estable");
        
            while(rc.next())
                {
                this.combosDistrito.add(rc.getString("district"));   
                }
            
           
        System.out.println(this.combosDistrito);
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
        return this.combosDistrito;
    }
    
    
}
