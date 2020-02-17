package Domain;

public class Staff extends Person {
	private String passport;
    private String startAt;
     
    public void setPassport(String passport) {
    	this.passport = passport;
    }
    public String getPassport() {
    	return passport;
    }
     
    public void setStartAt(String startAt) {
    	this.startAt = startAt;
    }
    
    public String getStartAt() {
       return startAt;
    }
    //===========================constructor =================
    public Staff(){
    	
    }
    public Staff(String firstName,String lastName,String fullName,String sex , String address,String dob,String phoneNumber,String passport,String startAt){
    	super(firstName,lastName,fullName,sex,address,dob,phoneNumber);
    	setPassport(passport);  
    	setStartAt(startAt);    	
    }
    //========================================================
    
}
