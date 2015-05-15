class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        int base = 1;
        int d = 0;
        while (true)    {
            rev |= ((n & base) != 0)? 1:0;
            d += 1;
            if (d >= 32) break;
            base = base << 1;
            rev = rev << 1;
        }
        
        return rev;
    }
}

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
