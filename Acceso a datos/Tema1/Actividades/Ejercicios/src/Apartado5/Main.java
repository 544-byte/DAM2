package Apartado5;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
    public void ejx(String ruta){
        System.out.println("---- COMIENZO EJERCICIO x ----");
        Path dir = Paths.get(ruta);
        System.out.println("----- FIN DE EJERCICIO x -----\n");
    }
*/
/**
 * Apartado 5: ejercicios de conversión entre ficheros CSV y ficheros de
 * objetos serializados ({@link ObjectOutputStream}/{@link ObjectInputStream}).
 */
public class Main {
    /** Punto de entrada del apartado 5. Ejecuta los ejercicios 1 al 3.
     *
     * @throws IOException si falla alguna operación de ficheros implicada
     */
    public static void main() throws IOException {
        System.out.println("----- COMIENZO PAQUETE 5 -----");
        ej1("Directorio/Apartado5/Productos.csv");
        ej2("Directorio/Apartado5/Productos.dat");
        ej3("Directorio/Apartado5/Productos.dat");
        System.out.println("------ FIN DE PAQUETE 5 ------\n\n\n");
    }

    /**
     * Ejercicio 1: lee los productos de un fichero CSV con formato
     * {@code id,nombre,precio}, los serializa en un fichero binario de objetos
     * y después los lee de vuelta mostrándolos por pantalla.
     *
     * @param ruta ruta del fichero CSV de origen
     */
    public static void ej1(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 1 ----");
        Path dir = Paths.get(ruta);
        try (BufferedReader br = new BufferedReader(new FileReader(dir.toFile()));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Directorio/Apartado5/Productos.dat"))
        ) {
            List<String> productoList = br.readAllLines();
            ArrayList<Producto> productos = new ArrayList<>();
            for (String s : productoList){
                productos.add(new Producto(Integer.parseInt(s.split(",")[0]),s.split(",")[1],Double.parseDouble(s.split(",")[2])));
            }
            for (Producto p : productos){
                oos.writeObject(p);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Directorio/Apartado5/Productos.dat"))) {
            System.out.println("Leyendo los productos escritos:");
            while (true){
                Producto producto = (Producto) ois.readObject();
                System.out.println(producto.toString());
            }
        } catch (EOFException e){
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 1 -----\n");
    }

    /**
     * Ejercicio 2: lee secuencialmente los objetos {@link Producto} de un
     * fichero binario serializado y los muestra por pantalla.
     *
     * @param ruta ruta del fichero binario de objetos
     */
    public static void ej2(String ruta) {
        System.out.println("---- COMIENZO EJERCICIO 2 ----");
        File dir = new File(ruta);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir))) {
            while (true){
                Producto producto = (Producto) ois.readObject();
                System.out.println(producto.toString());
            }
        } catch (EOFException e){
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 2 -----\n");
    }

    /**
     * Ejercicio 3: lee los objetos {@link Producto} de un fichero serializado,
     * los vuelca de nuevo en un fichero CSV con sufijo {@code DatTo.csv} y
     * muestra su contenido por pantalla.
     *
     * @param ruta ruta del fichero binario de objetos
     */
    public static void ej3(String ruta){
        System.out.println("---- COMIENZO EJERCICIO 3 ----");
        File dir = new File(ruta);
        ArrayList<Producto> productoArrayList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir))) {
            while (true){
                Producto producto = (Producto) ois.readObject();
                productoArrayList.add(producto);
            }
        } catch (EOFException e){
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta.replace(".dat", "DatTo.csv")))) {
            for (Producto p : productoArrayList){
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(ruta.replace(".dat", "DatTo.csv")))) {
            System.out.println("Leyendo el fichero csv creado:");
            for (String s : br.readAllLines()){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----- FIN DE EJERCICIO 3 -----\n");
    }

}
