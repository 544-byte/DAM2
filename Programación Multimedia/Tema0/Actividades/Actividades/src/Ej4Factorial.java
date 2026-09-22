public class Ej4Factorial {

    public static int calc(int n){
        for (int i = n-1 ; i > 1 ; i--) { // pongo >1 porque no tiene sentido dar otra vuelta si multiplicar por 1 va a dar el mismo resultado
            n*=i;
        }
        return n;
    }
}
