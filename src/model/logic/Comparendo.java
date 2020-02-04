package model.logic;

public class Comparendo implements Comparable<Comparendo>{

	private int objectId;
	private String fechaHora;
	private String claseVehiculo;
	private String tipoServicio;
	private String infraccion;
	private String descInfraccion;
	private String localidad;


	public Comparendo(int pObjectId, String pFechaHora, String pClaseVehiculo, String pTipoServicio, String pInfraccion, String pDescInfraccion, String pLocalidad) {
		objectId = pObjectId;
		fechaHora = pFechaHora;
		claseVehiculo = pClaseVehiculo;
		tipoServicio = pTipoServicio;
		infraccion = pInfraccion;
		descInfraccion = pDescInfraccion;
		localidad = pLocalidad;
	}

	public int darObjectId() {
		return objectId;
	}

	public String darFecha() {
		return fechaHora;
	}

	public String darClase() {
		return claseVehiculo;
	}

	public String tipoServicio() {
		return tipoServicio;
	}

	public String darInfraccion() {
		return infraccion;
	}

	public String darDescripcion() {
		return descInfraccion;
	}

	public String darLocalidad() {
		return localidad;
	}

	public String toString() {
		return Integer.toString(objectId) + " - " + fechaHora + " - " + infraccion + " - " + claseVehiculo + " - " + tipoServicio + " - " + localidad;
	}

	@Override
	public int compareTo(Comparendo o) {
		if (o.darObjectId() == this.objectId) {
			return 0;
		}
		else {
			return -1;
		}

	}

}
