/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import conection.conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tablas.Country;

/**
 *
 * @author Natho
 */
public class crudCountry {
    private conection conexion;
    private Connection cn;
    private Statement st;
    private showMessages showMessages;
    private String query;
    private ArrayList<String> combos;
    private ResultSet rs;
    

    public void crearCountry (Country nCountry)
    {
        this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("insert into country (Code,Name,Continent,Region,SurfaceArea,IndepYear,Population,"
                 + "LifeExpectancy,GNP,GNPOld,LocalName,GovernmentForm,HeadOfState,Capital,Code2) "
                 + "values "+"('"+nCountry.getCode()+"','"+nCountry.getName()+"','"+nCountry.getContinent()+"','"
                         + ""+nCountry.getRegion()+"','"+nCountry.getSurfaceArea()+"','"+nCountry.getIndepYear()
                 +"','"+nCountry.getPopulation()+"','"+nCountry.getLifeExpectancy()+"','"+nCountry.getGNP()
                 +"','"+nCountry.getGNPOld()+"','"+nCountry.getLocalName()+"','"+nCountry.getGovernmentForm()
                 +"','"+nCountry.getHeadOfState()+"','"+nCountry.getCapital()+"','"+nCountry.getCode2()+"')");
         System.out.println("Insercción exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "País agregado correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                      mesg = "No se creó el pais, puede que el codigo elegido ya este en la base de datos";
                      this.showMessages.showMessages(mesg, 1);
                      
           }
        
     
    }
    
    
    
    public void eliminarPais(Country Ecountry) 
    {
       this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("delete from country where code='"+Ecountry.getCode()+"'");
         System.out.println("Eliminación exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "País eliminado correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                      mesg = "País no se pudo eliminar";
                      this.showMessages.showMessages(mesg, 1);
           }
        
    }
    
    public void modifyCountry (Country mCountry,String aCountry)
    {
        this.showMessages = new showMessages();
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        String mesg;
        try
        {
         PreparedStatement rc= cn.prepareStatement("update country set name='"+mCountry.getName()+"',continent='"+mCountry.getContinent()
                 +"',region='"+mCountry.getRegion()+"',surfaceArea='"+mCountry.getSurfaceArea()+"',IndepYear='"+mCountry.getIndepYear()
                 +"' ,population='"+mCountry.getPopulation()+"' ,lifeExpectancy='"+mCountry.getLifeExpectancy()
                 +"' ,GNP='"+mCountry.getGNP()+"' ,GNPOld='"+mCountry.getGNPOld()
                 +"' ,localName='"+mCountry.getLocalName()+"' ,governmentForm='"+mCountry.getGovernmentForm()
                 +"' ,headOfState='"+mCountry.getHeadOfState()+"' ,capital='"+mCountry.getCapital()+"'  where Code='"+aCountry+"'");
         System.out.println("Insercción exitosa");
         
         rc.executeUpdate();
         rc.close();
         mesg = "País modificado correctamente";
         this.showMessages.showMessages(mesg, 2);
         
        }
        catch(Exception e)
           {
                     mesg = "País no se pudo modificar";
                    this.showMessages.showMessages(mesg, 1);
           }
        
     
    }
    
    
    
    public ArrayList<String> comboGobierno(){
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.query="";
        this.combos= new ArrayList<>();
        this.query="select GovernmentForm from country group by 1";
              
        try{
            this.st = this.cn.createStatement();
            this.rs= this.st.executeQuery(this.query);
            
            while(rs.next()){
              this.combos.add(rs.getString("GovernmentForm"));  
            }
            
        }catch (SQLException e){
            
        }
        return this.combos;
    }
    
    public String getGov(String codPS){
        String gov ="";
        this.conexion = new conection();
        this.cn = this.conexion.getconection();
        this.query="";
        this.query="select GovernmentForm from country where code = '"+ codPS +"'group by 1";
             
        try{
            this.st = this.cn.createStatement();
            this.rs= this.st.executeQuery(this.query);
            
            while(rs.next()){
              gov=(rs.getString("GovernmentForm"));  
            }
            
        }catch (SQLException e){
            
        }
        return gov;
        
        
    }
}
