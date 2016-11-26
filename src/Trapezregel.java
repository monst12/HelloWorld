import java.util.Locale;


public class Trapezregel {

	public static void main(String[] args) {	
		Locale.setDefault(Locale.US);
	}
	
	public static double f(double x){
		if(x <= -1) {
			System.out.println("Fehler: Die angegebene Zahl für x ist kleiner gleich -1!");
			System.exit(1);
			return 0;
		}		
		return Math.exp(x)*(1.0/Math.sqrt(1+(x*x*x)));
	}
	
	public static double trapez(double a, double b, int n){
		double h = (b-a)/n;
		double result = 0;
		double sum = f(a);
		
		for(int i = 1; i < n; i++){
			double xi = a+h*i;
			sum+=2*(f(xi));
		}	
		
		sum+=f((a+h*n));
		
		result = (h/2.0)*sum;
		
		return result;
	}

}
