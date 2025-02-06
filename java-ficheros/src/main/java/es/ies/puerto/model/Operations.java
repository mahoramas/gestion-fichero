package es.ies.puerto.model;

public interface OperationsFile {
    public boolean create(Empleado empleado);
    public boolean update(Empleado empleado);
    public boolean delete(Empleado empleado);
    public Empleado read(Empleado empleado);
    public Empleado read(String identificador);
}

