import java.util.*;

class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3)
            return 0;
        
        Arrays.sort(num);
        int closest = num[0] + num[1] + num[num.length-1];
        for(int i = 0; i < num.length; i++)  {
            int head = i + 1;
            int tail = num.length - 1;
            while (true)    {
                if (head >= tail)
                    break;
                    
                int sum = num[i] + num[head] + num[tail];
                closest = (Math.abs(sum - target) < Math.abs(closest - target))? sum : closest;
                if (sum == target)
                    break;
                else if (sum > target)  {
                    tail--;
                    if (tail == i)
                        tail--;
                }   else    {
                    head++;
                    if (head == i)
                        head++;
                }
            }
        }
        return closest;
    }
}

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int [] num = {0,2,1,-3};
		int target = 1;
		System.out.println(solution.threeSumClosest(num, target));
	}
}
