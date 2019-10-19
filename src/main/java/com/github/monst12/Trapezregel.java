package com.github.monst12;

import java.util.*;


public class Trapezregel {

	public static void main(String[] args) {	
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		int repeatIn = 1;
			
		do{			
			
			//Collecting user input
			double a, b;

			System.out.println("Bitte geben sie die untere Integrationsgrenze (a) an: ");
			a = sc.nextDouble();

			System.out.println("Bitte geben sie die obere Integrationsgrenze (b) an: ");
			b = sc.nextDouble();


			double lastvalue = 0;
			double currvalue = 0;
			int n = 5;
			
			//Evaluation
			
			for(;n <= 100;n+=5){
				currvalue = trapez(a, b, n);
				System.out.println("Index n = "+n+" Naeherung In = "+currvalue);
				
				double abs = Math.abs((lastvalue-currvalue)/currvalue);
				
				if(abs < 10e-6){
					System.out.println("Der relative Fehler ist kleiner als 10e-6.");
					break;
				}
				
				lastvalue = currvalue;
			}
			
			//Quit Sequence
			
			System.out.println("Zum Abbrechen des Programms geben sie bitte \"0\" ein.");
			
			if(sc.hasNextInt())
				repeatIn = sc.nextInt();
			
		}while(repeatIn != 0);
		
		System.out.println("Das Programm wird nun verlassen.");
		sc.close();
	}
	
	/**
	 * Bildet eine Näherung eines Integrals über die Integrationsgrenzen a und b
	 * @param a Untere Integrationsgrenze
	 * @param b Obere Integrationsgrenze
	 * @param n Schritte zwischen den Grenzen
	 * @return Näherungswert
	 */
	public static double trapez(double a, double b, int n){
		double h = (b-a)/n;
		double result;
		double sum = f(a);
		
		for(int i = 1; i < n; i++){
			double xi = a+h*i;
			sum+=2*(f(xi));
		}	
		
		sum+=f((a+h*n));
		
		result = (h/2.0)*sum;
		
		return result;
	}
	
	/**
	 * Berechnet den Ausdruck exp(x)*(1.0/sqrt(1+(x*x*x))), wobei x größer 0 sein muss.
	 * @param x X-Wert
	 * @return Wert des obigen Ausdrucks
	 */
	public static double f(double x){
		if(x <= -1) {
			System.out.println("Fehler: Die angegebene Zahl für x ist kleiner gleich -1!");
			System.out.println("Das Programm wird nun verlassen.");
			System.exit(1);
			return 0;
		}		
		return Math.exp(x)*(1.0/Math.sqrt(1+(x*x*x)));
	}

}
