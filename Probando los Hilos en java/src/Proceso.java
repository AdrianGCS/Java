



public class Proceso extends Thread {

   private String nombre;

    public Proceso(String msg,String nombre)
    {

    super(msg);//Obtiene el nombre que le dimos en el Main
    this.nombre = nombre;//Obtiene la String nombre que le pasamos en el Main

    }
    public void run()
    { System.out.println("Comienza " + this.getName());
        for (int i=0;i<=20;i++){
            System.out.println(this.getName() +nombre);
            if (nombre=="Paco" && i==10) {
                try {
                    Thread.sleep(1000); //para el Hilo durante 1 segundo
                    }catch (InterruptedException e){}


            }
        }
    }
}
