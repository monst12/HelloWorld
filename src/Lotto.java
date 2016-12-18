public class Lotto {

    public static void main(String[] args){
    	
    	double bikomultchecksum = 0;       
        double divbikomult = bikomult(49, 6);
        
        for(int k = 1; k <= 6; k++){  
        	double bikores = (double)(bikomult(6, k)*bikomult(43, 6-k))/divbikomult;
        	System.out.println("Mit der Wahrscheinlichkeit von "+bikores+" werden "+k+" von 6 richtigen gezogen.");
            bikomultchecksum += bikores;
        }
        
        System.out.println("\nChecksumme für Bikomult-Rechnung: "+bikomultchecksum+"\n");
        
        double bikorekchecksum = 0;
        double divbikorek = bikorek(49, 6);
        
        for(int k = 1; k <= 6; k++){
        	double bikores = (double)(bikorek(6, k)*bikorek(43, 6-k))/divbikorek;
            System.out.println("Mit der Wahrscheinlichkeit von "+bikores+" werden "+k+" von 6 richtigen gezogen.");
            bikorekchecksum += bikores;
        }
        
        System.out.println("\nChecksumme für Bikorek-Rechnung: "+bikorekchecksum);
    }
    
    private static int bikomult(int n, int k){
        int product = 1;
        for  (int i = 1; i <= k; i++){
            product*=((n+1-i)/i);
        }
        return product;
    }
    
    private static int bikorek(int n, int k){
        if(1 <= k && k <= n-1)
            return bikorek((n-1), (k-1))+bikorek((n-1), k);
        return 1;
    }

}
