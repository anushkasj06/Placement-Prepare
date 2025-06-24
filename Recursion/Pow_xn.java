
public class Pow_xn {
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
           x = (double)1/x ;
           N = Math.abs(N);
        } 
        return helper(x, N);
    }

    private double helper(double x, long n){
        if(n==0) return 1;
        if(n%2==0){
            double res = helper(x, n/2);
            return res*res;
        }
        return x * helper(x, n-1);
    }
}
