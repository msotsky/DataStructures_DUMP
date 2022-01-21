/**
Maxime Sotsky
 */
import java.util.Scanner;


public class TestWaterWolf {

	/** 
	 * This is a basic main method that performs a perfunctory test of WaterWolf version 0.5 as it
	 * currently exists.
	 */
	public static void main(String[] args){
		Business bettiBusiness = new Business("Original Sine", "506-555-5555", "midnight - 6am", "OSine", new String[] {"lawn bowling", "apiculture","dog training", "salsa lessons"});
		WaterWolf browser = new WaterWolf(bettiBusiness);	
		boolean browserOn = true;
		Scanner scan= new Scanner(System.in);
		browser.displayWelcome();


		//I will choose to approach using Stacks since thats what web browsers do.
		while (browserOn) {
			LinkedQueue cmds = new LinkedQueue<Character>();
			StackList history = new StackList<String>();
			StackList forward  = new StackList<String>();
			String text = scan.nextLine();
			text = text.replaceAll("\\s+",""); 
			char ch = scan.next().charAt(0);
			if (ch == 'V'|| ch == 'v') { 			// user wants to visit a page for viewing
// housekeeping to get rid of leading and/or trailing blanks
				browser.goToPage(text);
				history.push(getTitle());		
			}
			if (ch == 'F' || ch =='f'){				// user wants to go forward in browser history
				if(forward.peek() == null){
					browser.displayInfo();
				}
				else{
					//String text = scan.nextLine();
					//text = text.replaceAll("\\s+",""); 
					//char ch = scan.next().charAt(0);
					text = forward.pop();
					text = text.replaceAll("\\s+","");
					history.push(getTitle());
					goForward(forward);
				}
				
			}
			if (ch == 'C' || ch == 'c')//clear
			{
				while(forward.peek() != null)
				{
					forward.pop();
				}
				while(history.peek() != null)
				{
					history.pop();
				}
			}
			else {
				if (ch == 'B' || ch == 'b') {		// user wants to go backwards in browser history
					browser.displayInfo();
					forward.push(history.peek());
					browser.goBack(history);  // is this really what Dr. Betti wants?!
				}
				else {
					if (ch == 'Q' || ch == 'q') {	// user wants to quit the browser
						browserOn = false;
						while(forward.peek() != null)
						{
							forward.pop(); //clear
						}
						while(history.peek() != null)
						{
							history.pop();
						}
					}
					else { 							// user entered bad input and we ignore it
					browser.displayInfo();
					}
				}
			}
		}
		System.out.println("We know that in the hectic world of today, you have lots of browser choices.");
		System.out.println("Thanks for choosing WaterWolf!");
		scan.close();
	}
}
