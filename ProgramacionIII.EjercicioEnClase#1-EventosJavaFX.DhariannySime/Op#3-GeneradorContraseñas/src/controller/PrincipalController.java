package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.util.Random;

public class PrincipalController {

    @FXML private TextField txtLongitud;
    @FXML private CheckBox chkMayusculas;
    @FXML private CheckBox chkNumeros;
    @FXML private CheckBox chkSimbolos;
    @FXML private Label lblPassword;
    @FXML private Label lblEstado;

    @FXML
    public void initialize() {
        lblEstado.setText("Esperando configuración...");
        lblPassword.setText("---");
    }

    @FXML
    void generar(ActionEvent event) {
        crearPassword();
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtLongitud.clear();
        chkMayusculas.setSelected(false);
        chkNumeros.setSelected(false);
        chkSimbolos.setSelected(false);
        lblPassword.setText("---");
        lblEstado.setText("Esperando configuración...");
    }

    @FXML
    void mouseEntraBtn(MouseEvent event) {
        lblEstado.setText("Presione para generar una nueva contraseña.");
    }

    @FXML
    void mouseSaleBtn(MouseEvent event) {
        lblEstado.setText("Esperando configuración...");
    }

    @FXML
    void teclaPresionada(KeyEvent teclado) {
        if (teclado.getCode() == KeyCode.ENTER) {
            crearPassword();
        }
    }

    private void crearPassword() {
        String textoLong = txtLongitud.getText();

        if (textoLong == null || textoLong.isEmpty()) {
            lblEstado.setText("Error: Ingrese la longitud.");
            return;
        }

        try {
            int longitud = Integer.parseInt(textoLong);
            
            if (longitud < 6) {
                lblEstado.setText("Error: La longitud debe ser >= 6.");
                return;
            }

            String min = "abcdefghijklmnopqrstuvwxyz";
            String may = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String num = "0123456789";
            String sim = "!@#$%&*?";

            String caracteresPermitidos = min; 
            
            if (chkMayusculas.isSelected()) caracteresPermitidos += may;
            if (chkNumeros.isSelected()) caracteresPermitidos += num;
            if (chkSimbolos.isSelected()) caracteresPermitidos += sim;

            Random random = new Random();
            StringBuilder passwordGenerada = new StringBuilder();

            for (int i = 0; i < longitud; i++) {
                int indiceAleatorio = random.nextInt(caracteresPermitidos.length());
                passwordGenerada.append(caracteresPermitidos.charAt(indiceAleatorio));
            }

            lblPassword.setText(passwordGenerada.toString());
            lblEstado.setText("Contraseña generada con éxito.");

        } catch (NumberFormatException e) {
            lblEstado.setText("Error: La longitud debe ser numérica.");
        }
    }
}