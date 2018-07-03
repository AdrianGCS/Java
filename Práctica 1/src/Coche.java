
public class Coche extends Vehiculos {
	boolean Coche_electrico;
	int dniCoche;
//Constructor
	public Coche(int dniCoche, boolean Coche_electrico, String marcaVehiculo, String modeloVehiculo ,String matriculaVehiculo) {
		super(marcaVehiculo,modeloVehiculo,matriculaVehiculo);
		this.dniCoche = dniCoche;
		this.Coche_electrico = Coche_electrico;
	}
//Getters and setter
	public int getDni() {
		return dniCoche;
	}

	public void setDni(int dniCoche) {
		this.dniCoche = dniCoche;
	}

	public boolean isElectrico() {
		return Coche_electrico;
	}

	public void setElectrico(boolean Coche_electrico) {
		this.Coche_electrico = Coche_electrico;
	}
	@Override
	public String toString() {
		return "Coche [matricula=" + matriculaVehiculo + ", marca=" + marcaVehiculo + ", modelo=" + modeloVehiculo + ", dni=" + dniCoche
				+ ", electrico=" + Coche_electrico + "]";
	}

}
