import java.util.ArrayList;
import java.util.Scanner;

public class Registrador {
    public static void registrar(ArrayList<Paciente> lista, Scanner teclado) {
        try {
            System.out.println("\n--- REGISTRO DE PACIENTE ---");
            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();
            
            System.out.print("Edad: ");
            int edad = Integer.parseInt(teclado.nextLine());
            
            System.out.print("Peso (kg): ");
            double peso = Double.parseDouble(teclado.nextLine());
            
            System.out.print("Altura (m): ");
            double altura = Double.parseDouble(teclado.nextLine());

            Paciente p = new Paciente(nombre, edad, peso, altura);
            lista.add(p);
            System.out.println("¡Paciente registrado exitosamente!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Datos numéricos inválidos. Registro cancelado.");
        }
    }
}