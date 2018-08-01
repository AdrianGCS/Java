public class Proceso extends Thread {

   private String nombre;

    public Proceso(String msg,String nombre)
    {

    super(msg);
    this.nombre = nombre;

    }
    public void run()
    {
        for (int i=0;i<=20;i++){
            System.out.println(this.getName() +nombre);
        }
    }
}
