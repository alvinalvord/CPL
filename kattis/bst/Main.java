import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		int value;
		Node left;
		Node right;
		
		Node (int m) {
			value = m;
			left = right = null;
		}
		
		void makeRight (int m) {
			right = new Node (m);
		}
		
		void makeLeft (int m) {
			left = new Node (m);
		}
	}
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		int n = Integer.parseInt (br.readLine ());
		Node root = null;
		StringBuilder sb = new StringBuilder ();
		
		int counter = 0;
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt (br.readLine ());
			int y = 0;
			
			if (root == null) {
				root = new Node (m);
			} else {
				Node temp = root;
				while (true) {
					if (m > temp.value) {
						y++;
						if (temp.right == null) {
							temp.makeRight (m);
							counter += y;
							break;
						} else {
							temp = temp.right;
						}
					} else {
						y++;
						if (temp.left == null) {
							temp.makeLeft (m);
							counter += y;
							break;
						} else {
							temp = temp.left;
						}
					}
				}
			}
			sb.append (counter).append ('\n');
			
		}
		
		System.out.println (sb.toString ());
		
	}
	
}

