import java.lang.Math;
import java.io.*;
//Clase ProyectoJava
public class  ProyectoJava{
	
	//Metodo Constructor
	public static void main(String args[]){
	ProyectoJava Proyecto = new ProyectoJava();
	Proyecto.menu();	//solo se manda a llamar a menu desde aqui, ya que menu llama a los demas metodos posteriromente
	}
		
	
		//(1)Metodo Biseccion	
	public void MetodoBiseccion(){
		double a;
		double b;
		double tol;
		System.out.println("\t\t\t\"METODO DE BISECCION\"");
		System.out.println("Extremo Izquierdo: ");
		a=lee();
		System.out.println("Extremo Derecho: ");
		b=lee();
		System.out.println("Tolerancia: ");
		tol=lee();
		double c;
		do{
		c=(a+b)/2.0;
		if(((c*c-5)*(a*a-5))<0){
			b=c;
		}
		else{
			a=c;
		}
	    }while(Math.abs(a-b)>tol);
	    System.out.println("La raiz es: "+c);			
	}


	//(2)Metodo NewRaphson
	public void MetodoNewtonRaphson(){
		double a;
		double tol;
		double b;
		double c; 
		System.out.println("\t\t\t\"METODO DE NEWTON-RAPHSON\"");
		System.out.println("Primera Aproximacion: ");
		a=lee();
		System.out.println("Tolerancia: ");
		tol=lee();
		do{
			b=a-(a*a-a-2)/(2*a-1);
			c=Math.abs(a-b);
			a=b;	
	    	}while(c>tol);
	    	System.out.println("La raiz es: "+b);
		}


	//(3) metodo gauss
	public void MetodoGauss(){
		int i,j,k,n;
		double a[][] = new double [5][6];
		double cte,x1,x2,x3;
		double x[] = new double [5];
		System.out.println("\t\t\t\"METODO DE GAUSS\"");
		System.out.println("Dame el numero de incognitas (de hasta 5) ");
		n=leeint();
		System.out.println("Ingrese coeficientes");
		for(i=0;i<n;i++)
		{
			System.out.println("Renglon "+(i+1));
			for(j=0;j<=n;j++)
			{
				System.out.println(" Ingrese a "+(i+1)+" "+(j+1));
				a[i][j]=lee();
			}
		}
		for(i=0;i<n-1;i++){
		  for(j=i+1;j<=n;j++){
			 cte=(-a[j][i])/(a[i][i]);
		      for(k=i;k<n+1;k++){
			 a[j][k]=((a[i][k])*cte)+a[j][k];
			 }
		   }
		}
	 	x3=a[n-1][n]/a[n-1][n-1];
	 	x2=(a[n-2][n]-x3*a[n-2][n-1])/a[n-2][n-2];
	 	x1=(a[n-3][n]-x2*a[n-3][n-2]-x3*a[n-3][n-1])/a[n-3][n-3];
		System.out.println("x0= "+x1+" \nx1= " +x2+" \nx2= " +x3);
		}

	
	
