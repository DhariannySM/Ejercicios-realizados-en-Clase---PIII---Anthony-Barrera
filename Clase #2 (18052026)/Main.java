import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== MENÚ SISTEMA MÉDICO ===");
            System.out.println("1. Registrar un paciente");
            System.out.println("2. Calcular IMC");
            System.out.println("3. Determinar estado de peso");
            System.out.println("4. Mostrar todos los pacientes");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    Registrador.registrar(listaPacientes, teclado);
                    break;
                case 2:
                    CalculadoraIMC.calcular(listaPacientes, teclado);
                    break;
                case 3:
                    Diagnosticador.diagnosticar(listaPacientes, teclado);
                    break;
                case 4:
                    Imprimir.mostrarTodos(listaPacientes);
                    break;
                case 5:
                    System.out.println("Cerrando sistema médico. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        teclado.close();
    }
}