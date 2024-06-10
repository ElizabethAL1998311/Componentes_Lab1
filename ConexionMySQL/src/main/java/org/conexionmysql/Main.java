package org.conexionmysql;

import controller.ClaseController;
import controller.EstudianteController;
import controller.ProfesorController;
import controller.UsuarioController;
import view.ConsoleView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleView viewConsole = new ConsoleView();
        Scanner scanner = new Scanner(System.in);
        // Crear instancias de los controladores necesarios
        UsuarioController usuarioController = new UsuarioController(viewConsole);
        EstudianteController estudianteController = new EstudianteController(viewConsole);
        ProfesorController profesorController = new ProfesorController(viewConsole);
        mostrarMenu(scanner, usuarioController, estudianteController, profesorController);
        // Cerrar el Scanner después de usarlo
        scanner.close();
    }

    public static void mostrarMenu(Scanner scanner, UsuarioController usuarioController, EstudianteController estudianteController, ProfesorController profesorController) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("_________MENU PRINCIPAL_________:");
            System.out.println("1. Menú estudiante");
            System.out.println("2. Menú profesor");
            System.out.println("3. Menú usuario");
            System.out.println("0. Salir");
            System.out.print("Ingrese el número de opción: ");

            // Leer la opción del usuario
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    menuEstudiante(scanner, usuarioController, estudianteController, profesorController);
                    break;
                case 2:
                    menuProfesor(scanner, usuarioController, estudianteController, profesorController);
                    break;
                case 3:
                    menuUsuario(scanner, usuarioController, estudianteController, profesorController);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.print("Opción no válida");
            }
        }
    }

    public static void menuProfesor(Scanner scanner, UsuarioController usuarioController, EstudianteController estudianteController, ProfesorController profesorController) {
        ConsoleView consoleView = new ConsoleView();
        boolean continuar = true;
        while (continuar) {
            System.out.println("_________Menú de P R O F E S O R:");
            System.out.println("1. Agregar profesor");
            System.out.println("2. Leer profesor");
            System.out.println("3. Actualizar profesor");
            System.out.println("4. Eliminar profesor");
            System.out.println("0. De vuelta al menu principal");
            System.out.print("Ingrese el número de opción: ");

            // Leer la opción del usuario
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarProfesor(profesorController, scanner);
                    break;
                case 2:
                    obtenerProfesor(profesorController, scanner);
                    break;
                case 3:
                    editarProfesor(profesorController, scanner);
                    break;
                case 4:
                    eliminarProfesor(profesorController, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    consoleView.showMessage("Opción no válida");
            }
        }
    }

    public static void menuEstudiante(Scanner scanner, UsuarioController usuarioController, EstudianteController estudianteController, ProfesorController profesorController) {
        ConsoleView consoleView = new ConsoleView();
        boolean continuar = true;
        while (continuar) {
            System.out.println("__________Menú de E S T U D I A N T E:");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Leer estudiante");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("0. De vuelta al menu principal");
            System.out.print("Ingrese el número de opción: ");

            // Leer la opción del usuario
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarEstudiante(estudianteController, scanner);
                    break;
                case 2:
                    obtenerEstudiante(estudianteController, scanner);
                    break;
                case 3:
                    editarEstudiante(estudianteController, scanner);
                    break;
                case 4:
                    eliminarEstudiante(estudianteController, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    consoleView.showMessage("Opción no válida");
            }
        }
    }

    public static void menuUsuario(Scanner scanner, UsuarioController usuarioController, EstudianteController estudianteController, ProfesorController profesorController) {
        ConsoleView consoleView = new ConsoleView();
        boolean continuar = true;
        while (continuar) {
            System.out.println("__________Menú de U S U A R I O:");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Leer usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("0. De vuelta al menu principal");
            System.out.print("Ingrese el número de opción: ");

            // Leer la opción del usuario
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarUsuario(usuarioController, scanner);
                    break;
                case 2:
                    leerUsuario(usuarioController, scanner);
                    break;
                case 3:
                    editarUsuario(usuarioController, scanner);
                    break;
                case 4:
                    eliminarUsuario(usuarioController, scanner);
                    break;
                case 0:
                    continuar = false;
                    mostrarMenu(scanner, usuarioController, estudianteController, profesorController);
                    break;
                default:
                    consoleView.showMessage("Opción no válida");
            }
        }
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

    public static void editarEstudiante(EstudianteController estudianteController, Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante que desea editar: ");
        int estudiante_id = scanner.nextInt();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la nueva identificación: ");
        String identificacion = scanner.next();
        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.next();
        System.out.print("Ingrese el nuevo estado: ");
        String estado = scanner.next();
        estudianteController.editarEstudiante(estudiante_id, nombre, identificacion, correo, estado);
    }

    public static void editarProfesor(ProfesorController profesorController, Scanner scanner) {
        System.out.print("Ingrese el ID del profesor que desea editar: ");
        int profesor_id  = scanner.nextInt();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la nueva identificación: ");
        String identificacion = scanner.next();
        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.next();
        System.out.print("Ingrese el nuevo salario: ");
        Double salario = Double.valueOf(scanner.next());
        profesorController.editarProfesor(profesor_id, nombre, identificacion, correo, salario);
    }

    public static void eliminarUsuario(UsuarioController usuarioController, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int usuario_id = scanner.nextInt();
        usuarioController.eliminarUsuario(usuario_id);
    }

    public static void eliminarEstudiante(EstudianteController estudianteController, Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante a eliminar: ");
        int estudiante_id = scanner.nextInt();
        estudianteController.eliminarEstudiante(estudiante_id);
    }

    public static void eliminarProfesor(ProfesorController profesorController, Scanner scanner) {
        System.out.print("Ingrese el ID del profesor a eliminar: ");
        int profesor_id = scanner.nextInt();
        profesorController.eliminarProfesor(profesor_id);
    }
}
