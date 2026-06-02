import java.util.Scanner;

public class Menu {

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- Sistema de Registro de Estudiantes ---");
            System.out.println("1. Registrar nuevo estudiante");
            System.out.println("2. Salir del sistema");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion == 1) {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(scanner.nextLine());

                    System.out.print("Índice: ");
                    double indice = Double.parseDouble(scanner.nextLine());

                    System.out.println("\n--- Resultado ---");
                    
                    try {
                        Validador.validarEstudiante(nombre, edad, indice);
                        System.out.println("Estudiante registrado correctamente.");
                        
                    } catch (EstudianteInvalidoException e) {
                        System.out.println(e.getMessage());
                        
                    } finally {
                        System.out.println("Proceso finalizado.");
                    }
                    
                } else if (opcion != 2) {
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error de entrada: Por favor, ingrese un valor numérico válido.");
            }

        } while (opcion != 2);

        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        scanner.close();
    }
}