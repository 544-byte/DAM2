package Apartado2;

/**
 * Registro de datos formado por un identificador y un número.
 *
 * @param id     identificador del registro
 * @param numero valor numérico asociado al registro
 */
public record Registro (
        int id,
        int numero
){
        /** Devuelve el registro con el formato {@code "id,numero"}. */
    @Override
    public String toString() {
        return id+","+numero;
    }
}