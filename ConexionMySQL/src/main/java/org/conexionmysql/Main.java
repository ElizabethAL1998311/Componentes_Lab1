package org.conexionmysql;

import controller.ClaseController;
import controller.EstudianteController;
import controller.UsuarioController;
import view.ConsoleView;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello MySQL!");
        ConsoleView viewConsole = new ConsoleView();
        //ConexionController conexionController = new ConexionController(viewConsole);
        //conexionController.openConnection();
        ConsoleView consoleView = new ConsoleView();

        //Crear Usuario
        UsuarioController usuarioController= new UsuarioController(consoleView);

        usuarioController.agregarUsuario(nombre,identificacion,correo);

        //Crear Estudiante
        EstudianteController EstudianteController= new EstudianteController(consoleView);
        int estudiante_id = Integer.parseInt("1");
        String estado ="Activo";
        EstudianteController.agregarEstudiante(estudiante_id,estado);
    }

}