import java.util.ArrayList;

public class Imprimir {
    public static void mostrarTodos(ArrayList<Paciente> lista) {
        if (lista.isEmpty()) {
            System.out.println("\nNo hay pacientes en el sistema.");
            return;
        }

        System.out.println("\n--- LISTA GENERAL ---");
        for (Paciente p : lista) {
            System.out.println("- " + p.getNombre() + " | Edad: " + p.getEdad() + " años");
        }
    }
}