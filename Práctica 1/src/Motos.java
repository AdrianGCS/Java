
public class Motos extends Vehiculos {
	int cilindradaMoto;

	public Motos(int cilindradaMoto, String marcaVehiculo, String modeloVehiculo ,String matriculaVehiculo) {
		super(marcaVehiculo,matriculaVehiculo ,modeloVehiculo);
		this.cilindradaMoto = cilindradaMoto;
	}
//Getters and setters
	public int getCilindrada() {
		return cilindradaMoto;}

	public void setCilindrada(int cilindradaMoto) {
		this.cilindradaMoto = cilindradaMoto;}

	@Override
	public String toString() {
		return "Moto [matricula=" + matriculaVehiculo + ", marca=" + marcaVehiculo + ", modelo=" + modeloVehiculo + ", cilindrada=" + cilindradaMoto
				+ "]";
	}

}