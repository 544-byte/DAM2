void main(String[] args) {
    /*
    args = new String[]{"java", "Archivo.txt", "ArchivoJava.txt"};
    */
    ProcessBuilder pb = new ProcessBuilder("grep",args[0],args[1]);
    try (BufferedWriter bw = Files.newBufferedWriter(Path.of(args[2]))){
        Process grep = pb.start();
        String salida = new String(grep.getInputStream().readAllBytes());
        grep.waitFor();
        bw.write(salida);
    }catch (IOException _){} catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}


