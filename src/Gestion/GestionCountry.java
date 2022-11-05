/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import conection.conection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tablas.City;
import tablas.Country;
import tablas.CountryLanguage;


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
    private Vector<CountryLanguage> idiomas;
    private ResultSetMetaData metaDatos;
    private ResultSet rs;
    private Vector<City> capitales;
  
    
    public ObservableList<Country> llenarTablaPaises() 
    {
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.misCountry = FXCollections.observableArrayList();
        this.idiomas = new Vector();
        this.capitales = new Vector();
        this.getCapitales();
        this.getLenguajes();
        
        
        try
        {
        ResultSet rs= cn.createStatement().executeQuery("Select * from country");
        
        while (rs.next())
        {
          misCountry.add(new Country(rs.getString("Code"),rs.getString("Name"),rs.getString("Continent")
                  ,rs.getString("Region"),rs.getFloat("SurfaceArea"),rs.getInt("IndepYear")
                  ,rs.getInt("Population"),rs.getFloat("LifeExpectancy"),rs.getFloat("GNP")
                  ,rs.getFloat("GNPOld"),rs.getString("LocalName"),rs.getString("GovernmentForm")
                  ,rs.getString("HeadOfState"),this.validarCapital(rs),rs.getString("Code2")
                  ,this.buscarLenguaje(rs)));
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
    private String buscarLenguaje(ResultSet resultado){
        String idioma = "";
        for(CountryLanguage lenguaje : this.idiomas){
            try {
                if(lenguaje.getCountryCode().equals(resultado.getString(1))){
                    
                    if(!idioma.isEmpty()){
                        idioma += ", ";
                    }
                    idioma += lenguaje.getLanguage();
                }
            } catch (SQLException e) {
            System.out.println("Error: " + e);
            }
        }
        return idioma;
    }
    private void getLenguajes(){
        
        CountryLanguage lenguaje;
        try {
            this.st = this.cn.createStatement();
            this.rs = this.st.executeQuery("select code, language from country, countrylanguage where code=countrycode and isofficial='t'");
            this.metaDatos = this.rs.getMetaData();
            while(this.rs.next()){
                lenguaje = new CountryLanguage(this.rs.getString(1), this.rs.getString(2), ' ', 0);
                this.idiomas.add(lenguaje);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    private void getCapitales(){
        City ciudad;
        try {
            this.st = this.cn.createStatement();
            this.rs = this.st.executeQuery("select p.capital, c.name from city as c, country as p where c.ID = p.capital");
            this.metaDatos = this.rs.getMetaData();
            while(this.rs.next()){
                ciudad = new City(Integer.parseInt(this.rs.getString(1)), this.rs.getString(2), "", "", 0, "");
                this.capitales.add(ciudad);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    private String buscarCapital(ResultSet resultado){
        String capital = "";
        for(City ciudad : this.capitales){
            try {
                if(ciudad.getID() == Integer.parseInt(resultado.getString(14)))
                    capital = ciudad.getName();
            } catch (SQLException e) {
            System.out.println("Error: " + e);
            }
        }
        return capital;
    }
    private String validarCapital(ResultSet resultado) throws SQLException{
        String state = "";
        if(resultado.getString(14) == null)
                state = "Sin definir";
            else
                state=(this.buscarCapital(resultado));
        
        return state;
    }
    
    
    
    
}

