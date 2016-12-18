import java.util.Locale;
import java.util.Scanner;


public class Reichweite {
	
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Eingabe
		System.out.println("Bitte geben sie die Anzahl der Tankfüllunge (k) als Ganzzahl an:");
		int k = sc.nextInt();
		
		System.out.println("Bitte geben sie den Verbrauch pro 100km (v) als Kommazahl an:");
		double v = sc.nextDouble();
		
		System.out.println("Bitte geben sie die Tankkapazität (c) als Kommazahl an:");
		double c = sc.nextDouble();
		
		//Berechnen der Distanz von 1 bis k
		for(int i = 1; i <= k; i++){
			System.out.println("Bis zur "+i+". Station liegt eine Distanz von "+distanz(i, c, v)+" Metern.");
		}
		
		//Berechnen der Auszuladenden Stationen 1 bis k
		for(int i = 1; i <= k; i++){
			System.out.println("An der "+i+". Station werden "+ausladen(i, c, v)+" ausgeladen.");
		}
		
		//Berechnen gesamten Reichweite
		System.out.println("Die Reichweite des Fahrzeuges betraegt "+reichweite(k, c, v)+" Metern.");
		
		sc.close();
	}
	
	public static double distanz(int k, double c, double v){
		return 100*c/(2*k-1)*v;
	}
	
	public static double ausladen(int k, double c, double v){
		return c-(2*v*distanz(k,c,v)/100);
	}
	
	public static double reichweite(int k, double c, double v){
		if(k > 1)
			return distanz(k,c,v)+reichweite(k-1,c,v);
		if(k == 1)
			return 100*c/v;
		return -1;
	}
}
