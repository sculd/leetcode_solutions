import java.util.*;

class Solution {
    public double pow(double x, int n) {
        if (n < 0)  {
            n *= -1;
            x = 1/x;
        }
        double result = 1;
        double f = x;
        for (int d = 0; d < 31; d++)    {
            int masked = (n >> d) & 1;
            if (masked != 0)
                result *= f;
            
            f = f * f;
        }

        return result;
    }
}

public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
