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
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tablas.City;
import tablas.Country;

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
    private ArrayList<String> combosCiudad;
    private String query;
    private GestionCountry gestion;
    private ObservableList<Country> paises = FXCollections.observableArrayList();
    
    public ObservableList<City> llenarTablaCity() 
    {
      
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.misCities = FXCollections.observableArrayList();
        this.gestion = new GestionCountry();
        this.paises = this.gestion.misCountry;
        
      try
        {
        ResultSet rc= cn.createStatement().executeQuery("Select * from city");
        
        while (rc.next())
        {
          misCities.add(new City(rc.getInt("ID"),rc.getString("Name"),rc.getString("CountryCode"),rc.getString("District"),rc.getInt("Population"),this.getPais(rc.getString(3))));
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
    
    
    public ArrayList<String> nomCiudades(String codigoPS)
    {
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.combosCiudad= new ArrayList<String>();
        System.out.println("El código es "+codigoPS);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select name from city where countrycode='"+codigoPS+"'group by name");
            System.out.print("Conexion estable");
        
            while(rc.next())
                {
                this.combosCiudad.add(rc.getString("name"));   
                }
            
           
        System.out.println(this.combosCiudad);
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
        return this.combosCiudad;
    }
    public String getDistrict (String nomCiudad){
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String distrito = "";
        System.out.println("El código es "+nomCiudad);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select district from city where name='"+nomCiudad+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                distrito=rc.getString("district");
                System.out.println("El código es " + distrito);
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
        return distrito;
    }
        
        
       public String getPobla (String nomCiudad){
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String poblacion = "";
        System.out.println("El código es "+nomCiudad);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select population from city where name='"+nomCiudad+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                poblacion=rc.getString("population");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
        return poblacion;
        
        
        
    }
    
     private String getPais(String code){
        String pais = "";
        for(Country country : this.paises){
            if(country.getCode().equals(code)){
                pais = country.getName();
            }
        }
        return pais;
    }
    
    
}
