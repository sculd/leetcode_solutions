class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        long base = 5;
        while (true)    {
            if (base > (long)n)
                break;
            result += n / base;
            base *= 5;
        }
        
        return result;
    }
}

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
