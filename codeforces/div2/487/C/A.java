import java.util.*;

public class A {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		char[][] arr = new char[50][50];
		String temp = "ABCD";
		for (int i = 0; i < 50; i++) {
			arr[0][i] = temp.charAt (i % 4);
		}
		
		for (int i = 1; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				arr[i][j] = temp.charAt ((arr[i - 1][j] - 'A' + 1) % 4);
			}
		}
		
		System.out.println (50 + " " + 50);
		for (int i = 0; i < 50; i++) {
			System.out.println (new String(arr[i]));
		}
	}
	
}