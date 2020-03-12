package model.logic;

public class comparacionComparendoPor implements Comparable<Comparendo>
{
	private Comparendo comparendo;

	public static final String MOTOCICLETA = "MOTOCICLETA";
	public static final String BICICLETA = "BICICLETA";
	public static final String AUTOMOVIL = "AUTOMOVIL";
	public static final String BUS = "BUS";
	public static final String BUSETA = "BUSETA";
	public static final String CAMPERO = "BUSETA";
	public static final String CAMIONETA = "CAMIONETA";

	public comparacionComparendoPor (Comparendo pComparendo) {
		comparendo = pComparendo;
	}

	public Comparendo darComparendo() {
		return comparendo;
	}

	public boolean isEmpty() {

		return false;
	}


//	public boolean compararLocalizacion(comparacionComparendoPor o) 
//	{
////		boolean comparacion = false;
////		if (this.comparendo.darLatitud() > o.comparendo.darLatitud())
////		{
////			comparacion = 1;
////		}
////		else if (this.comparendo.darLatitud() == o.comparendo.darLatitud()) 
////		{
////			comparacion = 0;
////		}
////		else if (this.comparendo.darLatitud() < o.comparendo.darLatitud()) 
////		{
////			comparacion = -1;
////		}
////		return comparacion;
////	}


	@Override
	public int compareTo(Comparendo o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
