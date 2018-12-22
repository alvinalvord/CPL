import java.util.*;

public class Main {

	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);

		int n = sc.nextInt (); sc.nextLine ();
		char[] a = sc.nextLine ().toCharArray ();
		char[] b = sc.nextLine ().toCharArray ();

		int swap = 0;
		for (int i = 0, j = n - 1; i < j; i++, j--) {
			       if (a[i] == b[i] && a[j] == b[j]) swap += 2;
			else if (a[i] == b[i] && a[j] != b[j]) swap ++;
			else if (a[i] != b[i] && a[j] == b[j]) swap ++;

			else if (a[i] == b[j] && a[j] == b[i]) swap += 2;
			else if (a[i] == b[j] && a[j] != b[i]) swap ++;
			else if (a[i] != b[j] && a[j] == b[i]) swap ++;

			else if (a[i] == a[j] && b[i] == b[j]) swap += 2;
			else if (a[i] != a[j] && b[i] == b[j]) swap ++;
		}

		if (n % 2 == 1 && a[n/2] == b[n/2]) swap ++;

		System.out.println (n - swap);
	}

}
