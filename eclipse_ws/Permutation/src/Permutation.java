import java.util.*;

class Solution {
    private void swap(int[] num, int i, int j)  {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    private void run(List<List<Integer>> result, int[] num, int pos)    {
        int n = num.length;
        if (pos == n) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++)
                list.add(num[i]);
            result.add(list);
        } else {
            for (int i = pos; i < n; i++)   {
                swap(num, pos, i);
                run(result, num, pos + 1);
                // recover
                swap(num, pos, i);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        run(result, num, 0);
        return result;
    }
}

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
