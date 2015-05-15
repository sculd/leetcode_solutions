import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int [] result = new int[2];
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(numbers[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            Integer mapped = map.get(target - numbers[i]);
            if (mapped != null && mapped != i) {
                result[0] = i + 1;
                result[1] = mapped + 1;
                break;
            }
        }
        
        return result;
    }
}

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
