
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Proceso extends Thread {

   private String nombre;
    //private long TiempoIncial
    public Proceso(String msg,String nombre)
    {

    super(msg);//Obtiene el nombre que le dimos en el Main
    this.nombre = nombre;//Obtiene la String nombre que le pasamos en el Main
    //this.TiempoIncial=Inicio
    }
    public int PruebaPasarDatos(long Inicio)
    { System.out.println("Comienza " + this.getName());
        for (int i=0;i<=20;i++){
            System.out.println(this.getName() +nombre);
            if (nombre=="Paco" && i==10) {
                try {
                    Thread.sleep(100); //para el Hilo durante 1 segundo
                    Sonido();
                    }catch (InterruptedException e){}


            }
        }
        return (int)(System.currentTimeMillis()-Inicio)/1000; //La idea es que al terminar el Hilo pase al Main cuanto a tardado
    }
    public void TiempoEstimado(int Inicio)
    {
        System.out.println("El Tiempo que tardamos en realizar la tarea fue " +Inicio);
    }
    public void Sonido(){
        try {

            Player apl = new Player(new FileInputStream(
                    "src/iphone-notificacion.mp3"));//le indicamos que sonido queremos que reproduzca
            apl.play();//Iniciamos la reproducion del sonido

            //Hay que mejorarlo para que pueda parar, actualmente solo para al terminar el sonido
        }catch (FileNotFoundException | JavaLayerException e){}
    }


}
