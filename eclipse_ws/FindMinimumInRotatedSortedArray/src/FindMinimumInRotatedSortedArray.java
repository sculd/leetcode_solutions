class Solution {
    public int findMin(int[] num) {
        int head = 0;
        int tail = num.length;
        if (tail == 0)
            return 0;
        else if (tail == 1)
            return num[0];

        while (true)    {
            if (head == tail)   
                return num[head];
            
            if (num[head] <= num[tail-1])
                return num[head];
            
            int m = (head + tail) / 2;
            if (num[m-1] > num[m])   {
                return num[m];
            }
            
            if (num[head] > num[m]) {
                tail = m;
            } else {
                head = m+1;
            }
        }
    }
}

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
