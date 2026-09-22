public class Ej5ContadorDigitos {

    public static int contar(int n){
        if (n >= 0) {
            return Integer.toString(n).length();
        } else {
            throw new IllegalArgumentException("Debe introducir un número positivo");
        }
    }
}
