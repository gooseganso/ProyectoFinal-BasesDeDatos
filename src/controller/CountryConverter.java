/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.util.StringConverter;
import tablas.Country;

/**
 *
 * @author Usuario
 */
public class CountryConverter extends StringConverter<Country> 
{

    @Override
    public String toString(Country object) {
        return object == null ? null : object.getName();
    }

    @Override
    public Country fromString(String string) {
        return null;
    }
    
}
