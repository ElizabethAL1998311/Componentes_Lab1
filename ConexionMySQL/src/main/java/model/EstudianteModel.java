package model;

public class EstudianteModel extends UsuarioModel{
    private String estado;

    public EstudianteModel( String nombre, String identificacion, String correo,String estado) {
        super(nombre, identificacion, correo);
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
                "estado='" + estado + '\'' +
                '}';
    }
}
