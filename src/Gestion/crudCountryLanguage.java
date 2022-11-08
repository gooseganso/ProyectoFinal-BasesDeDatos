/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import conection.conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tablas.City;
import tablas.CountryLanguage;

/**
 *
 * @author Usuario
 */
public class crudCountryLanguage 
{
    private conection conexion;
    private Connection cn;
    private Statement st;
    private showMessages showMessages;
    ObservableList<CountryLanguage> misLangOrder = FXCollections.observableArrayList();
    
    
    public void crearLang (CountryLanguage nLang)
    {
        this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("insert into countrylanguage (countrycode,language,isOfficial,percentage) values ('"+nLang.getCountryCode()+"','"+nLang.getLanguage()+"','"+nLang.getIsOfficial()+"','"+nLang.getPercentage()+"')");
         System.out.println("Insercción exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "Lenguaje agregado correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                      mesg=("No se pudo crear el lenguaje, puede que ya esté en la base de datos ");
                       this.showMessages.showMessages(mesg, 1);
           }
    }
    public void eliminarLang(CountryLanguage ELang) 
    {
       this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("delete from countrylanguage where countrycode='"+ELang.getCountryCode()+"' and language='"+ELang.getLanguage()+"'");
         System.out.println("Eliminación exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "lenguaje eliminado correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                      System.err.println("Error: " +e);
           }
        
    }
    public void modifyLang (CountryLanguage mLang,String codp,String lang)
    {
        this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("update countrylanguage set countrycode='"+mLang.getCountryCode()+"',language='"+mLang.getLanguage()+"',isOfficial='"+mLang.getIsOfficial()+"',percentage='"+mLang.getPercentage()+"' where countrycode='"+codp+"' and language='"+lang+"'");
         System.out.println("Insercción exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "Lenguaje modificado correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                      System.err.println("Error: " +e);
           }
        
     
    }
    
    public ObservableList<CountryLanguage> ordenarLang(boolean restrict,String filtro,String order,int limit,String filtroTotal)
    {
      this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.misLangOrder = FXCollections.observableArrayList();
     
      if(restrict)
      {
        try
        {
         
         ResultSet rc= cn.createStatement().executeQuery("Select * from countrylanguage "+filtroTotal+" "+filtro+" "+order+" limit "+limit+" ");
        
         while (rc.next())
         {
          misLangOrder.add(new CountryLanguage(rc.getString("countryCode"),rc.getString("language"),rc.getString("isOfficial").charAt(0),rc.getFloat("percentage")));
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
         
         ResultSet rc= cn.createStatement().executeQuery("Select * from countrylanguage "+filtro+" "+order+" limit "+limit+" ");
        
         while (rc.next())
         {
          misLangOrder.add(new CountryLanguage(rc.getString("countryCode"),rc.getString("language"),rc.getString("isOfficial").charAt(0),rc.getFloat("percentage")));
         }
        }
        catch(Exception e)
                     {
                      System.err.println("Error: " +e);
                     }
      }
      
      return this.misLangOrder;
    
    
    }
}
