class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0)
            sign = -1;
        String str = String.valueOf(x);
        String rev = "";
        
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (i == 0 && sign == -1)
                continue;
            rev = String.valueOf(str.charAt(i)) + rev;
        }
        
        long revVal = Long.valueOf(rev);
        revVal *= sign;
        
        if (revVal > Integer.MAX_VALUE || revVal < Integer.MIN_VALUE)
            return 0;
        else
            return (int)revVal;
    }
}

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
