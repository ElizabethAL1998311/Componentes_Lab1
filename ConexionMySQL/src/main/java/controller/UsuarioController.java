package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioController {

    private ConsoleView viewConsole;

    private UsuarioDAO usuarioDAO;

    public UsuarioController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.usuarioDAO = new UsuarioDAO(connection);
    }

    public void agregarUsuario(String nombre, String identificacion, String correo){
        UsuarioModel datos = new UsuarioModel(nombre,identificacion,correo);

        try
        {
            usuarioDAO.agregarUsuario(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }
}
