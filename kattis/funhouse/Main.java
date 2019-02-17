import java.io.*;
import java.util.*;

public class Main {
	
	static void func (char[][] arr) {
		int x = 0, y = 0;
		boolean found = false;
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] == '*') {
				x = 0; y = i; found = true; break;
			}
			if (arr[arr.length - 1][i] == '*') {
				x = arr.length - 1; y = i; found = true; break;
			}
		}
		if (!found) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][0] == '*') {
					x = i; y = 0; found = true; break;
				}
				if (arr[i][arr[0].length - 1] == '*') {
					x = i; y = arr[0].length - 1; found = true; break;
				}
			}
		}
		
		char dir = 0; // up = 0, down = 1, left = 2, right = 3
		
		if (x == 0) { // entrance from top
			dir = 1; // go down
		} else if (x == arr.length - 1) { // entrance from bottom
			dir = 0; // go up
		} else if (y == 0) { // entrance from left
			dir = 3; // go right
		} else { // entrance from right
			dir = 2; // go left
		}
		
		while (arr[x][y] != 'x') {
			if (arr[x][y] == '.' || arr[x][y] == '*') {
				switch (dir) {
					case 0: x--; break; // go up
					case 1: x++; break; // go down
					case 2: y--; break; // go left
					case 3: y++; break; // go right
				}
			} 
			else if (arr[x][y] == '/') {
				switch (dir) {
					case 0: dir = 3; y++; break; // going up rotate to go right
					case 1: dir = 2; y--; break; // going down rotate to go left
					case 2: dir = 1; x++; break; // going left rotate to go down
					case 3: dir = 0; x--; break; // going right rotate to go up
				}
			} else { // i see a '\'
				switch (dir) {
					case 0: dir = 2; y--; break; // going up rotate to go left
					case 1: dir = 3; y++; break; // going down rotate to go right
					case 2: dir = 0; x--; break; // going left rotate to to go up
					case 3: dir = 1; x++; break; // going right rotate to go down
				}
			}
		}
		arr[x][y] = '&';
		
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < arr.length; i++)
			sb.append (new String (arr[i])).append ('\n');
		
		System.out.print (sb.toString ());
	}
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		for (int i = 1; ; i++) {
			String[] s = br.readLine ().split (" ");
			int x = Integer.parseInt (s[0]);
			int y = Integer.parseInt (s[1]);
			if (x == y && x == 0) break;
			System.out.println ("HOUSE " + i);
			char[][] arr = new char[y][x];
			
			for (int j = 0; j < y; j++)
				arr[j] = br.readLine ().toCharArray ();
			
			func (arr);
			
		}
		
		
	}
	
}