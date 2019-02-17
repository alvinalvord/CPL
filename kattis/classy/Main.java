import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		String name;
		StringBuilder c;
		
		Node (String name) {
			this.name = name;
			c = new StringBuilder ();
		}
		
		public String toString () {
			return name + " " + c;
		}
		
	}
	
	static void f (BufferedReader br) throws Exception {
		int n = Integer.parseInt (br.readLine ());
		
		List<Node> list = new ArrayList<> ();
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine ().split ("(:\\s+)|\\s+");
			String[] c = temp[1].toLowerCase ().split ("-");
			
			Node node = new Node (temp[0]);
			for (int j = 0; j < c.length; j++) {
				switch (c[j].charAt (0)) {
					case 'u': node.c.append (1);
						break;
					case 'm': node.c.append (2);
						break;
					default: node.c.append (3);
				}
			}
			
			node.c = node.c.reverse ();
			while (node.c.length () <= 11) {
				node.c.append (2);//node.c.charAt (node.c.length () - 1));
			}
			
			list.add (node);
			
			// System.out.println (node);
		}
		
		Collections.sort (list, (a, b) -> {
			if (a.c.toString ().equals (b.c.toString ()))
				return a.name.compareTo (b.name);
			return a.c.toString ().compareTo (b.c.toString ());});
		
		for (Node node: list) System.out.println (node.name);
		System.out.println ("==============================");
	}
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		int n = Integer.parseInt (br.readLine ());
		
		for (int i = 0; i < n; i++) {
			f (br);
		}
		
	}
	
}