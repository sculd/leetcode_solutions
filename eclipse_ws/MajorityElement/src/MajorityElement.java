import java.util.*;

class Solution {
    public int majorityElement(int[] num) {
        int n = num.length;
        
        Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < n; i++)  {
            Integer frequency = frequencies.get(num[i]);
            int freq = 0;
            if (frequency != null)
                freq = frequency;
            
            if (freq + (n-i-1) < n/2 && frequency != null)   {
                frequencies.remove(num[i]);
            } else {
                frequencies.put(num[i], freq + 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry: frequencies.entrySet()) {
            int freq = entry.getValue();
            if (freq > n/2) {
                return entry.getKey();
            }
        }
        
        return 0;
    }
}

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
