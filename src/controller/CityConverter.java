/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.util.StringConverter;
import tablas.City;

/**
 *
 * @author Usuario
 */
public class CityConverter extends StringConverter<City> 
{

    @Override
    public String toString(City object) {
        return object == null ? null : object.getName();
    }

    @Override
    public City fromString(String string) {
        return null;
    }
    
}
