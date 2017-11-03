import java.util.Scanner;
import java.util.Arrays;

/**
 Proyecto consiste en implementar el algoritmo de Bareiss (eliminación Gaussiana libre
de fracciones, método de “un solo paso”) para resolver sistemas con entradas enteras únicamente para
sistemas con un máximo de cinco ecuaciones y cinco incognitas.
 */
public class AlgoritmoBareiss {
	
	private static class Bareiss {
		private static float sistema[][];
                private static float An[][][];
		public static void metodo(float[][] matriz) {
			sistema = matriz;
			float pivoteV = 1;           //pivote anterior
			
			for (int i = 0; i < sistema.length; i++) {
				diagonalDeterminante(i);
				primerCuadrante(i, pivoteV);
				cuartoCuadrante(i, pivoteV);
				columnaACeros(i);
				pivoteV = sistema[i][i];
                                System.out.println("Matriz ");
                                for (int j = 0; j < sistema.length; j++){
                                    System.out.println(Arrays.toString(sistema[j]));
                                    
                                }
			}
			
			// despliega la matriz
			for (int i = 0; i < sistema.length; i++)
				System.out.println(Arrays.toString(sistema[i]));
			encuentraSolucion();
		}
		
		/**
		 * Convierte los números que se encuentran antes del índice, dentro de
		 * la diagonal determinante, en el determinante.
		 */
		private static void diagonalDeterminante(int posDet) {
			for (int i = 0; i < posDet; i++)
				sistema[i][i] = sistema[posDet][posDet];
		}
		
		
		private static void primerCuadrante(int posDet, float pivoteV) {
			for (int i = 0; i < posDet; i++) {
				for (int j = posDet + 1; j < sistema[0].length; j++) {
					sistema[i][j] = (((sistema[i][posDet] * sistema[posDet][j]) - 
									  (sistema[posDet][posDet] * sistema[i][j])) * -1) / pivoteV;
				}
			}
		}
		
		
		private static void cuartoCuadrante(int posDet, float pivoteV) {
			for (int i = posDet + 1; i < sistema.length; i++) {
				for (int j = posDet + 1; j < sistema[0].length; j++) {
					sistema[i][j] = ((sistema[posDet][posDet] * sistema[i][j]) - 
									 (sistema[i][posDet] * sistema[posDet][j])) / pivoteV;
				}
			}
		}
		
		/**
		 * Convierte los números que se encuentran en la columna indicada en
		 * ceros.
		 */
		private static void columnaACeros(int posDet) {
			float determinante = sistema[posDet][posDet];
			
			for (int i = 0; i < sistema.length; i++) 
				sistema[i][posDet] = 0;
			
			sistema[posDet][posDet] = determinante;
		}
		
		/**
		 * Analiza la matriz resultante y busca el resultado del método.
		 */
		private static void encuentraSolucion() {
			boolean infinito = false;
			boolean sinSolucion = false;
			float as[] = new float [sistema.length];
			
			for (int i = 0; i < sistema.length; i++) {
				if( sistema[i][i] == 0 ) {
					if (sistema[i][sistema[0].length - 1] == 0) {
						infinito = true;
					} else {
						sinSolucion = true;
					}
				} else {
					as[i] = sistema[i][sistema[0].length - 1] / sistema[i][i];
				}
			}
			
			if( sinSolucion == true) {
				System.out.println("* El sistema no tiene solución");
			} else if ( infinito == true) {
				System.out.println("* El sistema tiene  infinitas de soluciones");
			} else {
				for (int i = 0; i < as.length; i++) 
					System.out.println("a" + (i+1) + " = " + as[i]);
			}
		}
	}
	
	public static void printMat(float [][] matriz){
		for(int i=0; i<matriz.length; i++){
			for(int j=0; j< matriz[i].length; j++){
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static int validaDiagonal(float[][] matriz) {
		// Verificar que no haya 0 en la diagonal principal
		for(int i=0; i<matriz.length; i++){
			if(matriz[i][i]==0){
				return i;
			}
		}
		return -1;
	}
	
	private static void cambiarFilas(float[][] matriz) {
		// intercanbia la filas si hay ceros en la diagonal
		float[] aux = new float [matriz.length];
		int posCero = -1;          //numero del renglon donde hay un 0
		int contador=0;
		while(((posCero=validaDiagonal(matriz))!=-1)&& contador<1000){
			for(int i=0; i<matriz.length; i++){
				aux = matriz[posCero];	
				matriz[posCero]=matriz[i];
				matriz[i]=aux;
			}
			contador++;
		}
	}
	
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		int numCol = 0;
		int numRen = 0;
		float [][] matriz;
		
		System.out.println("* ¿Cuantas ecuaciones?");
		numRen = input.nextInt();
		
		System.out.println("* ¿Cuantas incógnitas?");
		numCol = input.nextInt() + 1;
		
		if (numRen != (numCol - 1)) {
			System.out.println("* El número de incógnitas debe ser igual al " + 
							   "número de ecuaciones solo se trabajan matrices nxn");
			return;
		}
		
		matriz = new float [numRen][numCol];
		
		System.out.println("* Inserte los valores:");
		
		for (int i = 0; i < numRen; i++) {
			int j;
			for (j = 0; j < numCol-1; j++){
				System.out.print("Posicion "+i+j+": ");
				matriz[i][j] = input.nextFloat();
			}
			System.out.print("Posicion "+i+j+": ");
			matriz[i][matriz[i].length-1] = input.nextFloat();
		}
		if(validaDiagonal(matriz)!=-1){
			cambiarFilas(matriz);
		}
		Bareiss.metodo(matriz);
	}
	
}