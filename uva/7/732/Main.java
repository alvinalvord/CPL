import java.util.*;

public class Main {
	
	public static void func (
		String input, int inputdex,
		Stack <Character> temporaryStorage, char addToTemp,
		StringBuilder test, char addToTest,
		String goal,
		StringBuilder output,
		int operation
	) 
	{
		if (operation == -1) { // initial call
			func (input, 1, temporaryStorage, input.charAt (inputdex),
				test, (char) 0, goal, output, 0);
			temporaryStorage.pop ();
			output.setLength (output.length () - 1);
			return;
		}
		else if (operation == 0) { //push to temporaryStorage stack
			temporaryStorage.push (addToTemp);
			output.append ("i");
		} else if (operation == 1) { //pop from temporaryStorage push to test
			test.append (addToTest);
			output.append ("o");
		} 
		if (test.length () == goal.length ()) { //print output
			StringBuilder temp = new StringBuilder ();
			for (int i = 0; i < output.length (); i++) {
				temp.append (output.charAt (i));
				if (i < output.length () - 1)
					temp.append (" ");
			}
			System.out.println (temp.toString ());
			return;
		}
		
		// push
		if (inputdex < input.length ()) {
			func (input, inputdex + 1, temporaryStorage, input.charAt (inputdex), 
				test, (char) 0, goal, output, 0);
			temporaryStorage.pop ();
			output.setLength (output.length () - 1);
		}
		// pop
		if (!temporaryStorage.empty ()) {
			if (temporaryStorage.peek () == goal.charAt (test.length ())) {
				char ch = temporaryStorage.pop ();
				func (input, inputdex, temporaryStorage, (char) 0, 
					test, ch, goal, output, 1);
				temporaryStorage.push (ch);
				test.setLength (test.length () - 1);
				output.setLength (output.length () - 1);
			}
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (true) {
			if (!sc.hasNextLine ()) {
				break;
			}
			String input = sc.nextLine ();
			String goal = sc.nextLine ();
			System.out.println ("[");
			if (input.length () != goal.length ()) {
				System.out.println ("]");
				continue;
			}
			
			Stack<Character> temporaryStorage = new Stack <>();
			StringBuilder test = new StringBuilder ();
			StringBuilder output = new StringBuilder ();
			
			func (input, 0, temporaryStorage, (char) 0, test, (char) 0, goal, output, -1);
			
			System.out.println ("]");
		}
		
	}
	
}
