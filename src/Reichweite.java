import java.util.*;

public class Reichweite {
	
	private static final String COLOR_CLEAR = (char)27 + "[0m";
	private static final String COLOR_YELLOW = (char)27 + "[33m";
	private static final String COLOR_RED = (char)27 + "[31m";
	private static final String COLOR_GREEN = (char)27 + "[32m";
	private static final String COLOR_CYAN = (char)27 + "[36m";
	
	private static final String IN = (char)27 + "[33m >>"+(char)27 + "[0m ";
	private static final String OUT = (char)27 + "[32m <<"+(char)27 + "[0m ";
	
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Eingabe
		System.out.println(IN+"Bitte geben sie die Anzahl der Tankfüllunge (k) als Ganzzahl an:");
		int k = sc.nextInt();
		
		System.out.println(IN+"Bitte geben sie den Verbrauch pro 100km (v) als Kommazahl an:");
		double v = sc.nextDouble();
		
		System.out.println(IN+"Bitte geben sie die Tankkapazität (c) als Kommazahl an:");
		double c = sc.nextDouble();
		
		System.out.println("\n");
		
		//Berechnen der Distanz von 1 bis k
		for(int i = 0; i < k; i++){
			System.out.println(OUT+"Bis zur "+COLOR_YELLOW+(i+1)+COLOR_CLEAR+". Station liegt eine Distanz von "+COLOR_GREEN+distanz(k-i, c, v)+COLOR_CLEAR+" Metern.");
		}
		
		System.out.println("\n");
		
		//Berechnen der Auszuladenden Stationen 1 bis k
		for(int i = 0; i < k; i++){
			System.out.println(OUT+"An der "+COLOR_YELLOW+(i+1)+COLOR_CLEAR+". Station werden "+COLOR_GREEN+ausladen(k-i, c, v)+COLOR_CLEAR+" Liter ausgeladen.");
		}
		
		//Berechnen gesamten Reichweite
		System.out.println("\n"+OUT+"Die Reichweite des Fahrzeuges betraegt "+COLOR_GREEN+reichweite(k, c, v)+COLOR_CLEAR+" Meter.");
		
		sc.close();
	}
	
	public static double distanz(int k, double c, double v){
		return (100*c/(2*k-1)*v)/100;
	}
	
	public static double ausladen(int k, double c, double v){
		double res = c-(2*v*distanz(k,c,v)/100);
		if(res < 0)
			res = 0;
		return res;
	}
	
	public static double reichweite(int k, double c, double v){
		if(k > 1)
			return distanz(k,c,v)+reichweite(k-1,c,v);
		if(k == 1)
			return 100*c/v;
		return -1;
	}
}
