import java.util.ArrayList;
import java.util.Scanner;

public class Diagnosticador {
    public static void diagnosticar(ArrayList<Paciente> lista, Scanner teclado) {
        Paciente p = Buscador.buscar(lista, teclado);
        if (p != null) {
            System.out.println("\nEstado de peso para " + p.getNombre() + ": " + p.obtenerEstadoPeso());
        }
    }
}