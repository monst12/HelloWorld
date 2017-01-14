
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
			System.err.println("Ein Fehler ist aufgetreten!");
			//FEHLER
			return true;
		}
		//KEIN FEHLER
		return false;
	}
	
	private double logBinKoeffizient(){
		double log = 0;
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
		double firstmulti = this.k*Math.log(this.p);
		double secondmulti = (this.n-this.k)*Math.log(1-this.p);
		
		result = Math.exp(binkoeff*firstmulti*secondmulti);
		return result;
	}
	
	public double erwartungswert(){
		if(fehler())
			return 0;		
		return this.n*this.p;
	}
	
	
	
	

}
