package accesoadatos.tema2;

public record CabeceraArchivo(
        String nombre,
        String extension,
        long tamaño,
        byte firma
) {}
