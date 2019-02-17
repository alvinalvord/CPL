import java.io.*;
import java.util.*;

public class Main {
	
	static int p (String s) {
		return Integer.parseInt (s);
	}
	
	static void f (BitSet[] arr) {
		BitSet adj = new BitSet (arr.length);
		
		for (int i = 0; i < arr.length; i++) {
		if (!adj.get(i)) {
			for (int j = 0; j < arr.length; j++) {
			if (arr[i].get (j)) {
				for (int k = j + 1; k < arr.length; k++) {
				if (arr[i].get (k)) {
					if (arr[j].get (k)) {
						adj.set (i); break;
					}
				}} 
			} if (adj.get (i)) break; }
		}}
		
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < arr.length; i++) {
			if (!adj.get (i)) sb.append (i).append (' ');
		}
		
		System.out.println (sb.toString ());
	}
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		while (true) {
			int n = p (br.readLine ());
			if (n == -1) break;
			
			BitSet[] arr = new BitSet[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = new BitSet (n);
				String[] temp = br.readLine ().split ("\\s+");
				for (int j = 0; j < temp.length; j++) {
					if (temp[j].charAt (0) == '1')
						arr[i].set (j);
				}
			}
			
			f (arr);
		}
		
	}
	
}