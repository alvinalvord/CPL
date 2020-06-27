import java.io.*;
import java.util.*;

public class Main {
	
	BufferedReader br;
	Node root;
	StringBuilder sb;
	
	class Node {
		Node A, C, G, T, N;
		List <Integer> out;
		
		public Node () {
			A = C = G = T = N = null;
			out = null;
		}
		
	}
	
	void traverse (Node node, String s, int index, int sindex) {
		if (index < s.length ()) {
			if (node.N == null) node.N = new Node ();
			traverse (node.N, s, index + 1, sindex);
			
			char ch = s.charAt (index);
			
			if (ch == 'A') {
				if (node.A == null) node.A = new Node ();
				traverse (node.A, s, index + 1, sindex);
			} else if (ch == 'C') {
				if (node.C == null) node.C = new Node ();
				traverse (node.C, s, index + 1, sindex);
			} else if (ch == 'G') {
				if (node.G == null) node.G = new Node ();
				traverse (node.G, s, index + 1, sindex);
			} else if (ch == 'T') {
				if (node.T == null) node.T = new Node ();
				traverse (node.T, s, index + 1, sindex);
			} else {
				if (node.A == null) node.A = new Node ();
				traverse (node.A, s, index + 1, sindex);
				if (node.C == null) node.C = new Node ();
				traverse (node.C, s, index + 1, sindex);
				if (node.G == null) node.G = new Node ();
				traverse (node.G, s, index + 1, sindex);
				if (node.T == null) node.T = new Node ();
				traverse (node.T, s, index + 1, sindex);
			}
		} else {
			if (node.out == null) {
				node.out = new ArrayList <> ();
			}
			node.out.add (sindex);
		}
	}
	
	void answer (Node node, String s, int sindex) {
	
		for (int i = 0; i < s.length (); i++) {
			char ch = s.charAt (i);
			if (ch == 'A') node = node.A;
			else if (ch == 'C') node = node.C;
			else if (ch == 'G') node = node.G;
			else if (ch == 'T') node = node.T;
			else node = node.N;
		}
		
		if (node.out.size () - 1 == 0) return;
		
		sb.append (sindex).append (":");
		for (int i = 0; i < node.out.size () - 1; i++) {
			sb.append (" ").append (node.out.get (i));
		}
		sb.append ("\n");
	}
	
	public void run () throws Exception {
		br = new BufferedReader (new InputStreamReader (System.in));
		root = new Node ();
		sb = new StringBuilder ();
		
		int n = Integer.parseInt (br.readLine ());
		String s;
		
		for (int i = 0; i < n; i++) {
			s = br.readLine ();
			traverse (root, s, 0, i + 1);
			answer (root, s, i + 1);
		}
		
		System.out.print (sb.toString ());
	}
	
	public static void main (String[] args) throws Exception {
		new Main ().run ();
	}
	
}
