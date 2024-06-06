package org.conexionmysql;

import controller.ClaseController;
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
        UsuarioController usuarioController= new UsuarioController(consoleView);
        String nombre = "Mario";
        String identificacion ="12345";
        String correo = "Mario@gamil.com";
        usuarioController.agregarUsuario(nombre,identificacion,correo);
    }
}