/*Implement pow(x, n).

Hide Company Tags LinkedIn Google Bloomberg Facebook
Hide Tags Binary Search Math
Hide Similar Problems (M) Sqrt(x)
 */
public class Pow50 {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;

		if (n < 0)
			return 1 / helper(x, -n);
		else
			return helper(x, n);
	}

	public double helper(double x, int n) {
		if (n == 0)
			return 1;
		double temp = helper(x, n / 2);
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			return temp * temp * x;
		}
	}
	
	
/*	public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            if (n > 0)
                return x * myPow(x, n - 1);
            else
                return 1 / x * myPow(x, n + 1);
        }
    }
	
	
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            x = 1 / x;
        }
        double ans = 1;
        while(n != 0){
            if((n % 2) != 0) {
                ans = ans * x;
            }
            x = x * x;
            n = n / 2;
        }
        return ans;
    }*/
}
