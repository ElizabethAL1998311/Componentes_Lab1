package model;

public class ProfesorModel extends UsuarioModel{

    private double salario;

    public ProfesorModel(String nombre, String identificacion, String correo) {
        super(nombre, identificacion, correo);
        this.salario= salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "ProfesorModel{" +
                "salario='" + salario + '\'' +
                '}';
    }
}
