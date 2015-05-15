import java.util.*;

class Solution {
    public int sqrt(int x) {
    	if (x == 0)
    		return 0;
        if (x <= 3)
            return 1;
        if (x <= 8)
            return 2;
        
        /*
        // not working for input of x = 2147395599
        int digit = 1;
        int prod = 1;
        while (true)    {
            if (prod * 10 > x)
                break;
            
            prod *= 10;
            digit += 1;
        }
        
        int left = 1;
        for (int i = 0; i < (digit - 1) / 2; i++)
            left *= 10;
        */
            
        int left = 1;
        int right = x / 2;
        
        while (true)    {
            if (left >= right -1)
                return left;
            
            int mid = (left + right) / 2;
            
            long sq = (long)mid * (long)mid;
            
            if (sq > x)
                right = mid;
            else
                left = mid;
        }
    }
}

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.sqrt(2147395599));
	}

}
