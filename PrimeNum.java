class PrimeNum {
    public static boolean isPrime(int n){
        if (n <= 1)
            return false;
        
       for(int i=2;i<n;i++){
           if(n%i==0) return false;
       }

           return true;
           
    }
    public  static boolean checkPerfixPrime(int n){
       while(n>0){
        if(!isPrime(n))
           return false;
           n/=10;
        }
       
       
      return true;

       
    
    }
    public static boolean checkSuffixPrime(int n){
        boolean flag=false;
      int  div=10;
        
        while(div<=n){
            int suff=n%div;
            if(!isPrime(suff)) return false;
            div*=10;
           
        }
       

        return true;
    }
    public boolean completePrime(int num) {
        if(num/10==0){
            if(isPrime(num)) return true;

        }
        if(checkPerfixPrime(num)==true &&   checkSuffixPrime(num)==true)
            return true;

        return false;
    }
    public static void main(String[] args) {
    PrimeNum sol = new PrimeNum();

    int num1 = 28;
    int num2 =39;
    int num3 = 23;

    System.out.println(num1 + " -> " + sol.completePrime(num1)); // expected true
    System.out.println(num2 + " -> " + sol.completePrime(num2)); // expected false
    System.out.println(num3 + " -> " + sol.completePrime(num3)); // expected true
}
}
