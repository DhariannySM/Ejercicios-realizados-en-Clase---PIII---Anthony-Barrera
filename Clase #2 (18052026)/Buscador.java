import java.util.ArrayList;
import java.util.Scanner;

public class Buscador {
    public static Paciente buscar(ArrayList<Paciente> lista, Scanner teclado) {
        if (lista.isEmpty()) {
            System.out.println("\nPrimero debe registrar al menos un paciente.");
            return null;
        }

        System.out.print("Ingrese el nombre del paciente: ");
        String nombreBuscado = teclado.nextLine();

        for (Paciente p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return p; 
            }
        }

        System.out.println("Paciente no encontrado.");
        return null;
    }
}