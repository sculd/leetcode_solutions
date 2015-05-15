class Solution {
    private StringBuilder str = new StringBuilder();
    
    private void addLevel(String dir)   {
        if (dir.length() > 0)
            str.append(dir);
        str.append('/');
    }
    
    private void lowerLevel()   {
        int start = str.length() - 1;
        if (str.charAt(start) == '/')
            start--;
            
        while (start > 0 && str.charAt(start-1) != '/')
            start--;

        str.delete(start, str.length());
    }
    
    public String simplifyPath(String path) {
        //if (path == "/")	return path;
        
        int start = 0;
        while (true)    {
            if (start >= path.length())
                break;

            int end = start;
            while (true)    {
                if (end == path.length() || path.charAt(end) == '/')    {
                    String dir = path.substring(start, end);
                    if (dir == ".")
                        ;
                    else if (dir == "..")
                        lowerLevel();
                    else
                        addLevel(dir);
                        
                    start = end + 1;
                    break;
                }
                end++;
            }
        }
        
        if (str.length() > 1 && str.charAt(str.length() - 1) == '/')
            str.deleteCharAt(str.length() - 1);
            
        return str.toString();
    }
}

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.simplifyPath("/"));
	}

}
