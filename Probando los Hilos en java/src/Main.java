
public class Main {

    public static void main(String[] args){
    Thread hilo = new Proceso("Proceso 1","Paco");
    Thread hilo2 = new Proceso("Proceso 2","Leo");

    hilo.start();
    hilo2.start();
    }
}
