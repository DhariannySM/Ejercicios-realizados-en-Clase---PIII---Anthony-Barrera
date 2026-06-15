import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//PROGRAMA QUE PERMITE REGISTRAR ESTUDIANTES EN UN ARCHIVO, Y MUESTRA EL CONTENIDO DEL ARCHIVO CUANDO SE DESEE. 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File archivo = new File("estudiantes.txt");
        int opcion = 0;

        try{
            do{
                System.out.println("\n---SISTEMA DE REGISTRO DE ESTUDIANTES---");
                System.out.println("1. Registrar estudiante.");
                System.out.println("2. Mostrar estudiantes.");
                System.out.println("3. Salir.");
                opcion = sc.nextInt();
                sc.nextLine();

            if(opcion == 1){
                boolean archivoExiste = archivo.exists();

                FileWriter fw = new FileWriter("estudiantes.txt" , true);
                BufferedWriter bufferedWriter = new BufferedWriter(fw);

                System.out.println("\nEscriba el nombre del estudiante:");
                String nombre = sc.nextLine();

                bufferedWriter.write(nombre);
                bufferedWriter.newLine();
                bufferedWriter.close();
                fw.close();

                System.out.println("Nombre del archivo: " + archivo.getName());
                System.out.println("Ruta del archivo: " + archivo.getAbsolutePath());
            
                if(!archivoExiste){
                    System.out.println("El archivo se ha creado por primera vez, se agrego el estudiante.");
                } else{
                        System.out.println("El archivo ya existe, se agrego el estudiante.");
                    }
                } else if(opcion == 2){
                    if(archivo.exists()){
                    FileReader read = new FileReader("estudiantes.txt");
                    BufferedReader buffer = new BufferedReader(read);
                    String linea;

                    System.out.println("\n----CONTENIDO DEL ARCHIVO----");
                    while((linea = buffer.readLine()) != null){
                        System.out.println(linea);
                    }
                    buffer.close();
                    read.close();
                }else{
                    System.out.println("No hay estudiantes registrados todavia, por lo que el archivo no existe.");
                }
            }

        } while(opcion != 3);
            System.out.println("Saliendo del sistema....Hasta luego.");
            sc.close();

        }catch(Exception e){
                    System.out.println("Ocurrio un problema: " + e.getMessage());
        }
    }
    }
