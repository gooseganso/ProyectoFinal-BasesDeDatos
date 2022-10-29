/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package proyectofinal.basesdedatos;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Natho
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXButton btnLindo;
    @FXML
    private AnchorPane language_tab;
    @FXML
    private AnchorPane top_bar;
    @FXML
    private AnchorPane city_tab;
    @FXML
    private AnchorPane country_tab;
    @FXML
    private AnchorPane table_tab;
    @FXML
    private ImageView lang;
    @FXML
    private ImageView country;
    @FXML
    private ImageView city;
    @FXML
    private ImageView table;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void doHola(ActionEvent event) {
        System.out.println("Prueba de texto");
    }

    @FXML
    private void doTab(MouseEvent event) {
        
        
        if(event.getTarget()== lang)
        {
            language_tab.setVisible(true);
            country_tab.setVisible(false);
            table_tab.setVisible(false);
            city_tab.setVisible(false);
        }
        else
        {
          if(event.getTarget()== country)
          {
            language_tab.setVisible(false);
            country_tab.setVisible(true);
            table_tab.setVisible(false);
            city_tab.setVisible(false);
          }
          else
          {
            if(event.getTarget()== city)
            {
             language_tab.setVisible(false);
             country_tab.setVisible(false);
             table_tab.setVisible(false);
             city_tab.setVisible(true);
            }
            else
            {
             if(event.getTarget()== table)
             {
              language_tab.setVisible(false);
             country_tab.setVisible(false);
             table_tab.setVisible(true);
             city_tab.setVisible(false);
             }
            }
          }
        }
    }
    
}
