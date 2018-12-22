import java.util.*;

public class Main {
	
	static Scanner sc;
	
	public static void fill (int x, int y, char ch, char[][] arr) {
		if (x >= 0 && x < arr[0].length && y >= 0 && y < arr.length) {
			if (arr[y][x] == 0x30) {
				arr[y][x] = ch;
				fill (x - 1, y, ch, arr);
				fill (x + 1, y, ch, arr);
				fill (x, y - 1, ch, arr);
				fill (x, y + 1, ch, arr);
			}
		}
	}
	
	public static void run (int x, int y, int w, int h) {
		char[][] arr = new char[h][w];
		
		for (int i = 0; i < arr.length; i++) for (int j = 0 ; j < arr[i].length; j++) arr[i][j] = 0x30;
		System.out.println (x + " " + y);
		
		arr[x][y] = 0x39;
		System.out.println (arr[x][y]);
		
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) arr[i][j] = 0x31;
		for (int i = x - 1, j = y + 1; i >= 0 && j < arr[0].length; i--, j++) arr[i][j] = 0x32;
		for (int i = x + 1, j = y + 1; i < arr.length && j < arr[0].length; i++, j++) arr[i][j] = 0x33;
		for (int i = x + 1, j = y - 1; i < arr.length && j >= 0; i++, j--) arr[i][j] = 0x34;
		
		fill (x - 1, y, (char) 0x31, arr);
		fill (x, y - 1, (char) 0x32, arr);
		fill (x + 1, y, (char) 0x33, arr);
		fill (x, y + 1, (char) 0x34, arr);
		
		List<List<Integer>> pos = new ArrayList<>();
		
		for (int i = 0; i < h; i++)
			pos.add (new ArrayList <> ());
		
		for (int i = 0; i < h; i++) {
			int n = sc.nextInt ();
			
			for (int j = 0; j < n; j++) {
				int p = sc.nextInt ();
				int p0 = p - 1;
				switch (arr[i][p0]) {
					case 0x31: if (p0 - 1 >= 0) pos.get (i).add (p - 1); break;
					case 0x32: if (i - 1 >= 0) pos.get (i - 1).add (p); break;
					case 0x33: if (p0 + 1 < w) pos.get (i).add (p + 1); break;
					case 0x34: if (i + 1 < h) pos.get (i + 1).add (p); break;
				}
			}
		}
		
		for (List<Integer> list: pos) {
			list.sort((a,b)->Integer.compare (a,b));
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print ("[" + arr[i][j] + "]");
			}
			System.out.println ();
		}
		
		for (int i = 0; i < pos.size (); i++) {
			System.out.print (pos.get (i).size ());
			
			for (int j = 0; j < pos.get (i).size (); j++) {
				System.out.print (" " + pos.get (i).get (j));
			}
			System.out.println ();
		}
		
	}
	
	public static void main (String[] args) {
		sc = new Scanner (System.in);
		while (sc.hasNext ()) {
			int x = sc.nextInt ();
			int y = sc.nextInt ();
			int w = sc.nextInt ();
			int h = sc.nextInt ();
			System.out.println (x + " " + y + " " + w + " " + h);
			run (x - 1, y - 1, w, h);
			if (sc.hasNext ())
				System.out.println ();
		}
		
	}
	
}