package org.conexionmysql;

import controller.*;
import view.ConsoleView;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleView viewConsole = new ConsoleView();
        Scanner scanner = new Scanner(System.in);
        // Crear instancias de los controladores necesarios
        PersonaController usuarioController = new PersonaController(viewConsole);
        EstudianteController estudianteController = new EstudianteController(viewConsole);
        ProfesorController profesorController = new ProfesorController(viewConsole);
        ClaseController claseController = new ClaseController(viewConsole);
        InscripcionController inscripcionController = new InscripcionController(viewConsole);
        RolController rolController = new RolController(viewConsole);
        mostrarMenu(scanner,inscripcionController, usuarioController, estudianteController, profesorController, claseController, rolController);
        // Cerrar el Scanner después de usarlo
        scanner.close();
    }

    public static void mostrarMenu(Scanner scanner, InscripcionController inscripcionController, PersonaController usuarioController, EstudianteController estudianteController, ProfesorController profesorController, ClaseController ClaseController, RolController rolController) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("_________MENU PRINCIPAL_________:");
            System.out.println("1. Menú estudiante");
            System.out.println("2. Menú profesor");
            System.out.println("3. Menú usuario");
            System.out.println("4. Menú clase");
            System.out.println("5. Menú inscripcion");
            System.out.println("6. Menú rol");
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
                    menuUsuario(scanner,inscripcionController, usuarioController, estudianteController, profesorController, ClaseController);
                    break;
                case 4:
                    menuClase(ClaseController, scanner);
                    break;
                case 5:
                    menuInscripciones(inscripcionController, scanner);
                    break;
                case 6:
                    menuRol(rolController, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.print("Opción no válida");
            }
        }
    }

    public static void menuRol(RolController rolController, Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("__________Menú de R O L:");
            System.out.println("1. Agregar rol");
            System.out.println("2. Leer rol");
            System.out.println("3. Actualizar rol");
            System.out.println("4. Eliminar rol");
            System.out.println("0. De vuelta al menu principal");
            System.out.print("Ingrese el número de opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarRol(rolController, scanner);
                    break;
                case 2:
                    leerRol(rolController, scanner);
                    break;
                case 3:
                    editarRol(rolController, scanner);
                    break;
                case 4:
                    eliminarRol(rolController, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void eliminarRol(RolController rolController, Scanner scanner) {
        System.out.print("Ingrese el ID del rol a eliminar: ");
        int rol_id = scanner.nextInt();
        rolController.eliminarRol(rol_id);
    }

    private static void editarRol(RolController rolController, Scanner scanner) {
        System.out.print("Ingrese el ID del rol a actualizar: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el nuevo nombre del rol: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la nueva descripcion del rol: ");
        String descripcion = scanner.next();
        rolController.editarRol(id, nombre, descripcion);
    }


    private static void leerRol(RolController rolController, Scanner scanner) {
        System.out.print("Ingrese el ID del rol: ");
        int claseId = scanner.nextInt();
        rolController.leerRol(claseId);
    }

    private static void agregarRol(RolController rolController, Scanner scanner) {
        System.out.print("Ingrese el nombre del rol: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la descripcion del rol: ");
        String descripcion = scanner.next();
        rolController.agregarRol(nombre, descripcion);
    }


    public static void menuClase(ClaseController claseController, Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("__________Menú de C L A S E S:");
            System.out.println("1. Agregar clase");
            System.out.println("2. Leer clase");
            System.out.println("3. Actualizar clase");
            System.out.println("4. Eliminar clase");
            System.out.println("0. De vuelta al menu principal");
            System.out.print("Ingrese el número de opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarClase(claseController, scanner);
                    break;
                case 2:
                    leerClase(claseController, scanner);
                    break;
                case 3:
                    editarClase(claseController, scanner);
                    break;
                case 4:
                    eliminarClase(claseController, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void agregarClase(ClaseController claseController, Scanner scanner) {
        System.out.print("Ingrese el ID de la clase: ");
        int claseId = scanner.nextInt();
        System.out.print("Ingrese el ID del profesor: ");
        int profesorId = scanner.nextInt();
        System.out.print("Ingrese la fecha de la clase (yyyy-mm-dd): ");
        Date fechaClase = Date.valueOf(scanner.next());
        System.out.print("Ingrese la hora de inicio (hh:mm:ss): ");
        Time horaInicio = Time.valueOf(scanner.next());
        System.out.print("Ingrese la hora de fin (hh:mm:ss): ");
        Time horaFin = Time.valueOf(scanner.next());
        claseController.agregarClase(claseId, profesorId, fechaClase, horaInicio, horaFin);
    }

    private static void leerClase(ClaseController claseController, Scanner scanner) {
        System.out.print("Ingrese el ID de la clase: ");
        int claseId = scanner.nextInt();
        claseController.obtenerClase(claseId);
    }

    private static void editarClase(ClaseController claseController, Scanner scanner) {
        System.out.print("Ingrese el ID de la clase a editar: ");
        int claseId = scanner.nextInt();
        System.out.print("Ingrese el nuevo ID del profesor: ");
        int profesorId = scanner.nextInt();
        System.out.print("Ingrese la nueva fecha de la clase (yyyy-mm-dd): ");
        Date fechaClase = Date.valueOf(scanner.next());
        System.out.print("Ingrese la nueva hora de inicio (hh:mm:ss): ");
        Time horaInicio = Time.valueOf(scanner.next());
        System.out.print("Ingrese la nueva hora de fin (hh:mm:ss): ");
        Time horaFin = Time.valueOf(scanner.next());
        claseController.editarClase(claseId, profesorId, fechaClase, horaInicio, horaFin);
    }

    private static void eliminarClase(ClaseController claseController, Scanner scanner) {
        System.out.print("Ingrese el ID de la clase a eliminar: ");
        int claseId = scanner.nextInt();
        claseController.eliminarClase(claseId);
    }



    public static void menuInscripciones(InscripcionController inscripcionController, Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("__________Menú de I N S C R I P C I O N E S:");
            System.out.println("1. Agregar inscripción");
            System.out.println("2. Leer inscripción");
            System.out.println("3. Actualizar inscripción");
            System.out.println("4. Eliminar inscripción");
            System.out.println("0. De vuelta al menu principal");
            System.out.print("Ingrese el número de opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarInscripcion(inscripcionController, scanner);
                    break;
                case 2:
                    leerInscripcion(inscripcionController, scanner);
                    break;
                case 3:
                    editarInscripcion(inscripcionController, scanner);
                    break;
                case 4:
                    eliminarInscripcion(inscripcionController, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void editarInscripcion(InscripcionController inscripcionController, Scanner scanner) {
        System.out.print("Ingrese el ID de la inscripcion: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el ID del estudiante: ");
        int estudianteId = scanner.nextInt();
        System.out.print("Ingrese el ID del profesor: ");
        int profesorId = scanner.nextInt();
        System.out.print("Ingrese el ID de la clase: ");
        int claseId = scanner.nextInt();
        System.out.print("Ingrese la fecha de la inscripcion: ");
        Date inscripcionDate = Date.valueOf(scanner.next());
        System.out.print("Ingrese el precio de la inscripcion: ");
        Double inscripcionPrice = scanner.nextDouble();
        inscripcionController.editarInscripcion(id, estudianteId, profesorId, claseId);
    }

    private static void eliminarInscripcion(InscripcionController inscripcionController, Scanner scanner) {
        System.out.print("Ingrese el ID de la inscripción: ");
        int id = scanner.nextInt();
        inscripcionController.eliminarInscripcion(id);
    }

    private static void leerInscripcion(InscripcionController inscripcionController, Scanner scanner) {
        System.out.print("Ingrese el ID de la inscripción: ");
        int id = scanner.nextInt();
        inscripcionController.leerInscripcion(id);
    }

    private static void agregarInscripcion(InscripcionController inscripcionController, Scanner scanner) {
        System.out.print("Ingrese el ID de la inscripcion: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el ID del estudiante: ");
        int estudianteId = scanner.nextInt();
        System.out.print("Ingrese el ID del profesor: ");
        int profesorId = scanner.nextInt();
        System.out.print("Ingrese el ID de la clase: ");
        int claseId = scanner.nextInt();
        System.out.print("Ingrese la fecha de la inscripcion: ");
        Date inscripcionDate = Date.valueOf(scanner.next());
        System.out.print("Ingrese el precio de la inscripcion: ");
        Double inscripcionPrice = scanner.nextDouble();
        inscripcionController.agregarInscripcion(estudianteId, profesorId, claseId);
    }

    public static void menuProfesor(Scanner scanner, PersonaController usuarioController, EstudianteController estudianteController, ProfesorController profesorController) {
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

    public static void menuEstudiante(Scanner scanner, PersonaController usuarioController, EstudianteController estudianteController, ProfesorController profesorController) {
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

    public static void menuUsuario(Scanner scanner, InscripcionController inscripcionController, PersonaController usuarioController, EstudianteController estudianteController, ProfesorController profesorController, ClaseController ClaseController) {
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
                    break;
                default:
                    consoleView.showMessage("Opción no válida");
            }
        }
    }

    public static void agregarUsuario(PersonaController usuarioController, Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del usuario: ");
        String apellido = scanner.next();
        System.out.print("Ingrese la identificación del usuario: ");
        String identificacion = scanner.next();
        System.out.print("Ingrese el correo del usuario: ");
        String correo = scanner.next();
        System.out.print("Ingrese el telefono: ");
        String telefono = scanner.next();
        usuarioController.agregarUsuario(nombre, identificacion, correo, apellido,telefono);
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

    public static void leerUsuario(PersonaController usuarioController, Scanner scanner) {
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

    public static void editarUsuario(PersonaController usuarioController, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario que desea editar: ");
        int usuario_id = scanner.nextInt();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el nuevo apellido: ");
        String apellido = scanner.next();
        System.out.print("Ingrese la nueva identificación: ");
        String identificacion = scanner.next();
        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.next();
        System.out.print("Ingrese el nuevo telefono: ");
        String telefono = scanner.next();
        usuarioController.editarUsuario(usuario_id, nombre, identificacion, correo,apellido,telefono);
    }

    public static void editarEstudiante(EstudianteController estudianteController, Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante que desea editar: ");
        int estudiante_id = scanner.nextInt();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el nuevo apellido: ");
        String apellido = scanner.next();
        System.out.print("Ingrese la nueva identificación: ");
        String identificacion = scanner.next();
        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.next();
        System.out.print("Ingrese el nuevo estado: ");
        String estado = scanner.next();
        System.out.print("Ingrese el nuevo telefono: ");
        String telefono = scanner.next();
        estudianteController.editarEstudiante(estudiante_id, nombre, identificacion, correo,apellido,telefono, estado);
    }

    public static void editarProfesor(ProfesorController profesorController, Scanner scanner) {
        System.out.print("Ingrese el ID del profesor que desea editar: ");
        int profesor_id  = scanner.nextInt();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el nuevo apellido: ");
        String apellido = scanner.next();
        System.out.print("Ingrese la nueva identificación: ");
        String identificacion = scanner.next();
        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.next();
        System.out.print("Ingrese el nuevo salario: ");
        Double salario = Double.valueOf(scanner.next());
        System.out.print("Ingrese el nuevo telefono: ");
        String telefono = scanner.next();
        profesorController.editarProfesor(profesor_id, nombre, identificacion, correo,apellido,telefono, salario);
    }

    public static void eliminarUsuario(PersonaController usuarioController, Scanner scanner) {
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
