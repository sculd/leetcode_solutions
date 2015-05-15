import java.util.*; 
import java.io.*;

class Function {  
  String FirstReverse(String str) { 
  
    // code goes here   
    /* Note: In Java the return type of a function and the 
       parameter types being passed are defined, so this return 
       call must match the return type of the function.
       You are free to modify the return type. */
	StringBuilder rev = new StringBuilder(str);
    int pos = str.length()-1;
    for (char ch : str.toCharArray())	{
      rev.setCharAt(pos, ch);
      pos -= 1;
    }
    return rev.toString();
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Function c = new Function();
    System.out.print(c.FirstReverse(s.nextLine())); 
  }   
  
} 

public class FirstReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((new Function()).FirstReverse("hello world"));
	}

}
