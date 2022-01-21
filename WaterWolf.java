/**
 * WaterWolf 0.5 
 * 
 * @author Maxime Sotsky
 * 
 */
public class WaterWolf extends Business{

	// INSTANCE VARIABLES
	
	Business business; 
	
	// CONSTRUCTORS
	
	WaterWolf(Business theBizz){
		business = theBizz;
	}
	
	
	// METHODS 
	
	public void displayWelcome() {
		System.out.println(".................Welcome to WaterWolf.................");
		System.out.println("To start your browsing experience, enter V followed by the page title to view a new page");
	}
	
	/**
	 * This method only displays information about the one business that this class is populated with...
	 * Is this really what Dr. Betti wants?!
	 */
	public void displayInfo() {
		System.out.println("===========================================================================");
		System.out.println("  B to go back to previous item");
		System.out.println();
		System.out.println("                This is business: " + business.businessName);
		System.out.println("                This is hours: " + business.businessHours);
		System.out.println("                Services offered include: ");
		// Yikes! Looks like someone doesn't like loops...is there a different and/or better way?!
		System.out.println("    OH GADZOOKS THIS IS TOO MUCH WORK TO DISPLAY ALL THE SERVICES. FIX THIS LATER.");
		System.out.println();
		System.out.println("                                                F to go forward to next item");
		System.out.println("============================================================================");
	}

	
	public void goForward(StackList s) {
		goToPage(s.pop());
		//System.out.println(s.pop());
	}
	
	public void goBack(StackList s) {
		goToPage(s.pop());
	}

	/**
	 * This method is supposed to display the title of the page followed by the contents of 
	 *  the appropriate page.
	 *  
	 * @param title is the name of the page the user wants to view
	 */
	public void goToPage(String title) {
		if (title.equals(business.pageTitle))
			System.out.println(" -----> " + title + " <------ ");
		else
			System.out.println("Invalid page title.");
	}
}
