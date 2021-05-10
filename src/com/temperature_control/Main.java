package com.temperature_control;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode;

        try {
            rootNode = loader.load();
        } catch (IOException ioe) {
            // log exception
            return;
        }



        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }
    private MenuBar createMenu() {

        // File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> {
            System.out.println("New Menu Item Clicked");
            // More code....
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Exit");

        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

        // Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        Alert alert  = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("about");

        alert.setContentText("This is a tool to convert Temperature from Fahrenheit to Celcius ans vica-versa");
        alert.show();
    }

    @Override
    public void stop() throws Exception {

        System.out.println("stop"); // Called when application is stopped and is about to shut down
        super.stop();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
