import java.util.*;

public class Exponential{
    
    public static void main(String[] args)throws Exception{
        Locale.setDefault(Locale.US);
        double x;
        int N;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Bitte geben Sie eine (Komma-)Zahl als Stelle von x ein.");       
        x = sc.nextDouble(); //x Variable
        
        System.out.println("Bitte geben Sie eine ganze Zahl als Summationsgrenze N ein.");
        N = sc.nextInt(); //Summationsgrenze
        System.out.println("\n");
        
        limExp(N, x);
        compare(x);
        exp(x);
        
        sc.close();
    } 
    
    public static void limExp(int N, double x){
        double total = 1;
        double rx = Math.abs(x);
        //Additive Schleife
        for(int j = 1; j < N; j++){
            double curr = 1;
            //Multiplikative Schleife: x...x/N!
            for(int y = j; y >  0; y--){
                double yj = (double) rx/y;
                curr*=yj;
            } 
            total+=curr; 
        }
        
        if(x < 0){
        	total = 1.0/total;
        }
        
        System.out.println("S(N="+N+", x="+x+") = "+total);
        System.out.println("--======================================--\n");
    }
    
    public static void compare(double x){
        double rx = Math.abs(x);
        int N = 1;
        double firsttotal = 1;
        double sectotal = 1;

    	for(;;){
            //Additive Schleife 1
            for(int j = 1; j < N; j++){
                double curr = 1;
                //Multiplikative Schleife: x...x/N!
                for(int y = j; y >  0; y--){
                    double yj = (double) rx/y;
                    curr*=yj;
                } 
                firsttotal+=curr; 
            }
            
            //Inkrement
            N++;
            
            //Additive Schleife 1
            for(int j = 1; j < N; j++){
                double curr = 1;
                //Multiplikative Schleife: x...x/N!
                for(int y = j; y >  0; y--){
                    double yj = (double) rx/y;
                    curr*=yj;
                } 
                sectotal+=curr; 
            }
            
            double abs = Math.abs(firsttotal-sectotal);

            if(abs <= 10e-13)
            	break;
            
            firsttotal = 1;
            sectotal = 1;
    	}
    	
    	System.out.println("Benötigte Summationen N: "+N);
    	System.out.println("--======================================--\n");
    }
    
    public static void exp(double x){
    	System.out.println("Math.exp(x) "+Math.exp(x));
        System.out.println("--======================================--");
    }
}
