/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;
import conection.conection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import tablas.City;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tablas.Country;
/**
 *
 * @author Usuario
 */
public class crudCity 
{
    private conection conexion;
    private Connection cn;
    private Statement st;
    private showMessages showMessages;
    ObservableList<City> misCitiesOrder = FXCollections.observableArrayList();
    private GestionCountry gestion;
    private ObservableList<Country> paises = FXCollections.observableArrayList();
    
    
    public void crearCity (City nCity)
    {
        this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("insert into city (name,countrycode,district,population) values "+"('"+nCity.getName()+"','"+nCity.getCountryCode()+"','"+nCity.getDistrict()+"','"+nCity.getPopulation()+"')");
         System.out.println("Insercción exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "Ciudad agregada correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                      System.err.println("Error: " +e);
           }
        
     
    }
    public void eliminarCiudad(City Ecity) 
    {
       this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("delete from city where ID='"+Ecity.getID()+"'");
         System.out.println("Eliminación exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "Ciudad eliminada correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                      System.err.println("Error: " +e);
           }
        
    }
    public void modifyCity (City mCity,int aCity)
    {
        this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("update city set name='"+mCity.getName()+"',countrycode='"+mCity.getCountryCode()+"',district='"+mCity.getDistrict()+"',population='"+mCity.getPopulation()+"' where ID='"+aCity+"'");
         System.out.println("Insercción exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "Ciudad modificada correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                      System.err.println("Error: " +e);
           }
        
     
    }
    
    public ObservableList<City> ordenarCity(boolean restrict,String filtro,String order,int limit,String filtroTotal)
    {
      this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.misCitiesOrder = FXCollections.observableArrayList();
        this.gestion = new GestionCountry();
        this.paises = this.gestion.misCountry;
     
      if(restrict)
      {
        try
        {
         
         ResultSet rc= cn.createStatement().executeQuery("Select * from city "+filtroTotal+" "+filtro+" "+order+" limit "+limit+" ");
        
         while (rc.next())
         {
          misCitiesOrder.add(new City(rc.getInt("ID"),rc.getString("Name"),rc.getString("CountryCode"),rc.getString("District"),rc.getInt("Population"),this.getPais(rc.getString(3))));
         }
        }
        catch(Exception e)
                     {
                      System.err.println("Error: " +e);
                     }
      }
      else
      {
        try
        {
         
         ResultSet rc= cn.createStatement().executeQuery("Select * from city "+filtro+" "+order+" limit "+limit+" ");
        
         while (rc.next())
         {
          misCitiesOrder.add(new City(rc.getInt("ID"),rc.getString("Name"),rc.getString("CountryCode"),rc.getString("District"),rc.getInt("Population"),this.getPais(rc.getString(3))));
         }
        }
        catch(Exception e)
                     {
                      System.err.println("Error: " +e);
                     }
      }
      
      return this.misCitiesOrder;
    
    
    }
    private String getPais(String code)
    {
        String pais = "";
        for(Country country : this.paises){
            if(country.getCode().equals(code)){
                pais = country.getName();
            }
        }
        return pais;
    }
    
    
   
}
