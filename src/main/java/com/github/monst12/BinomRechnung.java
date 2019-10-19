package com.github.monst12;

import java.util.*;


public class BinomRechnung {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte geben sie die Anzahl der Experimente an (n, Ganzzahl):");
		int n = scanner.nextInt();
		
		System.out.println("Bitte geben sie die Anzahl der Treffer an (k, Ganzzahl):");
		int k = scanner.nextInt();
		
		System.out.println("Bitte geben sie die Wahrscheinlichkeit an (n, Gleitkommazahl):");
		double p = scanner.nextDouble();
		
		Binomial binomial = new Binomial(n, k , p);
		System.out.println("Die Wahrscheinlichkeit beträgt: "+binomial.wert());
		System.out.println("Der Erwartungswert beträgt: "+binomial.erwartungswert());
		
		scanner.close();
	}

}
