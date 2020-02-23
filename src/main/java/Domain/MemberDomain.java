package Domain;

public class MemberDomain {
	private String firstName;
	private String lastName;
	private String fullName;
	private String sex;
	private String email;
	private String phone;
	private String address;
	RoleDomain roleId;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
