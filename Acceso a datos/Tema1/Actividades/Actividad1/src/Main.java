void main() {

    GestionProductos g1 = new GestionProductos();
    g1.agregarProducto(new Producto(1,"Leche",4.00,true,"Lácteo"));
    g1.agregarProducto(new Producto(2,"Pan",1.50,true,"Panadería"));
    g1.agregarProducto(new Producto(3,"Café",7.99,false,"Bebidas"));
    g1.agregarProducto(new Producto(4,"Queso",9.75,true,"Lácteo"));
    g1.agregarProducto(new Producto(5,"Manzanas",2.30,true,"Fruta"));

    g1.mostrarProductos();

    g1.guardar("productos.dat");

    GestionProductos g2 = new GestionProductos();

    g2.cargar("productos.dat");

    g2.mostrarProductos();

    g1.cli();

}