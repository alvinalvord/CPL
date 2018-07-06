import java.util.*;

public class A {
	
	public static void func (
		char[] stack, int stackdex, 
		char[] input, int inputdex, 
		char[] test, char ipasok, int testdex,
		char[] goal, int goaldex,
		StringBuilder output, int operation) 
	{
		if (operation == -1) {
			func (stack, 0, input, 1, test, input[inputdex], 0, goal, 0, output, 0);
		} 
		else if (operation == 10) {
			System.out.println (String.join (output.toCharArray (), " "));
		}
		else {
			if (operation == 0) {
				output.append ("i");
				stack[stackdex++] = ipasok;
			}
			else {
				output.append ("o");
				test[testdex++] = stack[--stackdex];
			}
			
			func (stack, )
		
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (true) {
			if (!sc.hasNextLine ()) {
				break;
			}
			char[] input = sc.nextLine ().toCharArray ();
			char[] goal = sc.nextLine ().toCharArray ();
			
			if (input.length != goal.length) {
				System.out.println ("[\n]");
				continue;
			}
			
			char[] stack = new char[input.length];
			char[] test = new char[input.length];
			StringBuilder output = new StringBuilder ();
			
			func (stack, 0, input, 0, test, 0, 0, goal, output, -1);
			
		}
		
	}
	
}
