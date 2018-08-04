
public class Main {

    public static void main(String[] args){
    Thread hilo1 = new Proceso("Proceso 1","Paco");
    Thread hilo2 = new Proceso("Proceso 2","Leo");
    long InicioHilo = System.currentTimeMillis();
    int Num1=((Proceso) hilo1).PruebaPasarDatos(InicioHilo);
    try {
        hilo1.join(); //Join hace que espere a que el Hilo termine para continuar
    }catch (InterruptedException ie)
    {
        ie.printStackTrace();
    }
    ((Proceso) hilo2).TiempoEstimado(Num1);
        System.out.println("Sin Join Inicia el Hilo2 y prosigue sin esperar a que termine");
    }
}
