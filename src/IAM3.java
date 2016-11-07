import java.util.*;
import java.io.File;
import java.io.FileWriter;

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
        
        double result = S(x, N);
        
        System.out.println("--==================================--\n");
        System.out.println("S(N) = "+result+"\n");
        sc.close();
    }
    
    private static double S(double x, int max)throws Exception{
        double total = 0;
        File file = new File("log.txt");
        if(!file.exists())
            file.createNewFile();
        
        FileWriter writer = new FileWriter(file);    
        
        for(int j = 0; j < max; j++){
            double curr = 1;
            for(int y = j; y > 0; y--){
                double yj = (double) x/j;
                curr*=yj;
            }
            
            total+=curr; 
            writer.write("Total (at step "+j+") : "+total+"\n");    
        }
        
        writer.flush();
        writer.close();
        return total;
    }  
}
