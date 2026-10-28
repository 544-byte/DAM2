package Apartado4;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre;
    private String apellidos;
    private String curso;

    public Alumno(String nombre, String apellidos, String curso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return nombre+","+apellidos+","+curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
