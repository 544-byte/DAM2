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
public class Main {
    public static void main() throws IOException {
        System.out.println("----- COMIENZO PAQUETE 5 -----");
        ej1("Directorio/Apartado5/Productos.csv");
        ej2("Directorio/Apartado5/Productos.dat");
        ej3("Directorio/Apartado5/Productos.dat");
        System.out.println("------ FIN DE PAQUETE 5 ------\n\n\n");
    }

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
