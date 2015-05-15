class Solution {
    private String[] romans = {"M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I"};
    private int[] bases = {1000, 900, 500, 100, 90, 50, 10, 9, 5, 1};
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        
        int b = 0;
        while (true)    {
            int r = num / bases[b];
            if (r == 0 && str.length() == 0) {

            } else  { 
                if (r == 4) {
                    str.append(romans[b]);
                    str.append(romans[b-1]);
                    num -= 4 * bases[b];
                } else {
                    for (int i = 0; i < r; i++) {
                        str.append(romans[b]);
                        num -= bases[b];
                    }
                }
            }
            if (num == 0)
                break;
            b++;
        }
        
        return str.toString();
    }
}

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((new Solution()).intToRoman(19));
	}

}
