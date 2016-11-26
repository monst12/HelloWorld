import java.util.*;

public class Vektorrechnung{
    
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        double[] x;
        double[] y;
        double r = 0;
        
        //Collect input
        System.out.println("Bitte geben sie die "+(char) 27+"[33mGröße der Vektoren"+(char)27+"[0m an (Ganzzahl):");
        int n = sc.nextInt();
        
        //Init fields
        x = new double[n];
        y = new double[n];
        
        //Wait for Input...
        int in = 0;
        for(int i = 0; i < n; i++){
            System.out.println("Bitte geben sie das Feld "+(i+1)+" des Vektors "+(char) 27+"[33mx"+(char)27+"[0m an:");
            in = sc.nextInt();
            x[i] = in;
        }
        
        for(int i = 0; i < n; i++){
            System.out.println("Bitte geben sie das Feld "+(i+1)+" des Vektors "+(char) 27+"[33my"+(char)27+"[0m an:");
            in = sc.nextInt();
            y[i] = in;
        }
        
        //Execute 
        sumVectors(x, y);
        subtractVectors(x, y);
        divideVectors(x, y);
        multiplicateVectors(x, y);
        
        System.out.println("Bitte geben sie eine "+(char)27+"[33m(Komma-)Zahl"+(char)27+"[0m zur skalaren Multplikation ein:");
        r = sc.nextDouble();
        
        multiscalarVector(x, y, r);
        scalarVectors(x, y);
        
        sc.close();
    }
    
    private static void sumVectors(double[] x, double[] y){
        double[] local = new double[x.length];
        for(int i = 0; i < x.length; i++){
            local[i] = x[i]+y[i];
        } 
        
        System.out.println("Die Summe der Vektoren x und y ergibt den Vektor: "+(char)27+"[32m"+Arrays.toString(local)+"\n"+(char)27+"[0m");
    }
    
    private static void subtractVectors(double[] x, double[] y){
        double[] local = new double[x.length];
        for(int i = 0; i < x.length; i++){
            local[i] = x[i]-y[i];
        } 
        
        System.out.println("Die Subtraktion der Vektoren x und y ergibt den Vektor: "+(char)27+"[32m"+Arrays.toString(local)+"\n"+(char)27+"[0m"); 
    }
    
    /**
    * Check not 0 -> throw Exception.
    */
    private static void divideVectors(double[] x, double[] y){
        double[] local = new double[x.length];
        for(int i = 0; i < x.length; i++){
            if(y[i] == 0){
                System.out.println((char)27+"[31mFehler: Das Feld "+(i+1)+" des Vektors y ist 0! ("+x[i]+"/0)\n"+(char)27+"[0m");
                return;
            }
            
            local[i] = x[i]/y[i];
        } 
        
        System.out.println("Die Division der Vektoren x und y ergibt den Vektor: "+(char)27+"[32m"+Arrays.toString(local)+"\n"+(char)27+"[0m");
    }
    
    private static void multiplicateVectors(double[] x, double[] y){
        double[] local = new double[x.length];
        for(int i = 0; i < x.length; i++){
            local[i] = x[i]*y[i];
        } 
        
        System.out.println("Die Multiplikation der Vektoren x und y ergibt den Vektor: "+(char)27+"[32m"+Arrays.toString(local)+"\n"+(char)27+"[0m"); 
    }
    
    private static void multiscalarVector(double[] x, double[] y, double r){
        double[] localx = new double[x.length];
        double[] localy = new double[y.length];
        
        for(int i = 0; i < x.length; i++){
            localx[i] = x[i]*r;
        } 
        
        for(int i = 0; i < y.length; i++){
            localy[i] = y[i]*r;
        } 
        
        System.out.println("Die Skalare Multiplikation des Vektors x ergibt den Vektor: "+(char)27+"[32m"+Arrays.toString(localx)+"\n"+(char)27+"[0m"); 
        System.out.println("Die Skalare Multiplikation des Vektors y ergibt den Vektor: "+(char)27+"[32m"+Arrays.toString(localy)+"\n"+(char)27+"[0m");
    }
    
    /**
    * "Returns" double.
    */
    private static void scalarVectors(double[] x, double[] y){
        double local = 0;
        
        for(int i = 0; i < x.length; i++){
        	local += x[i]*y[i];
        }
        
        System.out.println("Das Skalarprodukt der Vektoren x und y ergibt: "+(char)27+"[32m"+local+(char)27+"[0m\n");         
    }

}
