import java.util.Scanner;
import java.io.*;

public class Main {
	
	public static boolean allwild (String a) {
		for (int i = 0; i < a.length (); i++)
			if (a.charAt (i) != '-')
				return false;
			
		return true;
	}
	
	public static boolean check (char[] a, char[] b, int i) {
		if (i >= a.length)
			return true;
		
		if (a[i] != '-' && b[i] != '-' && a[i] != b[i])
			return false;
		
		return check (a, b, i+1);
	}
	
	public static void func () {
		StringBuilder sb = new StringBuilder ();
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt (); sc.nextLine ();
		String[] in = new String[n];
		boolean[] b = new boolean[n];
		
		for (int i = 0; i < n; i++)
			in[i] = sc.nextLine ();
		
		for (int i = 0; i < n; i++)
			if (allwild (in[i]))
				b[i] = true;
		
		for (int i = 1; i < n; i++) {
			boolean hasMatch = false;
			if (b[i]) {
				sb.append (i + 1).append (":");
				for (int j = 0; j < i; j++) {
					sb.append (" ").append (j + 1);
				}
				sb.append ("\n");
			} else {
				for (int j = 0; j < i; j++) {
					boolean isMatch = b[j];
					
					if (!isMatch)
						check (in[i].toCharArray (), in[j].toCharArray (), 0);
					
					if (isMatch) {
						if (!hasMatch) {
							hasMatch = true;
							sb.append (i + 1).append (":");
						}
						sb.append (" ").append (j + 1);
					}
				}
				if (hasMatch)
					sb.append ("\n");
			}
			
			System.out.print (sb.toString ());
			sb.setLength (0);
				
		}
	}
	
	public static void t () {
		long s = System.nanoTime ();
		func ();
		long e = System.nanoTime ();
		try {
			PrintWriter pw = new PrintWriter (new File ("time.txt"));
			pw.println ((e - s)/1000000000.0);
			pw.close ();
		} catch (Exception ex) {}
	}
	
	public static void main (String[] args) {
		t ();
	}
	
}