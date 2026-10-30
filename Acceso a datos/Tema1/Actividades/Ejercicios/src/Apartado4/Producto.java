package Apartado4;

/**
 * Producto de ejemplo formado por identificador, nombre y precio.
 * Se serializa manualmente con {@code DataOutputStream}; no implementa Serializable.
 */
public class Producto {
    /** Identificador del producto. */
    private int id;
    /** Nombre del producto. */
    private String name;
    /** Precio del producto. */
    private double price;

    /**
     * Construye un producto con todos sus datos.
     *
     * @param id    identificador del producto
     * @param name  nombre del producto
     * @param price precio del producto
     */
    public Producto(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /** Devuelve el producto con el formato {@code "id,name,price"}. */
    @Override
    public String toString() {
        return id+","+name+","+price;
    }


    /**
     * Devuelve el identificador del producto.
     *
     * @return identificador del producto
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del producto.
     *
     * @param id identificador del producto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return nombre del producto
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param name nombre del producto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el precio del producto.
     *
     * @return precio del producto
     */
    public double getPrice() {
        return price;
    }

    /**
     * Establece el precio del producto.
     *
     * @param price precio del producto
     */
    public void setPrice(double price) {
        this.price = price;
    }


}
