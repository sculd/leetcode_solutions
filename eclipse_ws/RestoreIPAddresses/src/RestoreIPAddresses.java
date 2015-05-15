import java.util.*;

class Solution {
    private void restore(String rest, String[] tuples, int tuple, List<String> restores)   {
        for (int len = 1; len <= 3; len++)  {
            if (len > rest.length())
                break;
            if (len > 1 && rest.charAt(0) == '0')
                break;
            
            String newTuple = rest.substring(0, len);
            if (Integer.valueOf(newTuple) > 255)
                continue;

            tuples[tuple] = newTuple;
            
            if (tuple == 3 && rest.length() == len) {
                String ip = "";
                for (int t = 0; t < 4; t++) {
                    ip += tuples[t];
                    if (t < 3)
                        ip += ".";
                }
                restores.add(ip);
            } else if (tuple < 3)
                restore(rest.substring(len), tuples, tuple + 1, restores);        
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> restores = new ArrayList<String>();
        String[] tuples = new String[4];
        restore(s, tuples, 0, restores);
        
        return restores;
    }
}

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		List<String> result = solution.restoreIpAddresses("010010");
		for (String ip: result)
			System.out.println(ip);
	}

}
