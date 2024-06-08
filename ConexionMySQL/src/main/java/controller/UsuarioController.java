package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioController {

    private ConsoleView viewConsole;

    private UsuarioDAO usuarioDAO;
    private ProfesorDAO profesorDAO;

    public UsuarioController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.usuarioDAO = new UsuarioDAO(connection);
        this.profesorDAO = new ProfesorDAO(connection);
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

    public void leerUsuario(int usuario_id) {
        try {
            UsuarioModel usuario = usuarioDAO.obtenerUsuario(usuario_id);
            if (usuario != null) {
                viewConsole.showMessage("Información del usuario: " + usuario.toString());
            } else {
                viewConsole.showMessage("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al leer usuario: " + e.getMessage());
        }
    }

    public void editarUsuario(int usuario_id, String nombre, String identificacion, String correo) {
        UsuarioModel datos = new UsuarioModel(usuario_id, nombre, identificacion, correo);
        try {
            usuarioDAO.editarUsuario(datos);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int usuario_id) {
        try {
            // Antes de eliminar al usuario, eliminamos al profesor correspondiente (si existe)
            profesorDAO.eliminarProfesorPorUsuario(usuario_id);

            // Luego, eliminamos al usuario
            usuarioDAO.eliminarUsuario(usuario_id);

            viewConsole.showMessage("Usuario eliminado correctamente");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar usuario: " + e.getMessage());
        }
    }

}
