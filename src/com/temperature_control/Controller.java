package com.temperature_control;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public javafx.scene.control.Label welcomeLable;
    @FXML
    public ChoiceBox<String> selectmode;
    @FXML
    public javafx.scene.control.TextField temperature;
    @FXML
    public Button convert;
    private static final String C_to_F_Text ="Celcius to Fahrenheit";
    private static final String F_to_C_Text ="Fahrenheit to Celcius";
    private boolean isC_to_F=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        selectmode.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue == C_to_F_Text) {
                    isC_to_F=true;} else {isC_to_F=false;}
                System.out.println(isC_to_F);
            }
        });
        selectmode.getItems().add(C_to_F_Text);
        selectmode.getItems().add(F_to_C_Text);
        selectmode.setValue(C_to_F_Text);
        convert.setOnAction(event -> {

            convert();
        });
    }

    private void convert() {

        String value = temperature.getText();
        System.out.println(value);
        float temp = 0.0f;
        try{
        temp = Float.parseFloat(value);}catch (Exception e) {
        warnUser();
            return;
        }

//        System.out.println(temp);
        float convertedTemperature=0.0f;
        if(isC_to_F){
            convertedTemperature=((temp)*(9/5))+32;

        }else{
            convertedTemperature=((temp)-32)*(9/5);
        }
        display(convertedTemperature);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setContentText("Please enter a valid temperature in Number");
        alert.show();

    }

    private void display(float convertedTemperature) {


//        System.out.println("the Temp is " +convertedTemperature + (isC_to_F ?" Fahrenheit":" Celcius"));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("the Temp is " +convertedTemperature + (isC_to_F ?" Fahrenheit":" Celcius"));
        alert.show();
    }

    ;

};
