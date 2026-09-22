import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ej9RegistroPersonas {
    //region Atributos
    private static final ArrayList<Ej9Persona> personas = new ArrayList<>();
    //endregion

    //region Métodos
    public static void registrar(Ej9Persona persona) {
        personas.add(persona);
    }

    public static Ej9Persona buscarPorDni(String dni) {
        for (Ej9Persona persona : personas) {
            if (persona.getDni().equals(dni)) {
                return persona;
            }
        }
        return null;
    }

    public static boolean eliminarPorNombreYApellidos(String nombre, String apellidos) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equals(nombre) && personas.get(i).getApellidos().equals(apellidos)) {
                personas.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void ordenarPorEdad() {
        Collections.sort(personas, Comparator.comparingInt(Ej9Persona::getEdad));
    }

    public static void mostrarTodas() {
        for (Ej9Persona persona : personas) {
            System.out.println(persona);
        }
    }

    public static int totalPersonas() {
        return personas.size();
    }
    //endregion

}
