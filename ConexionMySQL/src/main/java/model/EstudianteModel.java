package model;

public class EstudianteModel extends PersonaModel {
    private String estado;

    public EstudianteModel(int id, String nombre, String apellido, String telefono, String identificacion, String correo, String estado) {
        super(id, nombre, apellido, telefono, identificacion, correo);
        this.estado = estado;
    }



    public EstudianteModel(int id, String estado) {
        super(id, "", "", "","",""); // Llamar al constructor de la clase base con valores vacíos para nombre, identificación y correo
        this.estado = estado;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EstudianteModel{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", estado=" + estado +
                '}';
    }

}
