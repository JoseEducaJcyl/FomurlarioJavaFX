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
        // Se asigna el título de la ventana principal
        stage.setTitle("Formulario ejemplo");

        // Se crea un panel de cuadrícula (GridPane) para organizar los elementos en filas y columnas
        GridPane grid = new GridPane();
        // Se establece el espacio horizontal entre columnas: 10 píxeles
        grid.setHgap(10);
        // Se establece el espacio vertical entre filas: 10 píxeles
        grid.setVgap(10);

        // Se crea una etiqueta "Nombre: " para el campo de texto
        Label nombreLabel = new Label("Nombre: ");
        // Se crea un campo de texto donde el usuario ingresará su nombre
        TextField nombreTextField = new TextField();
        // Se añade la etiqueta en la columna 0, fila 0
        grid.add(nombreLabel, 0, 0);
        // Se añade el campo de texto en la columna 1, fila 0
        grid.add(nombreTextField, 1, 0);

        // Se crea una etiqueta "Email: " para el campo de email
        Label emailLabel = new Label("Email: ");
        // Se crea un campo de texto para ingresar el email
        TextField emailTextField = new TextField();
        // Se añade la etiqueta en la columna 0, fila 1
        grid.add(emailLabel, 0, 1);
        // Se añade el campo de email en la columna 1, fila 1
        grid.add(emailTextField, 1, 1);

        // Se crea una etiqueta "Contraseña: " para el campo de contraseña
        Label contraseniaLabel = new Label("Contraseña: ");
        // Se crea un campo PasswordField (oculta los caracteres mientras se escribe)
        PasswordField contraseniaTextField = new PasswordField();
        // Se añade la etiqueta en la columna 0, fila 2
        grid.add(contraseniaLabel, 0, 2);
        // Se añade el campo de contraseña en la columna 1, fila 2
        grid.add(contraseniaTextField, 1, 2);

        // Se crea un botón "Enviar" para enviar el formulario
        Button enviarButton = new Button("Enviar");
        // Se añade el botón en la columna 1, fila 3
        grid.add(enviarButton, 1, 3);

        // Se asigna una acción al botón cuando es presionado
        enviarButton.setOnAction(e -> {
            // Se obtiene el texto ingresado en el campo nombre
            String nombre = nombreTextField.getText();
            // Se obtiene el texto ingresado en el campo email
            String email = emailTextField.getText();
            // Se obtiene la contraseña ingresada (aunque se muestra como puntos/barras)
            String contrasenia = contraseniaTextField.getText();

            // Se verifica si algún campo está vacío
            if (nombre.isEmpty() || email.isEmpty() || contrasenia.isEmpty()) {
                // Se crea una alerta de tipo ERROR
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                // Se establece el título de la ventana de alerta
                alerta.setTitle("Campos obligatos");
                // Se establece el texto del encabezado de la alerta
                alerta.setHeaderText("Hay algun campo sin rellenar");
                // Se muestra la alerta y se espera a que el usuario la cierre
                alerta.showAndWait();
                return; // Se sale del evento sin procesar los datos
            }
            // Si todos los campos están llenos, se imprimen en consola
            System.out.println("Nombre: " + nombre);
            System.out.println("Email: " + email);
            System.out.println("Contrasenia: " + contrasenia);
        });

        // Se crea la escena con el GridPane como raíz (tamaño automático)
        Scene scene = new Scene(grid);
        // Se asigna la escena a la ventana
        stage.setScene(scene);
        // Se hace visible la ventana
        stage.show();
    }

    public static void main(String[] args) {
        // Lanza la aplicación JavaFX
        launch(args);
    }
}