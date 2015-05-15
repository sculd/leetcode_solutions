class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return (s.charAt(0) == '0')? 0 : 1;
            
        int[] nums = new int[s.length()];
        
        nums[0] = (s.charAt(0) == '0')? 0 : 1;
        for (int i = 1; i < s.length(); i++)    {
            if (s.charAt(i) != '0')
                nums[i] += nums[i-1];
            if (s.charAt(i-1) != '0' && Integer.valueOf(s.substring(i-1,i+1)) <= 26)
                nums[i] += (i == 1)? 1 : nums[i-2];
        }
        
        return nums[s.length()-1];
    }
}

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
