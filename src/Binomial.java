
import java.util.*;

public class Binomial {
	
	private int n;
	private int k;
	private double p;
	
	public Binomial(int n, int k, double p) {
		this.n = n;
		this.k = k;
		this.p = p;
	}
	
	private boolean fehler(){
		if(n <= 0 || k <= 0 || k > n || p < 0 || p > 1){
			System.err.println(ConsoleColor.COLOR_RED+" << Fehler: Ein Fehler ist aufgetreten!"+ConsoleColor.COLOR_CLEAR);
			//FEHLER
			return true;
		}
		//KEIN FEHLER
		return false;
	}
	
	private double logBinKoeffizient(){
		double log = 1;
		for(double i = 1; i < this.k; i++){
			log *= ((this.n+1/i)-1);
		}

		return Math.log(log);
	}
	
	public double wert(){
		if(fehler())
			return 0;
		
		double result;
		double binkoeff = this.logBinKoeffizient();	
		System.out.println("binkoeff "+binkoeff);
		
		double firstmulti = this.k*Math.log(this.p);
		System.out.println("firstmulti "+firstmulti);
		
		double secondmulti = (this.n-this.k)*Math.log(1-this.p);
		System.out.println("secondmulti "+secondmulti);
		
		result = Math.exp(binkoeff)*Math.exp(firstmulti)*Math.exp(secondmulti);
		System.out.println("result1 "+result);
		
		//log(a)*log(b)*log(c)
		result = Math.exp(binkoeff*firstmulti*secondmulti);

		return result;
	}
	
	public double erwartungswert(){
		if(fehler())
			return 0;
		//return fehler() ? 0 : this.n*this.p;
		return this.n*this.p;
	}
}
