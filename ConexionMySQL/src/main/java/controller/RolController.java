package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class RolController {

    private ConsoleView viewConsole;

    private RolDAO rolDAO;

    public RolController(ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.rolDAO = new RolDAO(connection);

    }

    public void agregarRol(String nombre, String descripcion) {
        RolModel rol = new RolModel(nombre, descripcion);
        try {
            rolDAO.agregarRol(rol);
            viewConsole.showMessage("Rol agregado correctamente con ID: " + rol.getId());
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al insertar rol: " + e.getMessage());
        }
    }


    public void leerRol(int rolId) {
        try {
            RolModel rol = rolDAO.obtenerRol(rolId);
            if (rol != null) {
                viewConsole.showMessage("Información del rol: " + rol.toString());
            } else {
                viewConsole.showMessage("Rol no encontrado.");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al leer rol: " + e.getMessage());
        }
    }

    public void editarRol(int rolId, String nombre, String descripcion) {
        RolModel rol = new RolModel(rolId, nombre, descripcion);
        try {
            rolDAO.editarRol(rolId, nombre, descripcion);
            viewConsole.showMessage("Rol actualizado correctamente.");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar rol: " + e.getMessage());
        }
    }


    public void eliminarRol(int rolId) {
        try {
            rolDAO.eliminarRol(rolId);
            viewConsole.showMessage("Rol eliminado correctamente");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar rol: " + e.getMessage());
        }
    }
}
