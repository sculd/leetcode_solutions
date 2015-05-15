import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int n = num.length;
        if (n == 0) return result;
        
        // build the map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prev = num[0] - 1;
        for (int i = 0; i < n; i++) {
            map.put(num[i], i);
            prev = num[i];
        }
        
        int prevI = num[0] - 1;
        for (int i = 0; i < n; i++) {
        	if (num[i] == prevI) continue;
        	prevI = num[i];
        	
        	int prevJ = num[0] - 1;
            for (int j = i + 1; j < n; j++) {
            	if (num[j] == prevJ) continue;
            	prevJ = num[j];
            	
            	int twoSum = num[i] + num[j];
                Integer remainderIndex = map.get(0 - twoSum);
                if (remainderIndex != null && remainderIndex > i && remainderIndex > j) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[remainderIndex]);
                    Collections.sort(list);
                    result.add(list);
                }
            }
        }
        
        return result;
    }
}

public class Three3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		//int []num = {-1, 0, 1, 2, -1, -4};
		int []num = {0, 0, 0};
		List<List<Integer>> result = solution.threeSum(num);
		for (List<Integer> list : result)
			System.out.println(list);
	}

}