	//(4)gauss seidel
	public void MetodoGaussSeidel(){
		double x0,x1,x2,tol,e;
		int i,j;
		double a[][]=new double [3][4];
		System.out.println("\t\t\t\"METODO DE GAUSS-SEIDEL 3 ECUACIONES\"");
		System.out.println("Ingrese tolerancia");
		tol=lee();
		System.out.println("Ingrese coeficientes");
		for(i=0;i<3;i++)
		{
			System.out.println("Renglon "+(i+1));
			for(j=0;j<=3;j++)
			{
				System.out.println(" Ingrese a "+(i+1)+" "+(j+1));
				a[i][j]=lee();
			}
		}
		x1=0.0;
		x2=0.0;
		do{
			e=x1;
			x0=(a[0][3]-x1*a[0][1]-x2*a[0][2])/a[0][0];
			x1=(a[1][3]-x0*a[1][0]-x2*a[1][2])/a[1][1];
			x2=(a[2][3]-x0*a[2][0]-x1*a[2][1])/a[2][2];
		}while(Math.abs(e-x1)>tol);
		System.out.println("x0= "+x0+" \nx1= " +x1+" \nx2= " +x2);
		}
	
	
	//(5) gauss jordan
	public void MetodoGaussJordan(){
		int i,j,k,n;
		double a[][] = new double [5][6];
		double cte;
		double x[] = new double [5];
		System.out.println("\t\t\t\"METODO DE GAUSS-JORDAN\"");
		System.out.println("No. de incognitas (maximo 5):   ");
		n=leeint();
		System.out.println("Dame los coeficientes: ");
		for(i=0;i<n;i++)
		{
			System.out.println("Renglon "+(i+1));
			for(j=0;j<=n;j++)
			{
				System.out.println(" Ingrese a "+(i+1)+" "+(j+1));
				a[i][j]=lee();
			}
		}
		for(i=0;i<n-1;i++){
		  for(j=i+1;j<=n;j++){
			 cte=(-a[j][i])/(a[i][i]);
		      for(k=i;k<n+1;k++){
			 a[j][k]=((a[i][k])*cte)+a[j][k];
			 }
		   }
		}
		for(i=0;i<n;i++)
		{
			System.out.println("Renglon "+(i+1));
			for(j=0;j<=n;j++)
			{
				System.out.println(" a "+(i+1)+" "+(j+1)+" =" +a[i][j]);
			}
		}
		}

	
	//(6) LU
	public void MetodoLu(){
		int i,j;
		double Y1,Y2,Y3,X1,X2,X3;
		double A[][] = new double [3][3];
		double L[][] = new double [3][3];
		double U[][] = new double [3][3];
		double B[] = new double [3];
		System.out.println("\t\t\t\"METODO DE LU    3 ECUACIONES\"");
		System.out.println("Ingrese coeficientes d");
		for(i=0;i<3;i++)
		{
			System.out.println("Renglon "+(i+1));
			for(j=0;j<3;j++)
			{
				System.out.println(" Ingrese a "+(i+1)+" "+(j+1));
				A[i][j]=lee();
			}
		}
		System.out.println("Ingrese los terminos independientes");
		for(i=0;i<3;i++){
			System.out.println("Termino  "+(i+1));
			B[i]=lee();
			}
		for(i=0;i<3;i++){
   			L[i][0]=A[i][0];
   			U[i][i]=1;
			}
		U[0][1]=A[0][1]/L[0][0];
		L[1][1]=A[1][1]-L[1][0]*U[0][1];
		L[2][1]=A[2][1]-L[2][0]*U[0][1];
		U[0][2]=A[0][2]/L[0][0];
		U[1][2]=(A[1][2]-L[1][0]*U[0][2])/L[1][1];
		L[2][2]=A[2][2]-L[2][0]*U[0][2]-L[2][1]*U[1][2];
		Y1=B[0]/L[0][0];
		Y2=(B[1]-L[1][0]*Y1)/L[1][1];
		Y3=(B[2]-L[2][0]*Y1-L[2][1]*Y2)/L[2][2];
		X3=Y3;
		X2=Y2-U[1][2]*X3;
		X1=Y1-U[0][1]*X2-U[0][2]*X3;
		System.out.println("El resultado es:\nx0= "+X1+" \nx1= " +X2+" \nx2= " +X3);
		}

	
	//(7) Interpolacion Newton
	public void MetodoInterNewton(){
		double a[][] = new double [5][2];
		double x,y,fx1x0,fx2x1,fx3x2,fx4x3,fx2x1x0,fx3x2x1,fx4x3x2,fx3x2x1x0,fx4x3x2x1,fx4x3x2x1x0;
		int i;
		System.out.println("\t\t\t\"INTERPOLACION DE DIFERENCIAS DE NEWTON P/ 5 PTOS.\"");
		System.out.println("Valor a interpolar: ");
		x=lee();
		System.out.println("Dame los 5 pares de puntos");
		for(i=0;i<5;i++){
				System.out.println("Dame x "+i);
				a[i][0]=lee();
				System.out.println("Dame f(x) "+i);
				a[i][1]=lee();
				}		
		fx1x0=(a[1][1]-a[0][1])/(a[1][0]-a[0][0]);
		fx2x1=(a[2][1]-a[1][1])/(a[2][0]-a[1][0]);
		fx3x2=(a[3][1]-a[2][1])/(a[3][0]-a[2][0]);
		fx4x3=(a[4][1]-a[3][1])/(a[4][0]-a[3][0]);
		fx2x1x0=(fx2x1-fx1x0)/(a[2][0]-a[0][0]);
		fx3x2x1=(fx3x2-fx2x1)/(a[3][0]-a[1][0]);
		fx4x3x2=(fx4x3-fx3x2)/(a[4][0]-a[2][0]);
		fx3x2x1x0=(fx3x2x1-fx2x1x0)/(a[3][0]-a[0][0]);
		fx4x3x2x1=(fx4x3x2-fx3x2x1)/(a[3][0]-a[0][0]);
		fx4x3x2x1x0=(fx4x3x2x1-fx3x2x1x0)/(a[4][0]-a[0][0]);
		y=a[0][1]+fx1x0*(x-a[0][0])+fx2x1x0*(x-a[0][0])*(x-a[1][0])+fx3x2x1x0*(x-a[0][0])*(x-a[1][0])*(x-a[2][0])+fx4x3x2x1x0*(x-a[0][0])*(x-a[1][0])*(x-a[2][0])*(x-a[3][0]);
	        System.out.println("f(x) en ese punto es: "+y);
		}


