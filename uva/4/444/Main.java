import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		String s = "Hello World";
		
		List<Character> list = Arrays.asList (s.chars ().mapToObj (c-> (char) c).toArray (Character[]:: new));
		
		Collections.sort (list);
		
		StringBuilder sb = new StringBuilder ();
		for (Character ch: list)
			sb.append (ch);
		
		System.out.println (sb.toString ());
	}
	
}