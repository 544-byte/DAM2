void main() {
    ProcessBuilder pb = new ProcessBuilder("ls");
    System.out.println("Directorio por defecto: " + pb.directory());
    try {
        Process ls = pb.start();
        System.out.println(new String(ls.getInputStream().readAllBytes()));
        System.out.println("Cambiando directorio a src");
        pb.directory(new File("src"));
        System.out.println("Directorio actual: " + pb.directory());
        ls = pb.start();
        System.out.println(new String(ls.getInputStream().readAllBytes()));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


