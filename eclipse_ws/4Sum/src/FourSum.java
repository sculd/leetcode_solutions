import java.util.*;

class Solution {
    List<List<Integer>> twoSum(int start, int[] num, int target) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        
        if (2 > num.length - start)	{
        	return ll;
        }
        int head = start;
        int tail = num.length - 1;
        while (true){
        	if (head >= tail)
        		break;
        	
        	int sum = num[head] + num[tail]; 
        	if (sum == target)	{
        		List<Integer> l = new ArrayList<Integer>();
        		l.add(num[head]);
        		l.add(num[tail]);
        		ll.add(l);
        	}
        		
        	if (sum < target || sum == target)	{
            	head += 1;
            	while (head < num.length && num[head] == num[head-1])
            		head += 1;
        	} else if (sum > target || sum == target) {
            	tail -= 1;
            	while (tail >= 0 && num[tail] == num[tail+1])
            		tail -= 1;
        	}
        }
        
        return ll;
    }
    
    List<List<Integer>> nSum(int start, int[] num, int n, int target) {
    	if (n == 2)
    		return twoSum(start, num, target);

        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if (n > num.length - start)	{
        	return ll;
        }
        
        for (int i = start; i < num.length; i++)    {
        	if (num[i] >= 0 && num[i] > target)	
        		break;
        	
        	if (i > start && num[i-1] == num[i])
        	    continue;
            
            // append it to the smaller sums
            List<List<Integer>> tll = nSum(i + 1, num, n - 1, target - num[i]);
            
            for (List<Integer> tl : tll)    {
                List<Integer> l = new ArrayList<Integer>();
                l.add(num[i]);
                // append the result from the smaller sums
                for (int val : tl)
                    l.add(val);
                ll.add(l);
            }
        }
        return ll;
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        return nSum(0, num, 4, target);
    }
}

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		//int[] num = {-2, -1, 0, 0, 1, 2};
		//int[] num = {-497,-480,-477,-470,-452,-448,-440,-412,-390,-381,-372,-372,-369,-366,-355,-346,-340,-337,-322,-321,-311,-296,-258,-249,-248,-232,-215,-199,-174,-154,-128,-122,-122,-117,-115,-113,-110,-89,-86,-84,-78,-71,-69,-53,-49,-35,-25,-21,-7,3,7,21,25,30,47,52,81,84,87,91,96,157,161,167,178,184,210,217,228,236,274,277,283,286,290,301,302,341,352,354,361,367,384,390,412,421,458,468,483,484,486,487,490,491};
		int[] num = {-5,-4,-3,-2,1,3,3,5}; 
		//int target = 0;
		//int target = 8377;
		int target = -11;
		List<List<Integer>> ll = sol.fourSum(num, target);
		//List<List<Integer>> ll = sol.nSum(0, num, 3, target);
		System.out.println(ll);
	}
}
