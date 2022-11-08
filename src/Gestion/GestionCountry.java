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
  
    
    public ObservableList<Country> llenarTablaPaises(String query) 
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
        ResultSet rs= cn.createStatement().executeQuery(query);
        
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
    public String validarCapital(ResultSet resultado) throws SQLException{
        String state = "";
        if(resultado.getString(14) == null)
                state = "Sin definir";
            else
                state=(this.buscarCapital(resultado));
        
        return state;
    }
     public String getCode2(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String code2 ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select code2 from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                code2=rc.getString("code2");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return code2;
     }
     public String getName(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String name ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select name from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                name=rc.getString("name");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return name;
     }
     
     public String getLocName(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String name ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select localName from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                name=rc.getString("localName");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return name;
     }
     public String getRegion(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String reg ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select region from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                reg=rc.getString("region");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return reg;
     }
     
     public String getContinente(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String cont ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select continent from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                cont=rc.getString("continent");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return cont;
     }
     public String getPobla(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String pobla ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select population from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                pobla=rc.getString("population");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return pobla;
     }
     
     public int getInd(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        int ind = 0;
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select indepYear from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                ind=rc.getInt("indepYear");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return ind;
     }
    
     public int getExp(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        int exp = 0;
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select lifeExpectancy from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                exp=rc.getInt("lifeExpectancy");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return exp;
     }
     
     public String getPresi(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String presi ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select headOfState from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                presi=rc.getString("headOfState");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return presi;
     }
     
     public String getPIB(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String pib ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select GNP from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                pib=rc.getString("GNP");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return pib;
     }
     
     public String getPIB2(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String pib ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select GNPOld from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                pib=rc.getString("GNPOld");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return pib;
     }
     
     public String getSuperfi(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String superfi ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select surfaceArea from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                superfi=rc.getString("surfaceArea");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return superfi;
     }
     
     public String getCapi(String codPais){
         
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String capi ="";
        System.out.println("El código es "+codPais);
        try{
            this.st = this.cn.createStatement();
            ResultSet rc= cn.createStatement().executeQuery("select capital from country where code='"+codPais+"'group by 1");
            System.out.print("Conexion estable");
            while(rc.next())
                {
                capi=rc.getString("capital");
                }
            
           
        }catch (SQLException e)
        {
             System.out.print("Conexion inestable");
        }
         return capi;
     }
     public Vector<String> getOfficial(){
         this.conexion = new conection();
         this.cn = this.conexion.getconection();
         
        Vector<String> oficiales = new Vector();
        try {
            this.st = this.cn.createStatement();
            this.rs = this.st.executeQuery("select language from countrylanguage where isofficial='t' group by 1");
            while(this.rs.next()){
                oficiales.add(this.rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return oficiales;
    }
     
     
     
     
     
     
    
    
    
}

