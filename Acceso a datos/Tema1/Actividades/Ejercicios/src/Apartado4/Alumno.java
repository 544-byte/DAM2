package Apartado4;

import java.io.Serializable;

/**
 * Clase que representa a un alumno con nombre, apellidos y curso,
 * serializable para poder almacenarse en ficheros de objetos.
 */
public class Alumno implements Serializable {
    /** Nombre del alumno. */
    private String nombre;
    /** Apellidos del alumno. */
    private String apellidos;
    /** Curso del alumno. */
    private String curso;

    /**
     * Construye un alumno con todos sus datos.
     *
     * @param nombre    nombre del alumno
     * @param apellidos apellidos del alumno
     * @param curso     curso en el que estudia el alumno
     */
    public Alumno(String nombre, String apellidos, String curso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
    }

    /** Devuelve el alumno con el formato {@code "nombre,apellidos,curso"}. */
    @Override
    public String toString() {
        return nombre+","+apellidos+","+curso;
    }

    /**
     * Devuelve el nombre del alumno.
     *
     * @return nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del alumno.
     *
     * @param nombre nombre del alumno
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve los apellidos del alumno.
     *
     * @return apellidos del alumno
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del alumno.
     *
     * @param apellidos apellidos del alumno
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Devuelve el curso del alumno.
     *
     * @return curso del alumno
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Establece el curso del alumno.
     *
     * @param curso curso del alumno
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
}
