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

   /* public void actualizarUsuario(String identificacion, String nuevoNombre, String nuevoCorreo) {
        try {
            int filasActualizadas = usuarioDAO.actualizarUsuario(identificacion, nuevoNombre, nuevoCorreo);
            if (filasActualizadas > 0) {
                viewConsole.showMessage("Usuario actualizado correctamente.");
            } else {
                viewConsole.showMessage("No se encontró ningún usuario para actualizar.");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(String identificacion) {
        try {
            int filasEliminadas = usuarioDAO.eliminarUsuario(identificacion);
            if (filasEliminadas > 0) {
                viewConsole.showMessage("Usuario eliminado correctamente.");
            } else {
                viewConsole.showMessage("No se encontró ningún usuario para eliminar.");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar usuario: " + e.getMessage());
        }
    }*/
}
