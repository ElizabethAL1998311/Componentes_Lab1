package org.conexionmysql;

import controller.ClaseController;
import controller.EstudianteController;
import controller.ProfesorController;
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
        ProfesorController profesorController = new ProfesorController(viewConsole);

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
                    agregarProfesor(profesorController, scanner);
                    break;
                case 4:
                    leerUsuario(usuarioController, scanner);
                    break;
                case 5:
                   obtenerEstudiante(estudianteController, scanner);
                    break;
                case 6:
                    obtenerProfesor(profesorController, scanner);
                    break;
                case 7:
                    editarUsuario(usuarioController, scanner);
                    break;
                case 8:
                    /*editarEstudiante(estudianteController, scanner);*/
                    break;
                case 9:
                    /*editarProfesor(profesorController, scanner);*/
                    break;
                case 10:
                    eliminarUsuario(usuarioController, scanner);
                    break;
                case 11:
                   /* eliminarEstudiante(estudianteController, scanner);*/
                    break;
                case 12:
                    /*eliminarProfesor(profesorController, scanner);*/
                    break;
                case 13:
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
        System.out.println("3. Agregar profesor");
        System.out.println("4. Leer usuario");
        System.out.println("5. Leer estudiante");
        System.out.println("6. Leer profesor");
        System.out.println("7. Actualizar usuario");
        System.out.println("8. Actualizar estudiante");
        System.out.println("9. Actualizar profesor");
        System.out.println("10. Eliminar usuario");
        System.out.println("11. Eliminar estudiante");
        System.out.println("12. Eliminar profesor");
        System.out.println("13. Salir");

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
    public static void agregarProfesor(ProfesorController profesorController, Scanner scanner) {
        System.out.print("Ingrese el ID del profesor: ");
        int profesor_id = scanner.nextInt();
        System.out.print("Ingrese el salario del profesor: ");
        String salario = scanner.next();
        profesorController.agregarProfesor(profesor_id, Double.valueOf(salario));
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
    public static void obtenerProfesor(ProfesorController profesorController, Scanner scanner) {
        System.out.print("Ingrese el ID del profesor que desea leer: ");
        int profesor_id = scanner.nextInt();
        profesorController.obtenerProfesor(profesor_id);
    }

    public static void editarUsuario(UsuarioController usuarioController, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario que desea editar: ");
        int usuario_id = scanner.nextInt();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la nueva identificación: ");
        String identificacion = scanner.next();
        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.next();
        usuarioController.editarUsuario(usuario_id, nombre, identificacion, correo);
    }

    public static  void eliminarUsuario(UsuarioController usuarioController, Scanner scanner){
        System.out.println("Ingrese el ID del usuario a eliminar: ");
        int usuario_id = scanner.nextInt();
        usuarioController.eliminarUsuario(usuario_id);
    }


}