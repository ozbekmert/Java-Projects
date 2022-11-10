public class NewClass {
    public static void main(String[] args) 
    {
//        int x= Integer.parseInt(args[0]); // get user data from console in runtime
        int x = 4;
        // loop starts i=1 not 0 because we already added 1 initially therefore we do not need to add extra '1' to sum.
        //calculate e
        long e = 2;
        int maxDenominator = 20;
        for(int i = 2; i < maxDenominator ; i++)  
        {
            e += 1/factorial(i);
        }
        
        //Calulate e power x
        
        double e_pow_x=1+x;
        for(int i = 2; i < maxDenominator ; i++)  
        {
                 e_pow_x += Math.pow(x, i)/factorial(i);
        }
        
        System.out.println("e=" + e);
        System.out.println("e power x= "+ e_pow_x);
        double build_in = Math.pow(Math.E, x);
        System.out.println("build in Math.exp result= " + build_in);
        double diff = Math.abs(e_pow_x -build_in);
        System.out.println("Difference is = " + diff);
   
        
    }
    public static long factorial(int n) 
    {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    
    
}
