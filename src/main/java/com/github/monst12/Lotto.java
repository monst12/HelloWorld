package com.github.monst12;

public class Lotto {

    //Output-Dekoration
	private static final String COLOR_CLEAR = (char)27 + "[0m";
	private static final String COLOR_YELLOW = (char)27 + "[33m";
	private static final String COLOR_RED = (char)27 + "[31m";
	private static final String COLOR_GREEN = (char)27 + "[32m";
	private static final String COLOR_CYAN = (char)27 + "[36m";
	
	private static final String OUT = (char)27 + "[32m <<"+(char)27 + "[0m ";
	
	/**
	* main
	*/
    public static void main(String[] args){
    	
    	//Checksumme und Divisor für Multiplikativeberechnung
    	double bikomultchecksum = 0;       
        double divbikomult = bikomult(49, 6);
        
        //Berechnen für 0 bis 6 Treffer
        for(int k = 0; k <= 6; k++){  
        //Ausführen von w(k)
        	double bikores = (bikomult(6, k)*bikomult(43, 6-k))/divbikomult;
        	System.out.println(OUT+"Mit der Wahrscheinlichkeit von "+COLOR_CYAN+bikores+COLOR_CLEAR+" werden "+k+" von 6 richtigen gezogen.");
        	//Checksumme erhöhen
            bikomultchecksum += bikores;
        }
        
        System.out.println("\n"+OUT+"Checksumme für Bikomult-Rechnung: "+COLOR_YELLOW+bikomultchecksum+"\n"+COLOR_CLEAR);
        
        //Checksumme und Dvisior für Rekursionsberechnung
        double bikorekchecksum = 0;
        double divbikorek = bikorek(49, 6);
        
        //Berechnen für 0 bis 6 Treffer
        for(int k = 0; k <= 6; k++){
        //Ausführen von w(k)
        	double bikores = (bikorek(6, k)*bikorek(43, 6-k))/divbikorek;
        	
            System.out.println(OUT+"Mit der Wahrscheinlichkeit von "+COLOR_CYAN+bikores+COLOR_CLEAR+" werden "+k+" von 6 richtigen gezogen.");
            //Checksumme erhöhen
            bikorekchecksum += bikores;
        }
        
        System.out.println("\n"+OUT+"Checksumme für Bikorek-Rechnung: "+COLOR_YELLOW+bikorekchecksum+COLOR_CLEAR);
    }
    
    /**
    * Berechnet (n über k) mutiplikativ
    */
    private static double bikomult(int n, int k){
    //Produkt = 1
        double product = 1;       
        //Produkt von (n+1-1/i) von 1 bis k
        for  (double i = 1; i <= k; i++){
            product *=((n+1-i)/i);
        }
        //Rückgabe des Produktes
        return product;
    }
    
    /**
    * Berechnet (n über k) rekursiv
    */
    private static int bikorek(int n, int k){
    //Fall 1: 1 <= k <= n-1
        if(1 <= k && k <= n-1){
            //Rückgabe von (n-1 über k-1) + (n-1 über k)
            return bikorek((n-1), (k-1))+bikorek((n-1), k);
        }     
            //Ansonsten Rückgabe von 1
        return 1;
    }

}
