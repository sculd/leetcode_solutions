import java.util.*;

public class GoogleValidateInput {
	static private boolean validate(String input, String pattern)	{
		Map<Character, Integer> patPos = new HashMap<Character, Integer>();
		int n = input.length();
		
		// construct the map for the pattern's position
		int m = pattern.length();
		for (int i = 0; i < m; i++)	{
			patPos.put(pattern.charAt(i), i);
		}
		
		int curPos = 0;
		for (int i = 0; i < n; i++)	{
			Integer pos = patPos.get(input.charAt(i));
			if (pos == null)
				;
			else if (pos < curPos)
				return false;
			else
				curPos = pos;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validate("awererbbbbbsdfscc", "abc"));
	}

}
