
/**
 * Clase de entrada principal del proyecto. Ejecuta de forma encadenada los
 * métodos {@code main} de todos los apartados (1 a 7) con ejercicios de
 * acceso a datos y, al terminar, restaura el estado original de los ficheros.
 */
void main() throws IOException {
    Apartado1.Main.main();
    Apartado2.Main.main();
    Apartado3.Main.main();
    Apartado4.Main.main();
    Apartado5.Main.main();
    Apartado6.Main.main();
    Apartado7.Main.main();
    Util.RestaurarArchivos.restaurarBackup();
}