package users;

public class User {
	
	private String name;
	private String email;
	private boolean researcher;
	private String role;
	
	public User(String name, String email, boolean researcher, String role) {
		this(name, email,role);
		this.researcher = researcher;	
	}
	
	public User(String name, String email, String role) {
		this.name = name;
		this.email = email;
		this.role = role;
		this.researcher = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isResearcher() {
		return researcher;
	}

	public void setResearcher(boolean researcher) {
		this.researcher = researcher;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User: name = " + name + ", email = " + email + ", researcher = " + researcher + ", role = " + role;
	}
}
