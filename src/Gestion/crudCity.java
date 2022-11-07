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
/**
 *
 * @author Usuario
 */
public class crudCity 
{
    private conection conexion;
    private Connection cn;
    private Statement st;
    
    public void crearCity (City nCity)
    {
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        
        try
        {
         PreparedStatement rc= cn.prepareStatement("insert into city (name,countrycode,district,population) values "+"('"+nCity.getName()+"','"+nCity.getCountryCode()+"','"+nCity.getDistrict()+"','"+nCity.getPopulation()+"')");
         System.out.println("Insercción exitosa");
         
         rc.executeUpdate();
         rc.close();
        }
        catch(Exception e)
           {
                      System.err.println("Error: " +e);
           }
        
     
    }
}
