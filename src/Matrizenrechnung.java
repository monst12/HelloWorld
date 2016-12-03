import java.awt.Color;
import java.util.*;

public class Matrizenrechnung {
	
	/*
	 * Dieses Programm funktioniert am besten mit quadratischen Matrizen!
	 */
	private static final String COLOR_CLEAR = (char)27 + "[0m";
	private static final String COLOR_YELLOW = (char)27 + "[33m";
	private static final String COLOR_RED = (char)27 + "[31m";
	private static final String COLOR_GREEN = (char)27 + "[32m";
	private static final String COLOR_CYAN = (char)27 + "[36m";
	
	private static final String IN = (char)27 + "[33m >>"+(char)27 + "[0m ";
	private static final String OUT = (char)27 + "[32m <<"+(char)27 + "[0m ";
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		scanner = new Scanner(System.in);
		
		System.out.println(IN+"Nachfolgend werden sie aufgefordert die "+COLOR_YELLOW+"Matrix A"+COLOR_CLEAR+" einzugeben.");
		double[][] matrixA = matrixEinlesen();
		System.out.println(IN+"Nachfolgend werden sie aufgefordert die "+COLOR_YELLOW+" Matrix B"+COLOR_CLEAR+" einzugeben.");
		double[][] matrixB = matrixEinlesen();
		
		double[][] matrixSum = matrixSumme(matrixA, matrixB);
		double[][] matrixProduct = matrixProdukt(matrixA, matrixB);
		double[][] matrixTrans = matrixTransposition(matrixA);
		
		System.out.println(OUT+"Die Summe der Matrizen A und B ergibt die Matrix: ");
		matrixAusgeben(matrixSum);
		System.out.println(OUT+"Das Produkt der Matrizen A und B ergibt die Matrix: ");
		matrixAusgeben(matrixProduct);
		System.out.println(OUT+"Die Transposition der Matrix A ergibt die Matrix: ");
		matrixAusgeben(matrixTrans);
		
		scanner.close();
	}
	
	/**
	 * Diese Methode lässt den Benutzer eine Matrix eingeben.
	 * @return Matrix des Typs double[][].
	 */
	private static double[][] matrixEinlesen(){
		int n, m;
		System.out.println(IN+"Bitte geben sie die "+COLOR_YELLOW+" Anzahl der Zeilen (m)"+COLOR_CLEAR+" an: ");
		m = scanner.nextInt();
		System.out.println(IN+"Bitte geben sie die "+COLOR_YELLOW+" Anzahl der Spalten (n)"+COLOR_CLEAR+" an: ");
		n = scanner.nextInt();
		
		double[][] matrix = new double[m][n];
		//Get input
		//Zeilen
		for(int i = 0; i < m; i++){
			//Spalten der Zeile i
			for(int l = 0; l < n; l++){
				System.out.println(IN+"Bitte geben sie der Zeile "+COLOR_YELLOW+(i+1)+COLOR_CLEAR+" die Spalte "+COLOR_YELLOW+(l+1)+COLOR_CLEAR+" an: ");
				matrix[i][l] = scanner.nextDouble();
			}
		}
		
		System.out.println(OUT+"Ihre eingegebene Matrix sieht nun so aus: \n");
		
		//Approve	
		matrixAusgeben(matrix);
		
		return matrix;
	}
	
	/**
	 * Diese Methode gibt eine Matrix des Typs double[][] in der Kommando-Zeile aus.
	 * @param matrix Matrix des Typs double[][].
	 */
	private static void matrixAusgeben(double[][] matrix){
		int m = matrix.length,
			n = matrix[0].length;
		
		for(int i = 0; i < m; i++){
			for(int l = 0; l < n; l++){
				System.out.printf(OUT+COLOR_GREEN+"%5.2f ", matrix[i][l]);
			}
			System.out.println(COLOR_CLEAR);
		}
		System.out.println("---==============================---\n");
	}
	
	/**
	 * Diese Methode führt die komponentenweise Addition zweier Matrizen durch.
	 * @param matrixA Erste Matrix A
	 * @param matrixB Zweite Matrix B
	 * @return Eine Matrix vom Typ double[][], insofern die Matrizen A und B die gleiche Größe besitzen.
	 */
	private static double[][] matrixSumme(double[][] matrixA, double[][] matrixB){
		int m = matrixA.length,
			n = matrixA[0].length;
		
		if(matrixB.length != m || matrixB[0].length != n) {
			System.out.println(OUT+COLOR_RED+"Die Matrizen besitzen nicht die gleiche Spalten oder Zeilenzahl!"+COLOR_CLEAR);
			return null;
		}
		
		double[][] matrixRes = new double[m][n];
		
		for(int i = 0; i < m; i++){
			for(int l = 0; l < n; l++){
				matrixRes[i][l] = matrixA[i][l] + matrixB[i][l];
			}
		}		
		
		return matrixRes;
	}
	
	/**
	 * Diese Methode berechnet das Pordukt zweier Matrizen A und B mittels sum(k=1..p, a(ik)*b(kj));
	 * @param matrixA Erste Matrix A.
	 * @param matrixB Zweite Matrix B.
	 * @return Eine Matrix vom Typ double[][], insofern die Matrizen A und B die gleiche Größe besitzen.
	 */
	private static double[][] matrixProdukt(double[][] matrixA, double[][] matrixB){
		int m = matrixA.length,
			p = matrixA[0].length,
			n = matrixB[0].length;
		
		if(p != matrixB.length) {
			System.out.println(OUT+COLOR_RED+"Die Matrizen besitzen nicht die gleiche Spalten oder Zeilenzahl!"+COLOR_CLEAR);
			return null;
		}
		
		double[][] matrixRes = new double[m][n];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < p; k++){
					matrixRes[i][j] += matrixA[i][k]*matrixB[k][j];
				}
			}
		}
		
		return matrixRes;
	}
	
	/**
	 * Diese Matrix erstellt eine transponierte Matrix des Typs double[][].
	 * @param matrixA Eine Matrix des Typs double[][].
	 * @return Die Matrix A transponiert des Typs double[][].
	 */
	private static double[][] matrixTransposition(double[][] matrixA){
		int m = matrixA.length,
			n = matrixA[0].length;
		
		double[][] matrixRes = new double[n][m];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				matrixRes[j][i] = matrixA[i][j];
			}
		}
		
		return matrixRes;
	}
}
