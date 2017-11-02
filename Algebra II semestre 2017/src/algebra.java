
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Valeria
 */
public class algebra {
    private int pivoteN, pivoteV; 
    private int numMatriz, sign, n;
    private int matriz[][];
    private int An[][][];
    private int Xn[];

    public algebra() {
        this.pivoteN = 0;    // pivote nuevo inicialmente toma el valor del primer elemento de la matriz 
        this.pivoteV = 0;               //Sera 0 porque aun no existe pivote viejo
        this.numMatriz = 0;             //numero de matrices creadas
        this.n = 0;                     //numero de variables
        this.sign = 1;                  //signo de determinante
        this.matriz = new int[5][6];
        this.An = new int[10][5][6];      // Lista de matrices creadas
        this.Xn = new int[5];            //lista para los resultados de los valores de las variables
    }   

    public int[][][] getAn() {
        return An;
    }

    public int[] getXn() {
        return Xn;
    }

    public int getPivoteN() {
        return pivoteN;
    }

    public void setPivoteN(int pivoteN) {
        this.pivoteN = pivoteN;
    }

    public int getPivoteV() {
        return pivoteV;
    }

    public void setPivoteV(int pivoteV) {
        this.pivoteV = pivoteV;
    }

    public int getNumMatriz() {
        return numMatriz;
    }

