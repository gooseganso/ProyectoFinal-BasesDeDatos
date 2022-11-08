/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import conection.conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
                      System.err.println("Error: " +e);
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
}
