import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        
        int [] candies = new int[n];
        candies[n-1] = 1;
        int result = 1;
        
        for (int i = n - 2; i >= 0; i--)    {
            if (ratings[i] > ratings[i+1])  {
                candies[i] = candies[i + 1] + 1;
                result += candies[i];
            } else {
                candies[i] = 1;
                result += candies[i];
                
                int j = i + 1;
                while (j < n && candies[j] == candies[j-1])  {
                    candies[j] += 1;
                    result += 1;
                    j += 1;
                }
            }
        }
        
        return result;
    }
}

public class Candy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int []ratings = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(solution.candy(ratings));
	}

}
