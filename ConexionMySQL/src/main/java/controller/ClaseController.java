package controller;

import model.ClaseDAO;
import model.ClaseModel;
import model.conexion;
import view.ConsoleView;

import java.sql.*;

public class ClaseController {
    private ConsoleView viewConsole;
    private ClaseDAO claseDAO;

    public ClaseController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.claseDAO = new ClaseDAO(connection);
    }

    public void agregarClase(int claseId, int cursoId, int profesorId, Date fechaClase, Time horaInicio, Time horaFin){
        ClaseModel datos = new ClaseModel(claseId, claseId,  cursoId, fechaClase,  horaInicio,  horaFin);
        try
        {
            claseDAO.agregarClase(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void obtenerClase(int claseId) {
        try {
            ClaseModel clase = claseDAO.obtenerClase(claseId);
            if (clase != null) {
                viewConsole.showMessage("Información: " + clase.toString());
            } else {
                viewConsole.showMessage("Datos no encontrados.");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al leer la entidad: " + e.getMessage());
        }
    }

    public void editarClase(int claseId, int cursoId, int profesorId, Date fechaClase, Time horaInicio, Time horaFin) {
        ClaseModel datos = new ClaseModel(claseId, cursoId, profesorId, fechaClase, horaInicio, horaFin);
        try {
            claseDAO.editarClase(claseId, cursoId, profesorId, fechaClase, horaInicio, horaFin);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    public void eliminarClase(int claseId) {
        try {
            claseDAO.eliminarClase(claseId);
            viewConsole.showMessage("Eliminación de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar datos: " + e.getMessage());
        }
    }



}
