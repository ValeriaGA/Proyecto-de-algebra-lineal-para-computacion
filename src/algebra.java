
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author Valeria
 */
public class algebra {

    public static void main(String[] args) {
     
       algebra gauss = new algebra();
       gauss.AlgoritmodeBareiss();
    }
    public void AlgoritmodeBareiss(){
		int i,j,k,n;
                int sign = 1;
                int pivoteN, pivoteV;
		int matriz[][] = new int [5][6];
		//double cte;
                int numMatriz = 0; // numero de matrices creadas
		double x[] = new double [5];
		System.out.println("\t\t\t\"Algoritmo de Bareiss\"");
		System.out.println("No. de incognitas (maximo 5):   ");
		n=leeint();       //cantidad de incognitas
		System.out.println("Dame los coeficientes: ");
		for(i=0;i<n;i++)
		{
			System.out.println("Renglon "+(i+1));
			for(j=0;j<=n;j++)
			{
				System.out.println(" Ingrese a "+(i+1)+" "+(j+1));
				matriz[i][j]=leeint();
			}
		}
                
      
                /*
		for(i=0;i<n-1;i++){
		  for(j=i+1;j<=n;j++){
			 cte=(-matriz[j][i])/(matriz[i][i]);
		      for(k=i;k<n+1;k++){
			 matriz[j][k]=((matriz[i][k])*cte)+matriz[j][k];
			 }
		   }
		}*/
		for(i=0;i<n;i++)
		{
			System.out.println("Renglon "+(i+1));
			for(j=0;j<=n;j++)
			{
				System.out.println(" a "+(i+1)+" "+(j+1)+" =" +matriz[i][j]);
			}
		}
		}
    public int calcDet(int matriz[][], int n, int sign){
                    int a = matriz[n][n];
                    int det = sign * a;
                    return det;
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
    
    
    public double lee(){
		double num;
		try{
			InputStreamReader isr = new InputStreamReader (System.in);
			BufferedReader br = new BufferedReader(isr);
			String sdato;
			sdato = br.readLine();
			num = Double.parseDouble(sdato);
		}
		catch(IOException ioe){
			num=0.0;
		}
		return num;
		}
    
    
   
    
}
