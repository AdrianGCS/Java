import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//declarar todas las variables//
		int filas = 5;
		int columnas = 10;
		int eleccion=0;
		char [][] matriz = new char[filas][columnas];		
		int fila=0, columna=0;
		String matriculaVehiculo = null,
				marcaVehiculo = null, 
				modeloVehiculo = null,
				CompaniaBus = null;
		boolean Coche_electrico = false ;
		int dniCoche =0,
			cilindradasMoto = 0,
			PlazasBus = 0,
			Recaudacion=0;
		Coche coche = new Coche(dniCoche,Coche_electrico, marcaVehiculo,modeloVehiculo,matriculaVehiculo);
		Autobus autobus = new Autobus(matriculaVehiculo, marcaVehiculo, modeloVehiculo, PlazasBus, CompaniaBus);
		Motos motos = new Motos(cilindradasMoto, marcaVehiculo, modeloVehiculo, matriculaVehiculo);
		Scanner teclado = new Scanner(System.in);
		
		inicializarMatriz(matriz, filas, columnas);
		
		do {
			System.out.println("1.Ver parking: ");
			System.out.println("2.Accede un coche: ");
			System.out.println("3.Accede una moto: ");
			System.out.println("4.Accede un autobus: ");
			System.out.println("5.Salida un vehiculo: ");
			System.out.println("6.Ver recaudacion: ");
			System.out.println("7.Salir del programa: ");
			eleccion=teclado.nextInt();
			
			//El switch determinara que funcion vamos a llamar//
			switch(eleccion) {
			case 1:
				imprimirMatriz(matriz, filas, columnas);
				System.out.println();
				break;
			case 2:
				//si las funciones devuleven true aumenta la recaudacion, 
				//si no vuelve a preguntar por una opion
				if(AlquilarPlazaCoche(matriz, fila, columna, teclado, coche)) {
				Recaudacion+=5;
				System.out.println("Recaudacion actual "+Recaudacion );
				}
				break;
			case 3:
				if(AlquilarPlazaMoto(matriz, fila, columna, teclado, motos)) {
				Recaudacion+=3;
				System.out.println("Recaudacion actual "+Recaudacion );
				}
				break;
			case 4:
				if(AlquilarPlazaAutobus(matriz, fila, columna, teclado, autobus)) {
				Recaudacion+=10;
				System.out.println("Recaudacion actual "+Recaudacion );
				}
				break;
			case 5:
				retirarVehiculo(matriz, fila, columna, teclado);
				break;
			case 6:
				System.out.println("Recaudacion actual "+Recaudacion );
				break;
			case 7:
				System.out.println("Cerrando Programa: ");
				break;
			default:
				System.out.println("Opcion no disponible: ");
		
			}
		}while(eleccion!=7);
	}
	private static void imprimirMatriz(char[][] matriz, int filas, int columnas) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}

	}

	private static void inicializarMatriz(char[][] matriz, int filas, int columnas) {
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (((j == 0) || (j == 9) || (i == 0) || (i == 4)))
					if ((j == 0 && i == 0) || (j == 9 && i == 0) || (j == 0 && i == 4) || (j == 9 && i == 4))
						matriz[i][j] = 'X';
					else if (i == 1 && j == 0)
						matriz[i][j] = 'E';
					else if (i == 3 && j == 0)
						matriz[i][j] = 'S';
					else
						matriz[i][j] = 'P';
				else
					matriz[i][j] = ' ';
			}
		}
	}
	private static boolean AlquilarPlazaCoche(char[][] Matriz, int F, int C, Scanner teclado, Coche coche) {
		char c, x;
		//este boolean se encarga de determinar si la funcion a acabado(y a incluido un nuevo vehiculo)
		boolean Alquilado= false;
		if(Estalleno(Matriz)) {
		//pedimos los datos
			System.out.println("Introduzca fila: ");
			F = teclado.nextInt();
			System.out.println("Introduzca columna: ");
			C = teclado.nextInt();
			//comprueba el estado del lugar que nos a dado
			if (Matriz[F][C]=='P' || Matriz[F][C]=='X' || Matriz[F][C]=='C'
					|| Matriz[F][C]=='A' || Matriz[F][C]=='E' || Matriz[F][C]=='M'
					|| Matriz[F][C]=='S') {
					System.out.println("Esta ocupado");
			} else {
				//si el lugar esta vacio pide mas datos
				Matriz[F][C] = 'C';
				System.out.println("Datos del coche:");
				System.out.println("Matricula:");
				coche.matriculaVehiculo = teclado.next();
				System.out.println("Marca:");
				coche.marcaVehiculo = teclado.next();
				System.out.println("Modelo:");
				coche.modeloVehiculo = teclado.next();
				try {
				System.out.println("DNI del coche");
				coche.dniCoche = teclado.nextInt();
				}catch(InputMismatchException error) {
					System.out.println("Error , se agradeceria que solo metiese numeros.");
				}
				System.out.println("Es electrico:");
				c = teclado.next().charAt(0);
				if((c == 'S'|| c =='s') )
					coche.Coche_electrico = true;
				else
					coche.Coche_electrico = false;
				//si se ha incluido un nuevo vehiculo en la Matriz la funcion devolvera un true
				Alquilado = true;
				
			}
		}
		return Alquilado;
		
}
	private static boolean AlquilarPlazaMoto(char[][] Matriz, int F, int C, Scanner teclado, Motos motos) {
		// TODO Auto-generated method stub
		char c, x;
		boolean Alquilado= false;
		if(Estalleno(Matriz)) {
			System.out.println("Introduzca fila: ");
			F = teclado.nextInt();
			System.out.println("Introduzca columna: ");
			C = teclado.nextInt();
			if (Matriz[F][C]=='P' || Matriz[F][C]=='X' || Matriz[F][C]=='C'
					|| Matriz[F][C]=='A' || Matriz[F][C]=='E' || Matriz[F][C]=='M'
					|| Matriz[F][C]=='S') {
					System.out.println("Esta ocupado");
			} else {
				Matriz[F][C] = 'M';
				System.out.println("Datos de la Moto:");
				System.out.println("Matricula:");
				motos.matriculaVehiculo = teclado.next();
				System.out.println("Marca:");
				motos.marcaVehiculo = teclado.next();
				System.out.println("Modelo:");
				motos.modeloVehiculo = teclado.next();
				System.out.println("Cilindrada");
				motos.cilindradaMoto = teclado.nextInt();
				
				Alquilado = true;
				
			}
		}
		return Alquilado;
	}
	private static boolean AlquilarPlazaAutobus(char[][] Matriz, int F, int C, Scanner teclado, Autobus autobus) {
		// TODO Auto-generated method stub
		char c, x;
		boolean Alquilado= false;
		if(Estalleno(Matriz)) {
			System.out.println("Introduzca fila: ");
			F = teclado.nextInt();
			System.out.println("Introduzca columna: ");
			C = teclado.nextInt();
			if (Matriz[F][C]=='P' || Matriz[F][C]=='X' || Matriz[F][C]=='C'
					|| Matriz[F][C]=='A' || Matriz[F][C]=='E' || Matriz[F][C]=='M'
					|| Matriz[F][C]=='S') {
					System.out.println("Esta ocupado");
			} else {
				Matriz[F][C] = 'A';
				System.out.println("Datos del Autobus:");
				System.out.println("Matricula:");
				autobus.matriculaVehiculo = teclado.next();
				System.out.println("Marca:");
				autobus.marcaVehiculo = teclado.next();
				System.out.println("Modelo:");
				autobus.modeloVehiculo = teclado.next();
				System.out.println("Plazas del autobus");
				autobus.plazasBus = teclado.nextInt();
				System.out.println("Compañia del Autobus");
				autobus.companiaBus = teclado.next();
				
				Alquilado = true;
				
			}
		}
		return Alquilado;
	}
	private static void retirarVehiculo(char[][] Matriz, int f, int c, Scanner teclado) {
		// TODO Auto-generated method stub
			System.out.println("introduzca fila: ");
			f = teclado.nextInt();
			System.out.println("Introduzca columna: ");
			c = teclado.nextInt();
			//Comprueba que la zona este llena por algo
			if (Matriz[f][c] == 'C' || Matriz[f][c] == 'A' || Matriz[f][c] == 'M') 
				Matriz[f][c] = ' ';
			else
				System.out.println("Plaza vacia");

}
	private static boolean Estalleno(char[][] Matriz) {
		boolean total=false;
		//Funcion encargada de comprobar si la Matriz esta llena
		for(int i=1;i<4;i++) {
			for(int j=1;j<9;j++) {
				if(Matriz[i][j]==' ')
					total=true;
			}
		}
		
		return total;
	}
}
