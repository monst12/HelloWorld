package com.github.monst12;

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
		double up = this.n+1.0;
		//log(a)+...+log(i) = log(a*...*i)
		for(double i = 1; i <= this.k; i++){
		        //n+1/i - 1
			log *= ((up/i)-1.0);
			System.out.println(log);
		}

		return Math.log(log);
	}
	
	public double wert(){
		if(fehler())
			return 0;
		
		double binkoeff = this.logBinKoeffizient();	
		System.out.println("binkoeff "+binkoeff);
		
		//log(p^k) = k*log(p)
		double firstmulti = (double) this.k*Math.log(this.p);
		System.out.println("firstmulti "+firstmulti);
		
		//log((1-p)^(n-k)) = (n-k)*log(1-p)
		double secondmulti = (double) (this.n-this.k)*Math.log(1.0-this.p);
		System.out.println("secondmulti "+secondmulti);
				
		//log(a)*log(b)*log(c) = log(a+b+c)
		return Math.exp(binkoeff)*Math.exp(firstmulti)*Math.exp(secondmulti);
	}
	
	public double erwartungswert(){
		return fehler() ? 0 : this.n*this.p;
	}
}
