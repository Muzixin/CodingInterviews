package questions;

public class Q16 {
	public double Power(double base, int exponent) {
        Double a = new Double(base);
        Double b = new Double(0.0);
        if(a.compareTo(b)==0 && exponent<0)
            return 0;
        int unsigned = exponent;
        if(exponent<0)
            unsigned = -exponent;
        double result = PowerWithUnsigned(base, unsigned);
        if(exponent < 0)
            result = 1/result;
        return result;
    }
    
    private double PowerWithUnsigned(double base, int unsigned){
        if(unsigned == 0)
            return 1;
        if(unsigned == 1)
            return base;
        double result = PowerWithUnsigned(base, unsigned >> 1);
        result *= result;
        if((unsigned & 1) == 1)
            result *= base;
        return result;
    }
    
    public static void main(String[] args){
    	Q16 q = new Q16();
    	System.out.println(q.Power(2.0, 3));
    }
}

