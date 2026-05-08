package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Formulario ejemplo");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label nombreLabel = new Label("Nombre: ");
        TextField nombreTextField = new TextField();
        grid.add(nombreLabel, 0, 0);
        grid.add(nombreTextField, 1, 0);

        Label emailLabel = new Label("Email: ");
        TextField emailTextField = new TextField();
        grid.add(emailLabel, 0, 1);
        grid.add(emailTextField, 1, 1);

        Label contraseniaLabel = new Label("Contraseña: ");
        PasswordField contraseniaTextField = new PasswordField();
        grid.add(contraseniaLabel, 0, 2);
        grid.add(contraseniaTextField, 1, 2);

        Button enviarButton = new Button("Enviar");
        grid.add(enviarButton, 1, 3);
        enviarButton.setOnAction(e -> {
           String nombre = nombreTextField.getText();
           String email = emailTextField.getText();
           String contrasenia = contraseniaTextField.getText();
           if (nombre.isEmpty() || email.isEmpty() || contrasenia.isEmpty()) {
               Alert alerta = new Alert(Alert.AlertType.ERROR);
               alerta.setTitle("Campos obrigatos");
               alerta.setHeaderText("Hay algun campo sin rellenar");
               alerta.showAndWait();
               return;
           }
           System.out.println("Nombre: " + nombre);
           System.out.println("Email: " + email);
           System.out.println("Contrasenia: " + contrasenia);
        });

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
