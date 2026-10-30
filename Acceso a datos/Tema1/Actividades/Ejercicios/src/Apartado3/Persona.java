package Apartado3;

import java.io.Serializable;

/**
 * Clase que representa a una persona con nombre, edad y email,
 * serializable para poder almacenarse en ficheros de objetos.
 */
public class Persona implements Serializable {
    /** Nombre de la persona. */
    private String nombre;
    /** Edad de la persona. */
    private int edad;
    /** Email de la persona. */
    private String email;

    /**
     * Construye una persona con todos sus datos.
     *
     * @param nombre nombre de la persona
     * @param edad   edad de la persona
     * @param email  correo electrónico de la persona
     */
    public Persona(String nombre, int edad, String email){
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    /**
     * Devuelve el email de la persona.
     *
     * @return email de la persona
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email de la persona.
     *
     * @param email email de la persona
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la edad de la persona.
     *
     * @return edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad edad de la persona
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve el nombre de la persona.
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Devuelve la persona con el formato {@code "nombre edad email"}. */
    @Override
    public String toString() {
        return nombre + " " + edad + " " + email;
    }
}
