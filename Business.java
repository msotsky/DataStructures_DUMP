/**
 * 
 * @author Maxime Sotsky
 *
 */

public class Business {

	// INSTANCE VARIABLES
	
	String businessName;
	String businessPhone;
	String businessHours;
	String pageTitle;
	String[] servicesOffered;
	
	// CONSTRUCTORS
	
	Business(){
		businessName = "";
		businessPhone = "";
		businessHours = "";
		pageTitle = "";
		servicesOffered = null;
	}
	
	Business(String name, String phone, String hours, String title, String[] services){
		businessName = name;
		businessPhone = phone;
		businessHours = hours;
		pageTitle = title;
		servicesOffered = services; 
	}
	
	  
	public String getName(){
		return businessName;
	}
	public String getPhone(){
		return businessPhone;
	}
	public String getHours(){
		return businessHours;
	}
	public String getTitle(){
		return pageTitle;
	}
	public String[] getServices(){
		return servicesOffered;
	}
	
}
