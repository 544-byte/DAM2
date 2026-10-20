import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionProductos {
    private List<Producto> productos = new ArrayList<>();

    public void cli(){
        String menu = "===== GESTIÓN DE PRODUCTOS =====\n" +
                "1. Añadir producto\n" +
                "2. Mostrar productos\n" +
                "3. Guardar productos\n" +
                "4. Cargar productos\n" +
                "5. Salir\n" +
                "Selecciones una opción: ";

        while (true){
            System.out.printf(menu);
            Scanner scan = new Scanner(System.in);
            switch (scan.nextLine()){
                case "1" -> {
                    System.out.println("===== AÑADIR PRODUCTO =====");
                    System.out.printf("id: ");
                    int id = scan.nextInt();scan.nextLine();
                    System.out.printf("Nombre: ");
                    String nombre = scan.nextLine();
                    System.out.printf("Precio: ");
                    double precio = scan.nextDouble();scan.nextLine();
                    System.out.printf("Categoría: ");
                    String categoria = scan.nextLine();
                    agregarProducto(new Producto(id,nombre,precio,true,categoria));

                }
                case "2" -> {
                    mostrarProductos();
                }
                case "3" -> {
                    System.out.printf("Introduzca el nombre del archivo: ");
                    guardar(scan.nextLine());
                }
                case "4" -> {
                    System.out.printf("Introduzca el nombre del archivo: ");
                    cargar(scan.nextLine());
                }
                case "5" -> {
                    return;
                }
                default -> {
                    System.err.println("ERROR, opción incorrecta, intentelo de nuevo.");
                }
            }

        }


    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
        System.out.println(producto.getName() + " ha sido creado correctamente");
    }

    public void mostrarProductos(){
        for (Producto p : productos) {
            System.out.println("------------------------------------\n" + p.toString());
        }
    }

    public void guardar(String archivo){
        new File(archivo).deleteOnExit(); //Descomentar la linea si se quieren borrar los archivos creados
        try {
            if (!(new File(archivo).exists())){
                new File(archivo).createNewFile();
            }
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo));
            for (Producto p : productos) {
                salida.writeObject(p);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void cargar(String archivo){
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));
            while (true) {
                try {
                    productos.add((Producto) entrada.readObject());
                } catch (EOFException e){
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
