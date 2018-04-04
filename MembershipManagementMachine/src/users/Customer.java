package users;

public class Customer implements java.io.Serializable {

	private int customerNumber;           // The Customers Phone Number
	private String customerAddress;       // The customers address
	private String customerFirstName;     // The customers First name
	private String customerLastName;      // The customers Last Name
	private String username;              // customer username
	private String password;              // customer password
	private Boolean hasPaid;              // whether or not the customer has paid this month
	private int missedPayments;           // The amount of payments the customer missed
	private int successfulPayments;       // the amount of payments the customer made
	private int attendedClasses;          // number of classes the customer has attended
	
	
	
	
	// Constructor
	public Customer (String firstName, String lastName, String address, int cn, String usrname, String pssword) 
	   {
	      // set instance variables to user input
		  this.customerFirstName = firstName;
	      this.customerLastName = lastName;
	      this.customerAddress = address;
		  this.customerNumber = cn;
		  this.username = usrname;
		  this.password = pssword;
		  
		  // set instance variables to 0 by default
		  this.hasPaid = false;
		  this.missedPayments = 0;
		  this.successfulPayments = 0;  
		  this.attendedClasses = 0;
	   }
	
	
	// Customer Getter methods
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	public String getCustomerAddress(){
		return customerAddress;
	}
	
	public String getCustommerFirstName(){
		return customerFirstName;
	}
	
	public String getCustomerLastName(){
		return customerLastName;
	}
	
	public Boolean getCustomerHasPaid(){
		return hasPaid;
	}
	
	public int getCustomerMissedPayments(){
		return missedPayments;
	}
	
	public int getCustomerSuccessfulPayments(){
		return successfulPayments;
	}
	
	public int getCustomerAttendedClasses(){
		return attendedClasses;
	}
	
	public String getCustomerUSername(){
		return username;
	}
	
	public String getCustomerPassword(){
		return password;
	}
	
	// Customer Setter methods
	public void setCustomerFirstName(String CustomerFirstName){
		this.customerFirstName = CustomerFirstName;
	}
	
	public void setCustomerLastName(String CustomerLastName){
		this.customerLastName = CustomerLastName;
	}
	
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public void setCustomerAddress(String CustomerAddress){
		this.customerAddress = CustomerAddress;
	}
	
	public void setMissedPayments(int missedPayments){
		this.missedPayments = missedPayments;
	}
	
	public void setSuccessfulPayments(int successfulPayments){
		this.successfulPayments = successfulPayments;
	}
	
	public void setAttendedClasses(int classesAttended){
		this.attendedClasses = classesAttended;
	}
	

}
