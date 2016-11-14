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
        
        //
        
        double total = 1;
        //Additive Schleife
        for(int j = 1; j < N; j++){
            double curr = 1;
            //Multiplikative Schleife: x...x/N!
            for(int y = j; y >  0; y--){
                double yj = (double) x/y;
                curr*=yj;
            } 
            total+=curr; 
        }
        
        System.out.println("S(N="+N+", x="+x+") = "+total);
        
        //
        N = 0;
        double firsttotal = 1;
        double secondtotal = 1;
        for(int j = 1;j < 10; j++){
            double curr = 1;
            
            for(int y = j; y > 0; y--){
                double yj = (double) x/y;
                curr*=yj;
            }
            
            firsttotal+=curr;  
            double yj = (double) x/(j+1);
            curr*=yj;
            secondtotal = firsttotal+=curr;
            
            curr = 1;
            N++;
            
            System.out.println("1. total: "+firsttotal+" 2. total: "+secondtotal);
            double abs = Math.abs(firsttotal-secondtotal);
            System.out.println("abs "+abs);
            if(abs <= 10e-13)
                break;
        }
        sc.close();
    } 
}
