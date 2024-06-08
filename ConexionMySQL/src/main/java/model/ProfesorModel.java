package model;

public class ProfesorModel extends UsuarioModel{
    private  double salario;

    public ProfesorModel(int id, String nombre, String identificacion, String correo, double salario) {
        super(id, nombre, identificacion, correo);
        this.salario = salario;
    }

    public ProfesorModel(int id, Double salario) {
        super(id, "", "", "");
        this.salario = salario;
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
                "salario=" + salario +
                '}';
    }
}
