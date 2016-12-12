public class Lotto {

    public static void main(String[] args){
        int bikomultchecksum = 0;       
        int divbikomult = bikomult(49, 6);
        for(int i = 1; i <= 6; i++){
            //TODO: bikomult(6, i)*bikomult(43, 6-i)/divbikomult;
        }
        
        int bikorekchecksum = 0;
        int divbikorek = bikorek(49, 6);
        for(int i = 1; i <= 6; i++){
            //TODO: bikorek(6, i)*bikorek(43, 6-1)/divbikorek;
        }
    }
    
    private static int bikomult(int n, int k){
        int product = 1;
        for  (int i = 1; i <= k; i++)[
            product*=((n+1-i)/i);
        }
    }
    
    private static int bikorek(int n, int k){
        //TODO: Check
        if(1 <= bikomult(n-1, k-1)+bikomult(n-1, k))
            return bikorek((n-1), (k-1));
        return 1;
    }

}