    public void setNumMatriz(int numMatriz) {
        this.numMatriz = numMatriz;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    
    public static void main(String[] args) {
        int i,j;
        int matriz[][] = new int [5][6];
        algebra mat = new algebra();
        //para pruebas
        int matrizp[][] = {{3,4,6,1,2},{4,6,6,5,2},{1,0,0,3,1},{1,2,0,3,1}};
        int n = 4;
        /*System.out.println("\t\t\t\"Algoritmo de Bareiss\"");
        System.out.println("No. de incognitas (maximo 5):   ");
        int n = mat.leeint();   
        System.out.println("Dame los coeficientes: ");
        for(i=0;i<n;i++) 
        {
                System.out.println("Renglon "+(i+1));
                for(j=0;j<=n;j++)
                {
                        System.out.println(" Ingrese a "+(i+1)+" "+(j+1));
                        matriz[i][j]= mat.leeint();
                }
        }*/
        
        mat.setMatriz(matrizp);
        mat.setN(n);
        mat.setPivoteV(1);
        mat.setPivoteN(1);
        mat.imprimirFormaMat(mat);
        mat.AlgoritmodeBareiss(mat);
        
        
    }

       
 //algoritmo para encontrar la matriz escalonada para encontrar la solucion del sistema 
    public void AlgoritmodeBareiss(algebra mat){
	while((false == mat.esEscalonada(mat)) && (mat.numMatriz!= mat.n) ){
            System.out.println("\n Entro a la condicion no escalonada y num mat != de n ");
            int matrizV[][] = new int[5][6];
            matrizV = mat.matriz; //matriz vieja
            int k = mat.numMatriz;
            
            System.out.println("Numero de matrices " + k +"  pivote nuevo"+ mat.pivoteN);
            if (mat.pivoteV != 0){
                System.out.println("Estoy en pivoteV!=0 ");
                for (int i = k+1; i < mat.n-1; i++) {
                    
                    for (int j = k; j < mat.n; j++) {
                        
                        mat.matriz[i][j]= ((mat.pivoteN * matrizV[k][j])-(matrizV[i][k]))/ mat.pivoteV;
                        System.out.println("valor nuevo "+ mat.matriz[i][j]+ "en posicion " + i+", "+j );
                    
                    }
                   
                    
                }
            }else{
                mat.cambiarFilas(mat);
            }
            mat.pivoteN = matrizV[k][k];
            mat.addAn(mat);
            mat.anularColumn(mat);
            mat.numMatriz += 1;
            mat.pivoteV = mat.pivoteN;
        }
            
        int det = mat.calcDet(mat);
        System.out.println("Det"+ det);
        
        mat.imprimirFormaMat(mat);
        
        // buscando los valores de las incognitas
        int k;
        mat.Xn[n]= mat.matriz[n][n+1];
        for (int i = mat.n-1; i >= 1 ; i--) {
            k=i;
            int sum=0;
            for (int j = k+1; j < n; j++) {
                sum += mat.An[k-1][k][j]*mat.Xn[j];
            }
            mat.Xn[i]= ((mat.pivoteV* mat.An[k-1][k][mat.n+1])- sum)/ mat.An[k-1][k][k];
        }
        for (int i = 0; i < 10; i++) {
            mat.Xn[i] = mat.Xn[i]/det; 
        }
        
        
       
		
}
    
    //metodo cambia la fila donde esta el pivote con la que esta abajo
    public void cambiarFilas(algebra mat){
        System.out.println("Cambiando filas" + mat.numMatriz +"por"+ mat.numMatriz+1);
        for(int i=mat.numMatriz;i<mat.n;i++)
		{
                    for (int j = 0; j < mat.n; j++) {
                       int val = mat.matriz[i][j];
                       mat.matriz[i][j] = mat.matriz[i+1][j];
                       mat.matriz[i+1][j] = val;
                    }
		}
        mat.sign = mat.sign*-1;
    
    }
    
    
    //metodo agrega una matriz a la coleccion de matrices anteriores An , n =1,2,3...n
    public void addAn(algebra mat){
        int pos = mat.numMatriz;
        for(int i=0;i<mat.n;i++)
		{
                    for (int j = 0; j < mat.n; j++) {
                       
                       mat.An[pos][i][j] = mat.matriz[i][j]; 
                    }
		}
    
    }
    public void imprimirMat(algebra mat){
        for(int i=0;i<mat.n;i++)
		{
			System.out.println("Renglon "+(i+1));
			for(int j=0;j<=mat.n;j++)
			{
				System.out.println(" a "+(i+1)+" "+(j+1)+" =" + mat.matriz[i][j]);
			}
		}
    
    }
    //imprimir la matriz con forma de matriz
    public void imprimirFormaMat(algebra mat){
        String linea = "";    
        for(int i=0;i<mat.n;i++)
		{       linea ="";
			for(int j=0;j<=mat.n;j++)
			{
                            linea+= " "+ mat.matriz[i][j];
			}
                        System.out.println(linea);
		}
    
    }
        
    //funcion verifica si una matriz esta en forma escalonada con ceros bajo su diagonal
    public boolean esEscalonada(algebra mat){
        int num0=0;
        for (int i = 0; i < mat.n; i++) {
            for (int j = 0; j < mat.n; j++) {
                if(i>j && mat.matriz[i][j] != 0 ){
                    return false;
                }
               
            }
            
        }
        return true;
        
    }
    
    
    //calcula el determinante de la matriz
    public int calcDet(algebra mat){
                    int a = mat.matriz[n-1][n-1];
                    int det = mat.sign * a;
                    return det;
                }
    
    //Pone en 0 todas las entradas bajo la posicion del pivote , devuelve el signo
     public void anularColumn(algebra mat){
            System.out.println("Estoy anulando columnas en la columna "+ mat.numMatriz);
                    for(int j=mat.numMatriz+1;j<mat.n;j++)
			{
                            
                            System.out.println(" val "+ mat.matriz[j][mat.numMatriz] + " en  " + j+ ","+mat.numMatriz );
				mat.matriz[j][mat.numMatriz] = 0;
			}
                    mat.imprimirFormaMat(mat);
                }
    
    public int leeint(){
		int num;
		try{
			InputStreamReader isr = new InputStreamReader (System.in);
			BufferedReader br = new BufferedReader(isr);
			String sdato;
			sdato = br.readLine();
			num = Integer.parseInt(sdato);
		}
		catch(IOException ioe){
			num=0;
		}
		return num;
		}
    
    
    
   
    
}
