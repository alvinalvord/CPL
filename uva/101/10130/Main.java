import java.util.*;

public class Main {
	
	static class Item {
		int price;
		int weight;
		
		Item (int price, int weight) {
			this.price = price;
			this.weight = weight;
		}
	}
	
	static ArrayList <Item> items;
	
	public static void ks01 (int[][] arr) {
		
		for (int i = 1; i < arr.length; i++) { // i for weight
			for (int j = 1; j < arr[0].length; j++) { // j for items
				if (items.get (j - 1).weight <= i) { //if i can add the item
					arr[i][j] = 
						Math.max 
						(
							items.get (j - 1).price + 
								arr[i - items.get (j - 1).weight][j - 1],
							arr[i][j-1]
						);
				}
				else {
					arr[i][j] = arr[i][j - 1];
				}
			}
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int t = sc.nextInt ();
		items = new ArrayList <> (1001);
		
		while (t-->0) {
			items.clear ();
			int n = sc.nextInt ();
			for (int i = 0; i < n; i++) {
				items.add (new Item (sc.nextInt (), sc.nextInt ()));
			}
			
			int[][] arr = new int[31][items.size () + 1];
			ks01 (arr);
			
			int sum = 0;
			int p = sc.nextInt ();
			for (int i = 0; i < p; i++) {
				int weight = sc.nextInt ();
				sum += arr[weight][items.size ()];
			}
			
			System.out.println (sum);
		}
		
	}
	
}