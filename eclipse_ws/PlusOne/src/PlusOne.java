import java.util.*;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for (int d = digits.length - 1; d >= 0; d--)    {
            int newD = carry + digits[d];
            carry = newD / 10;
            digits[d] = newD % 10;
            
            if (carry == 0)
                break;
        }
        
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int d = 0; d < digits.length; d++)
                result[d + 1] = 0;
            return result;
        } else
            return digits;
    }
}

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
