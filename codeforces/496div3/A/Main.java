import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt ();
		}
		
		ArrayList<Integer> indices = new ArrayList <> ();
		
		for (int i = 1; i < n; i++) {
			if (arr[i] == 1) {
				indices.add (i);
			}
		}
		
		ArrayList <Integer> list = new ArrayList <> ();
		for (int i = 0; i < indices.size (); i++) {
			list.add (arr[indices.get(i) - 1]);
		}
		list.add (arr[n-1]);
		
		System.out.println (list.size ());
		
		for (int i = 0; i < list.size (); i++) {
			System.out.print (list.get (i) + " ");
		}
	}
	
}