	//(8) Interpolacion Lagrange
	public void MetodoInterLagrange(){
		int n,i;
		double x,y;
		double a[][] = new double [4][2];
		System.out.println("\t\t\t\"METODO DE INTERPOLACION LAGRANGE  2-4 PTOS.\"");
		do{
		System.out.println("Dame el numero de puntos");
		n=leeint();	
		}while(n<2 || n>4);
		System.out.println("Dame los  pares de puntos");
		for(i=0;i<n;i++){
				System.out.println("Dame x "+i);
				a[i][0]=lee();
				System.out.println("Dame f(x) "+i);
				a[i][1]=lee();
				}
		System.out.println("Dame el valor a interpolar ");
		x=lee();
		switch(n){
			case 2:
			y=(((((x-a[1][0])*a[0][1])/(a[0][0]-a[1][0]))+(((x-a[0][0])*a[1][1])/(a[1][0]-a[0][0]))));
			System.out.println("f(x) en ese punto es: "+y);
			break;
			case 3:
			y=((x-a[1][0])*(x-a[2][0])*a[0][1])/((a[0][0]-a[1][0])*(a[0][0]-a[2][0]))+((x-a[0][0])*(x-a[2][0])*a[1][1])/((a[1][0]-a[0][0])*(a[1][0]-a[2][0]))+((x-a[1][0])*((x-a[0][0])*a[2][1])/((a[2][0]-a[0][0])*(a[2][0]-a[1][0])));
			System.out.println("f(x) en ese punto es: "+y);
			break;
			case 4:
			y=((x-a[1][0])*(x-a[3][0])*(x-a[2][0])*a[0][1])/((a[0][0]-a[1][0])*(a[0][0]-a[2][0])*(a[0][0]-a[3][0]))+((x-a[0][0])*(x-a[2][0])*(x-a[3][0])*a[1][1])/((a[1][0]-a[0][0])*(a[1][0]-a[2][0])*(a[1][0]-a[3][0]))+((x-a[0][0])*(x-a[1][0])*((x-a[3][0])*a[2][1])/((a[2][0]-a[0][0])*(a[2][0]-a[1][0])*(a[2][0]-a[3][0]))+((x-a[0][0])*(x-a[1][0])*((x-a[2][0])*a[
3][1])/((a[3][0]-a[0][0])*(a[3][0]-a[1][0])*(a[3][0]-a[2][0]))));
			System.out.println("f(x) en ese punto es: "+y);
			break;
			default:
			System.out.println("INVALIDO");
			break;	
		}
	}

	
	//para leer desde teclado
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

	//para  leer un entero
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
	
	
	//para salir del programa
	public int Fuera(){
		int sal; 
		System.out.println("\n\n\nSI DESEAS OTRO METODO PRESIONA [1]");
		sal=leeint();
		return sal;
		}




	//despliega menu
	public void menu(){
		int a;
		int p;
		do{
		do{
		System.out.println("\n\n\t\t\tMETODOS NUMERICOS\n\n");
		System.out.println("\t1.-Biseccion\n\t2.-Newton-Raphson\n\t3.-Gauss\n\t4.-Gauss-Seidel\n\t5.-Gauss-Jordan\n\t6.-LU\n\t7.-Interpolacion Newton\n\t8.-Interpolacion Lagrange");
		System.out.println("\n\nEscoja el numero del metodo que desea usar:");
		a=leeint();
		}while(a<1 || a>8);
		switch(a){
			case 1:
			MetodoBiseccion();  //manda a llamara a cada uno de los metodos
			p=Fuera();
			break;
			case 2:
			MetodoNewtonRaphson();
			p=Fuera();
			break;
			case 3:
			MetodoGauss();
			p=Fuera();
			break;
			case 4:
			MetodoGaussSeidel();
			p=Fuera();
			break;
			case 5:
			MetodoGaussJordan();
			p=Fuera();
			break;
			case 6:
			MetodoLu();
			p=Fuera();
			break;
			case 7:
			MetodoInterNewton();
			p=Fuera();
			break;
			case 8:
			MetodoInterLagrange();
			p=Fuera();
			break;
			default:
			System.out.println("Opcion incorrecta");
			p=1;
			break;
			}
		}while(p==1);
		}
	
	
	
	
	
	

}