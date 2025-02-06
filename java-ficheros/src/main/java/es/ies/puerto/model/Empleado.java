package es.ies.puerto.model;
import java.util.Objects;

public class Empleado {
    String identificador;
    String nombre;
    String puesto;
    double sueldo;
    String fechaNacimiento;

    public Empleado
    (){}

    public Empleado
    (String identificador){
        this.identificador = identificador;
    }


    public Empleado
    (String identificador, String nombre, String puesto, double sueldo, String fechaNacimiento) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getIdentificador() {
        return this.identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    @Override
    public String toString() {
        return getIdentificador() +","+ getNombre() + "," +
            getPuesto() + "," +
            getSueldo() + "," + getFechaNacimiento();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado
        )) {
            return false;
        }
        Empleado
         Empleado
         = (Empleado
        ) o;
        return Objects.equals(identificador, Empleado
        .identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
    
    
}
