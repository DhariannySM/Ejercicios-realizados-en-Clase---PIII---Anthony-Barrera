package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML private TextField txtCliente;
    @FXML private ComboBox<String> cmbBebida;
    @FXML private TextField txtCantidad;
    @FXML private CheckBox chkPostre;
    @FXML private Label lblResumen;
    @FXML private Label lblEstado;

    @FXML
    public void initialize() {
        cmbBebida.getItems().addAll(
            "Café americano - RD$100", 
            "Cappuccino - RD$150", 
            "Chocolate caliente - RD$130", 
            "Jugo natural - RD$120"
        );
        lblEstado.setText("Esperando datos de la compra...");
        lblResumen.setText("---");
    }

    @FXML
    void calcular(ActionEvent event) {
        procesarCompra();
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtCliente.clear();
        cmbBebida.getSelectionModel().clearSelection();
        txtCantidad.clear();
        chkPostre.setSelected(false);
        lblResumen.setText("---");
        lblEstado.setText("Esperando datos de la compra...");
    }

    @FXML
    void mouseEntraBtn(MouseEvent event) {
        lblEstado.setText("Presione para calcular el total de la compra.");
    }

    @FXML
    void mouseSaleBtn(MouseEvent event) {
        lblEstado.setText("Esperando datos de la compra...");
    }

    @FXML
    void teclaPresionada(KeyEvent teclado) {
        if (teclado.getCode() == KeyCode.ENTER) {
            procesarCompra();
        }
    }

    private void procesarCompra() {
        String cliente = txtCliente.getText();
        String bebidaSelec = cmbBebida.getValue();
        String cantidadStr = txtCantidad.getText();

        if (cliente == null || cliente.isEmpty()) {
            lblEstado.setText("Error: Ingrese el nombre del cliente.");
            return;
        }
        if (bebidaSelec == null) {
            lblEstado.setText("Error: Seleccione una bebida.");
            return;
        }
        if (cantidadStr == null || cantidadStr.isEmpty()) {
            lblEstado.setText("Error: Ingrese la cantidad.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                lblEstado.setText("Error: La cantidad debe ser mayor a cero.");
                return;
            }

            double precioBebida = 0;
            if (bebidaSelec.contains("100")) precioBebida = 100;
            else if (bebidaSelec.contains("150")) precioBebida = 150;
            else if (bebidaSelec.contains("130")) precioBebida = 130;
            else if (bebidaSelec.contains("120")) precioBebida = 120;

            double subtotal = precioBebida * cantidad;
            double costoPostre = chkPostre.isSelected() ? 75.0 : 0.0;
            double total = subtotal + costoPostre;

            String resumen = String.format("Cliente: %s | Producto: %s\nCantidad: %d | Subtotal: RD$%.2f\nPostre: %s | Total: RD$%.2f",
                    cliente, bebidaSelec.split("-")[0].trim(), cantidad, subtotal, chkPostre.isSelected() ? "Sí" : "No", total);

            lblResumen.setText(resumen);
            lblEstado.setText("Cálculo exitoso.");

        } catch (NumberFormatException e) {
            lblEstado.setText("Error: La cantidad debe ser un número entero.");
        }
    }
}