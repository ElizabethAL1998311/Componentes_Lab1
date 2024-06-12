package model;

import java.sql.Date;

public class InscripcionModel {

    private int id;
    private int estudianteId;
    private int profesorId;
    private int claseId;
    private Date inscripcionDate;
    private double inscripcionPrice;
    public InscripcionModel(int estudianteId, int profesorId, int claseId) {
    }

    public InscripcionModel(int id, int estudianteId, Date inscripcionDate, double inscripcionPrice) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public int getClaseId() {
        return claseId;
    }

    public void setClaseId(int claseId) {
        this.claseId = claseId;
    }

    public Date getInscripcionDate() {
        return inscripcionDate;
    }

    public void setInscripcionDate(Date inscripcionDate) {
        this.inscripcionDate = inscripcionDate;
    }

    public double getInscripcionPrice() {
        return inscripcionPrice;
    }

    public void setInscripcionPrice(double inscripcionPrice) {
        this.inscripcionPrice = inscripcionPrice;
    }
}
