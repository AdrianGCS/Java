
public class Vehiculos {
	protected String marcaVehiculo;
	protected String modeloVehiculo;
	protected String matriculaVehiculo;
//Constructor
	public Vehiculos(String matriculaVehiculo, String marcaVehiculo, String modeloVehiculo) {
		this.matriculaVehiculo = matriculaVehiculo;
		this.marcaVehiculo = marcaVehiculo;
		this.modeloVehiculo = modeloVehiculo;
	}
//Getters and setters
	protected String getMarca() {
		return marcaVehiculo;
	}
	protected String getModelo() {
		return modeloVehiculo;
	}
	protected String getMatricula() {
		return matriculaVehiculo;
	}
	protected void setMarca(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}
	protected void setModelo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}
	protected void setMatricula(String matriculaVehiculo) {
		this.matriculaVehiculo = matriculaVehiculo;
	}


	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matriculaVehiculo + ", marca=" + marcaVehiculo + ", modelo=" + modeloVehiculo + "]";
	}
}

