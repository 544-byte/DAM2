package Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class RestaurarArchivos { // Esto ni lo mires pq se lo he pedido a la ia
    public static void restaurarBackup() {
        Path directorio = Paths.get("Directorio");
        Path backup = Paths.get("DirectorioBackup");

        try {
            vaciarDirectorio(directorio);

            Files.walk(backup).forEach(origen -> {
                try {
                    Path destino = directorio.resolve(backup.relativize(origen));

                    if (Files.isDirectory(origen)) {
                        Files.createDirectories(destino);
                    } else {
                        Files.copy(
                                origen,
                                destino,
                                StandardCopyOption.REPLACE_EXISTING
                        );
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            IO.println("Backup restaurado correctamente.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void vaciarDirectorio(Path directorio) throws IOException {
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio);
            return;
        }

        Files.walk(directorio)
                .sorted((a, b) -> b.getNameCount() - a.getNameCount()) // hijos antes que padres
                .filter(path -> !path.equals(directorio))              // NO borrar la raíz
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
