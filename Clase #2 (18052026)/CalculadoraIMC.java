import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraIMC {
    public static void calcular(ArrayList<Paciente> lista, Scanner teclado) {
        Paciente p = Buscador.buscar(lista, teclado);
        if (p != null) {
            System.out.println("\nEl IMC de " + p.getNombre() + " es: " + String.format("%.2f", p.calcularIMC()));
        }
    }
}