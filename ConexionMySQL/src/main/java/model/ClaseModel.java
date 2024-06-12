package model;

import java.sql.Time;
import java.util.Date;

public class ClaseModel {
    private int id;
    private int profesorId;
    private Date fechaClase;
    private Time horaInicio;
    private Time horaFin;

    public ClaseModel(int id, int profesorId, Date fechaClase, Time horaInicio, Time horaFin) {
        this.id = id;
        this.profesorId = profesorId;
        this.fechaClase = fechaClase;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public java.sql.Date getFechaClase() {
        return (java.sql.Date) fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
}
