class Puente {

    private static final int PESO_MAXIMO = 200;
    private static final int MAX_PERSONAS = 4;
    private static final int MAX_PERSONAS_DIR = 3;

    private int peso = 0;
    private int numPersonas = 0;
    private int numPersonas0 = 0;
    private int numPersonas1 = 0;

    synchronized public int getPeso() {
        return peso;
    }

    synchronized public int getNumPersonas() {
        return numPersonas;
    }

    synchronized public boolean autorizacionPaso(Persona persona) {

        boolean result;
        int personasDir = 0;
        if (persona.getDir() == 0){
            personasDir = numPersonas0;
        } else {
            personasDir = numPersonas1;
        }
        if (this.peso + persona.getPeso() <= PESO_MAXIMO
                && this.numPersonas < MAX_PERSONAS && personasDir < MAX_PERSONAS_DIR) {

            this.numPersonas++;
            if (persona.getDir() == 0){
                numPersonas0++;
            } else {
                numPersonas1++;
            }
            this.peso += persona.getPeso();
            result = true;

        } else {
            result = false;
        }

        return result;
    }

    synchronized public void terminaPaso(Persona persona) {
        this.peso -= persona.getPeso();
        this.numPersonas--;
        if (persona.getDir() == 0){
            numPersonas0--;
        } else {
            numPersonas1--;
        }
    }
}