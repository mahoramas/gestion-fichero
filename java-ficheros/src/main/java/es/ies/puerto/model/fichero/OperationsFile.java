package es.ies.puerto.model.fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import es.ies.puerto.model.OperationsFile;
import es.ies.puerto.model.Empleado;

public class Operations implements OperationsFile {

    File fichero;
    String path ="/home/dam/Escritorio/PRO/java-ficheros/src/main/resources/archivo.txt";

    public Operations(){
        fichero = new File(path);
        if (!fichero.exists() || !fichero.isFile()) {
            throw new IllegalArgumentException("El recurso no es de tipo fichero" + path);
        }
    }

    @Override
    public boolean create(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador() == null) {
            return false;
        }
        Set<Empleado> empleados = read(fichero);
        if (empleados.contains(empleado)) {
            return false;
        }
        return create(empleado.toString(), fichero);
    
    }

    private boolean create(String data,File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public Empleado read(String identificador) {
        return read(empleado.getIdentificador);
    } 
        

    @Override
    public Empleado read(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador()== null) {
            return empleado;
        }
        Set<Empleado> empleados = read(fichero);
        for (Empleado empleadoBuscar : empleados) {
            if (empleadoBuscar.equals((empleado))) {
                return empleadoBuscar;
            }
        }
        return empleado;
    }
    

    @Override
    public boolean update(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador() == null) {
            return false;
        }
        Set<Empleado> empleados = read(fichero);
        if (!empleados.contains(empleado)) {
            return false;
        }
        for (Empleado empleadoBuscada : empleados) {
            if (empleadoBuscada.equals(empleado)) {
                empleadoBuscada = empleado;
            }
        }
        System.out.println(empleados);
        return false;
    }

    @Override
    public boolean delete(String identificador) {
        if (read(identificador)){
            delete(identificador, fichero);
        }
    }

    public boolean delete(String dataToDelete,File file) {
        File tempFile = new File("temp.txt");
    
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
    
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(dataToDelete)) { 
                    writer.write(line);
                    writer.newLine();
                    return true;
                }
            }
    
            if (file.delete()) {
                tempFile.renameTo(file);
                System.out.println("Registro eliminado.");
                return true;
            } else {
                System.out.println("Error al eliminar el archivo original.");
                return false;
            }
    
        } catch (IOException e) {
            return false;
        }
        
    }

    
    public static int getEdad(Empleado empleado) {
        if (empleado.getFechaNacimiento() == null || empleado.getFechaNacimiento().isEmpty()) {
            throw new IllegalStateException("La fecha de nacimiento no está definida");
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-aaaa");
        LocalDate fechaNacimiento = LocalDate.parse(empleado.getFechaNacimiento(), formatter);
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    
}
