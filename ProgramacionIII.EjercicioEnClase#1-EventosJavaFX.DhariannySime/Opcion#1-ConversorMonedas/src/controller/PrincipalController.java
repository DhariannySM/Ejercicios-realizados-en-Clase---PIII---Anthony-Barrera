package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML private TextField txtMonto;
    @FXML private ComboBox<String> cmbMoneda;
    @FXML private Label lblResultado;
    @FXML private Label lblEstado;

    @FXML
    public void initialize() {
        cmbMoneda.getItems().addAll("Dólar estadounidense", "Euro");
        lblEstado.setText("Esperando información...");
        lblResultado.setText("---");
    }

    @FXML
    void calcular(ActionEvent event) {
        realizarConversion();
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtMonto.clear();
        cmbMoneda.getSelectionModel().clearSelection();
        lblResultado.setText("---");
        lblEstado.setText("Esperando información...");
    }

    @FXML
    void mouseEntraBtn(MouseEvent event) {
        lblEstado.setText("Presione para realizar la conversión.");
    }

    @FXML
    void mouseSaleBtn(MouseEvent event) {
        lblEstado.setText("Esperando información...");
    }

    @FXML
    void teclaPresionada(KeyEvent teclado) {
        if (teclado.getCode() == KeyCode.ENTER) {
            realizarConversion();
        }
    }

    private void realizarConversion() {
        String textoMonto = txtMonto.getText();
        String monedaDestino = cmbMoneda.getValue();

        if (textoMonto == null || textoMonto.isEmpty()) {
            lblEstado.setText("Error: Ingrese un monto.");
            return;
        }

        if (monedaDestino == null) {
            lblEstado.setText("Error: Seleccione una moneda.");
            return;
        }

        try {
            double montoDOP = Double.parseDouble(textoMonto);
            double resultado = 0.0;
            String simbolo = "";

            if (monedaDestino.equals("Dólar estadounidense")) {
                resultado = montoDOP / 59.00;
                simbolo = "USD";
            } else if (monedaDestino.equals("Euro")) {
                resultado = montoDOP / 64.00;
                simbolo = "EUR";
            }

            lblResultado.setText(String.format("RD$ %.2f equivale a %.2f %s", montoDOP, resultado, simbolo));
            lblEstado.setText("Conversión exitosa.");

        } catch (NumberFormatException e) {
            lblEstado.setText("Error: El monto debe ser numérico.");
        }
    }
}