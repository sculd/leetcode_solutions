class Solution {
    public int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();

        // compare level by level
        boolean if1done = false;
        boolean if2done = false;
        
        while(true) {
            int val1;
            if (if1done)
                val1 = 0;
            else {
                int end1 = version1.indexOf('.');
                if (end1 == -1) {
                    val1 = Integer.valueOf(version1);
                    if1done = true;
                } else  {
                    val1 = Integer.valueOf(version1.substring(0, end1));
                    version1 = version1.substring(end1 + 1);
                    n -= end1 + 1;
                }
            }
                
            int val2;
            if (if2done)
                val2 = 0;
            else {
                int end2 = version2.indexOf('.');
                if (end2 == -1)
                    val2 = Integer.valueOf(version2);
                if (end2 == -1) {
                    val2 = Integer.valueOf(version2);
                    if2done = true;
                } else {
                    val2 = Integer.valueOf(version2.substring(0, end2));
                    version2 = version2.substring(end2 + 1);
                    n -= end2 + 1;
                }
            }
            
            
            if (val1 > val2)
                return 1;
            else if (val1 < val2)
                return -1;
            else if (if1done && if2done)
                return 0;
        }
    }
}

public class CompareVersionNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
