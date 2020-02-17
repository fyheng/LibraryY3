package Domain;

public class Staff {
	 private String firstName;
     private String lastName;
     private String fullName;
     private String sex;
     private String address;
     private String dob; // date of birthday 
     private String phoneNumber;
	 private String nationalId;
     private String startAt;
     private int roleId;
     private String email;
   
     //===========================constructor =================
     public Staff(){
     	
     }
     public Staff(String firstName,String lastName,String fullName,String sex , String address,String dob,String phoneNumber,String nationalId,String startAt,int roleId ,String email){
       setFirstName(firstName);
   	   setLastName(lastName);
   	   setFullName(fullName);
   	   setSex(sex);
   	   setAddress(address);
   	   setDob(dob);
   	   setPhoneNumber(phoneNumber);
       setNationalId(nationalId);  
       setStartAt(startAt); 
       setRoleId(roleId);
       setEmail(email);
     } 
     
   public void setEmail(String email) {
	   this.email = email;
   }
   public String getEmail() {
	   return email;
   }
   public void setRoleId(int roleId) {
	   this.roleId = roleId;
   }
   public Integer getRoleId() {
	   return roleId;
   }
     
   public void setFirstName (String firstName) {
 	  this.firstName = firstName;
   }
   public String getFistName() {
 	  return firstName;
   }
   
   public void setLastName (String lastName) {
 	  this.lastName = lastName;
   }
   
   public String getLastName() {
 	  return lastName;
   }
   
   public void setFullName (String fullName) {
 	  this.fullName = fullName;
   }
   
   public String getFullName() {
 	  return fullName;
   }
   
   public void setSex (String sex) {
 	  this.sex = sex;
   }
   public String getSex() {
 	  return sex;
   }
   
   public void setAddress (String address) {
 	  this.address = address;
   }
   public String getAddress() {
 	  return address;
   }
   
   public void setDob (String dob) {
 	  this.dob = dob;
   }
   public String getDob() {
 	  return dob;
   }
   
   public void setPhoneNumber (String phoneNumber) {
 	  this.phoneNumber = phoneNumber;
   }
   public String getPhoneNumber() {
 	  return phoneNumber;
   }
     
    public void setNationalId(String nationalId) {
    	this.nationalId = nationalId;
    }
    public String getNationalId() {
    	return nationalId;
    }
     
    public void setStartAt(String startAt) {
    	this.startAt = startAt;
    }
    
    public String getStartAt() {
       return startAt;
    }
    
}
