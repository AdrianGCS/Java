
public class Autobus extends Vehiculos {

	int plazasBus;
	String companiaBus;

	public Autobus(String matriculaVehiculo, String marcaVehiculo, String modeloVehiculo, int plazasBus, String companiaBus) {
		super(matriculaVehiculo, marcaVehiculo, modeloVehiculo);
		this.plazasBus = plazasBus;
		this.companiaBus = companiaBus;
	}
// Getters and setters
	public int getPlazas() {
		return plazasBus;
	}

	public void setPlazas(int plazasBus) {
		this.plazasBus = plazasBus;
	}

	public String getCompania() {
		return companiaBus;
	}

	public void setCompania( String companiaBus) {
		this.companiaBus = companiaBus;
	}

	@Override
	public String toString() {
		return "Autobus [matricula=" + matriculaVehiculo + ", marca=" + marcaVehiculo + ", modelo=" + modeloVehiculo + ", plazas=" + plazasBus
				+ ", compa�ia=" + companiaBus + "]";
	}

}