import java.util. *;

public class Main {
	
	static class N {
		int index;
		String text;
		N (int index, String text) {
			this.index = index;
			this.text = text;
		}
		
		int comp (N n) {
			if (text.length () == n.text.length ()) return -Integer.compare (index, n.index);
			return Integer.compare (text.length (), n.text.length ());
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		StringBuilder sb = new StringBuilder ();
		
		while (sc.hasNextLine ()) {
			sb.append (sc.nextLine ()).append (' ');
		}
		
		String[] arr = sb.toString ().replaceAll ("[^A-Za-z \\-]", "").split ("\\s");
		N[] nodes = new N[arr.length];
		for (int i = 0; i < arr.length; i++) 
			nodes[i] = new N (i, arr[i]);
		
		Arrays.sort (nodes, (a, b) -> {return a.comp (b); });
		
		if (nodes[nodes.length - 1].text.equals ("E-N-D")) 
			System.out.println (nodes[nodes.length - 2].text.toLowerCase ());
		else System.out.println (nodes[nodes.length - 1].text.toLowerCase ());
	}
	
}