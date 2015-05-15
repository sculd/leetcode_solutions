import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (n == 0) {
            result.add(0);
            return result;
        }
            
        if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }

        List<Integer> tmp = grayCode(n-1);
        for (int val: tmp)  {
            result.add(val);
        }
        
        int leadBit = 1 << (n-1);
        for (int i = tmp.size()-1; i >= 0; i--) {
            result.add(leadBit | tmp.get(i));
        }
        
        return result;
    }
}

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
