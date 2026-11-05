import java.util.Random;

class Persona implements Runnable {

    private final String idPersona;
    private final int peso;
    private final int tMinPaso;
    private final int tMaxPaso;
    private final Puente puente;
    private final int dir;

    public int getPeso() {
        return peso;
    }

    public int getDir() {
        return dir;
    }

    Persona(
            Puente puente,
            int peso,
            int tMinPaso,
            int tMaxPaso,
            String idP,
            int dir) {

        this.puente = puente;
        this.peso = peso;
        this.tMinPaso = tMinPaso;
        this.tMaxPaso = tMaxPaso;
        this.idPersona = idP;
        this.dir = dir;
    }

    @Override
    public void run() {
        String Dir = (dir != 0) ? "izquierda" : "derecha";
        System.out.printf(
                "-- %s de %d kg quiere cruzar hacia la %s, en puente %d kg, %d personas.\n",
                this.idPersona,
                this.peso,
                Dir,
                puente.getPeso(),
                puente.getNumPersonas());

        boolean autorizado = false;

        while (!autorizado) {

            synchronized (this.puente) {

                autorizado =
                        this.puente.autorizacionPaso(this);

                if (!autorizado) {

                    try {

                        System.out.printf(
                                "# %s debe esperar.\n",
                                this.idPersona);

                        this.puente.wait();

                    } catch (InterruptedException ex) {

                        System.out.printf(
                                "Interrupción mientras %s espera.\n",
                                this.idPersona);
                    }
                }
            }
        }

        System.out.printf(
                "-> %s con peso %d puede cruzar, peso en puente %d con %d personas.\n",
                this.idPersona,
                this.getPeso(),
                this.puente.getPeso(),
                this.puente.getNumPersonas());

        Random r = new Random();

        int tiempoPaso =
                this.tMinPaso
                        + r.nextInt(this.tMaxPaso - this.tMinPaso + 1);

        try {

            System.out.printf(
                    "%s va a tardar tiempo %d en cruzar.\n",
                    this.idPersona,
                    tiempoPaso);

            Thread.sleep(250 * tiempoPaso);

        } catch (InterruptedException ex) {

            System.out.printf(
                    "Interrupción mientras %s pasa.\n",
                    this.idPersona);
        }

        synchronized (this.puente) {

            this.puente.terminaPaso(this);

            System.out.printf(
                    "<- %s sale del puente, puente soporta peso %d, %d personas.\n",
                    this.idPersona,
                    this.puente.getPeso(),
                    this.puente.getNumPersonas());

            puente.notifyAll();
        }
    }
}