/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.util.StringConverter;
import tablas.CountryLanguage;

/**
 *
 * @author Usuario
 */
public class LangConverter extends StringConverter<CountryLanguage> 
{

    @Override
    public String toString(CountryLanguage object) {
        return object == null ? null : object.getLanguage();
    }

    @Override
    public CountryLanguage fromString(String string) {
         return null;
    }
    
}
