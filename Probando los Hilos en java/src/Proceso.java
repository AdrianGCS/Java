



public class Proceso extends Thread {

   private String nombre;

    public Proceso(String msg,String nombre)
    {

    super(msg);
    this.nombre = nombre;

    }
    public void run()
    { System.out.println("Comienza " + this.getName());
        for (int i=0;i<=20;i++){
            System.out.println(this.getName() +nombre);
            if (nombre=="Paco" && i==10) {
                try {
                    Thread.sleep(1000);
                    }catch (InterruptedException e){}


            }
        }
    }
}
