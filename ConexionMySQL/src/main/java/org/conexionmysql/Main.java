package org.conexionmysql;

import controller.ClaseController;
import controller.EstudianteController;
import controller.UsuarioController;
import view.ConsoleView;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ConsoleView viewConsole = new ConsoleView();

        Scanner scanner = new Scanner(System.in);

        // Crear instancias de los controladores necesarios
        UsuarioController usuarioController = new UsuarioController(viewConsole);
        EstudianteController estudianteController = new EstudianteController(viewConsole);


        boolean continuar = true;

        while (continuar) {

            mostrarMenu();

            ConsoleView consoleView = new ConsoleView();
            // Leer la opción del usuario
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarUsuario(usuarioController, scanner);
                    break;
                case 2:
                    agregarEstudiante(estudianteController, scanner);
                    break;
                case 3:
                    leerUsuario(usuarioController, scanner);
                    break;
                case 4:
                   obtenerEstudiante(estudianteController, scanner);
                    break;
                case 5:
                    continuar = false; // Salir del bucle y terminar el programa
                    break;
                default:
                    consoleView.showMessage("Opción no válida");
            }
        }

        // Cerrar el Scanner después de usarlo
        scanner.close();
    }
    public static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Agregar usuario");
        System.out.println("2. Agregar estudiante");
        System.out.println("3. Leer usuario");
        System.out.println("4. Leer estudiante");
        System.out.print("Ingrese el número de opción: ");
    }

    public static void agregarUsuario(UsuarioController usuarioController, Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la identificación del usuario: ");
        String identificacion = scanner.next();
        System.out.print("Ingrese el correo del usuario: ");
        String correo = scanner.next();
        usuarioController.agregarUsuario(nombre, identificacion, correo);
    }

    public static void agregarEstudiante(EstudianteController estudianteController, Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante: ");
        int estudiante_id = scanner.nextInt();
        System.out.print("Ingrese el estado del estudiante: ");
        String estado = scanner.next();
        estudianteController.agregarEstudiante(estudiante_id, estado);
    }

    public static void leerUsuario(UsuarioController usuarioController, Scanner scanner) {
        System.out.print("Ingrese la identificación del usuario que desea leer: ");
        int usuario_id = Integer.parseInt(scanner.next());
        usuarioController.leerUsuario(usuario_id);
    }

    public static void obtenerEstudiante(EstudianteController estudianteController, Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante que desea leer: ");
        int estudiante_id = scanner.nextInt();
        estudianteController.obtenerEstudiante(estudiante_id);
    }

       /* //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello MySQL!");
        ConsoleView viewConsole = new ConsoleView();
        //ConexionController conexionController = new ConexionController(viewConsole);
        //conexionController.openConnection();
        ConsoleView consoleView = new ConsoleView();

        //Crear Usuario
        UsuarioController usuarioController= new UsuarioController(consoleView);

        String nombre = "Lucia";
        String identificacion ="4321";
        String correo = "Lucia@gmail.com";

        usuarioController.agregarUsuario(nombre,identificacion,correo);
        usuarioController.leerUsuario(identificacion);

        //Crear Estudiante
        EstudianteController EstudianteController= new EstudianteController(consoleView);
        int estudiante_id = Integer.parseInt("1");
        String estado ="Activo";

        EstudianteController.agregarEstudiante(estudiante_id,estado);*/

}