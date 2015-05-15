class Solution {
	//Given a current price and days to maturity, return a rate of return, all doubles.
	public double getRateOfReturn(double currentPrice, double daysToMaturity) {
	    //Please Implement this
	    
	    double ret_maturity = 100 / currentPrice;
	    return Math.pow(ret_maturity, (double)365 / daysToMaturity);
	}	
}

public class RateOfReturnOnBond {
	/*
	 * The US government offers to sell you a $100, zero coupon treasury bond at 95.50. 
	 * The bond will come to maturity in 153 days. 
	 * Write a program that calculates rate of return on a $100 treasury bond 
	 * given its current price and days to maturity.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
