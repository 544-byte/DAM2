package TercerApartado;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private String email;

    public Persona(String nombre, int edad, String email){
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " " + edad + " " + email;
    }
}
