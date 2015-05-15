class Solution {
    public int rob(int[] num) {
        if (num.length == 0) return 0;
        
        int[] rewards = new int[num.length + 1];
        rewards[0] = 0; // dummy
        rewards[1] = num[0];
        for (int i = 2; i <= num.length; i++)    {
            rewards[i] = Math.max(num[i-1] + rewards[i-2], rewards[i-1]);
        }
        
        return rewards[num.length];
    }
}

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
