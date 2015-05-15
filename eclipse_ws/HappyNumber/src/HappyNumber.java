import java.util.*;

class Solution {
    int sumDigits(int n)    {
        int sum = 0;
        while (n != 0)  {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        
        while (true)    {
            set.add(n);
            int sum = sumDigits(n);
            if (sum == 1)
                return true;
            else if (set.contains(sum))
                return false;
            n = sum;
        }
    }
}

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
