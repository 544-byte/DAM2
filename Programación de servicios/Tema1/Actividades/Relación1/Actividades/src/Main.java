void main() {

    ProcessBuilder pb = new ProcessBuilder("ls","/home/alexont","/home/alexont/descargas");
    try {
        Process ls = pb.start();
        String salida = new String(ls.getInputStream().readAllBytes());
        System.out.println(salida);
    }catch (IOException _){}


}
