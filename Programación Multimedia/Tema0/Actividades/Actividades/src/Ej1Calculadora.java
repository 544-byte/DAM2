public class Ej1Calculadora {
    private int n1;
    private int n2;

    public int Sumar (){
        return getN1()+getN2();
    }

    public int Restar(){
        return getN1()-getN2();
    }

    public int Multiplicar(){
        return getN1()*getN2();
    }

    public int Dividir(){
        return getN1()/getN2();
    }

    public int Resto(){
        return getN1()%getN2();
    }

    public void MostrarOp1(){
        System.out.println(getN1());
    }

    public void MostrarOp2(){
        System.out.println(getN2());
    }

    public int RaizOp1(){
        return (int) Math.sqrt(getN1());
    }

    public int RaizOp2(){
        return (int) Math.sqrt(getN2());
    }

    public int PotenciaOp1ElevadoOp2(){
        int res = getN1();
        for (int i = 1 ; i < getN2() ; i++){
            res *= getN1();
        }
        return res;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
}