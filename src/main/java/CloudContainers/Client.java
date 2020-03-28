package CloudContainers;

import java.util.HashSet;

// New version
public class Client {
	
	private String name;
	private int clientID;
	private String email;
	private String birthdate;
	private String gender;
	private int number;
	private HashSet<Container> containers;
	
	
	public Client(String name, int clientID, String email, String birthdate, String gender, int number) {
		super();
		this.name = name;
		this.clientID = clientID;
		this.email = email;
		this.birthdate = birthdate;
		this.gender = gender;
		this.number = number;
	}
	
	public boolean cEquals(Client client) {
		return (this.getEmail()).equals(client.getEmail());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void print() {
		System.out.println("Name:" + this.getName());
		System.out.println("Client ID:" + this.getClientID());
		System.out.println("Email:" + this.getEmail());
		System.out.println("Birthdate:" + this.getBirthdate());
		System.out.println("Gender:" + this.getGender());
		System.out.println("Phone number:" + this.getNumber());
		
	}
	
	public boolean exist(Container container) {
		return containers.contains(container);
	}
	
	public ResponseObject registerContainer(Container container, Journey journey) {
		
		// journey.getCompany().exist(journey);
		// containers.exist(container) ...
		ResponseObject response = new ResponseObject();
		if (this.exist(container) && journey.getCompany().exist(journey)) {
			journey.addContainer(container);
			response.setErrorMessage("Container usccessfully added to journey");
		}
		else if (this.exist(container)) {
			response.setErrorMessage("This is not a valid journey");
		}
		return response;
		
	}


}


