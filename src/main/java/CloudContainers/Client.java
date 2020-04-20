package CloudContainers;

/**Represents a client entity
 * @Author: Victor
 * @Author Gustav
 */
// New version
public class Client {
	
	private String name;
	private int clientID;
	private String email;
	private String birthdate;
	private String gender;
	private int number;
	private LogisticCompany company;
	private String password;
	private Validator validator;
	
	/**Creates a client
	 * @param name
	 * @param email
	 * @param birthdate
	 * @param gender
	 * @param number
	 * @param password
	 */
	
	public Client(String name, String email, String birthdate, String gender, int number, String password) {
		super();
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.gender = gender;
		this.number = number;
		this.password = password;
	}
	
	/**Gets the clients password
	 * @return password
	 */
	
	public String getPassword() {
		return password;
	}
	/**Sets the clients password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/** Gets clients logistic company
	 * 
	 * @return LogisticCompany
	 */
	public LogisticCompany getCompany() {
		return company;
	}
	/**Sets clients logistic company, and instantiates a validator object 
	 * 
	 * @param company
	 */

	public void setCompany(LogisticCompany company) {
		this.company = company;
		this.validator = new Validator(company);
	}
	
	/**Gets clients name
	 * 
	 * @return name
	 */
	
	public String getName() {
		return name;
	}
	
	/**Sets clients name
	 * 
	 * @param name
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**Gets clients clientID
	 * 
	 * @return clientID
	 */
	
	public int getClientID() {
		return clientID;
	}
	
	/**Sets clients clientID
	 * 
	 * @param clientID
	 */
	
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	/**Gets clients email
	 * 
	 * @return email
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**Sets clients email
	 * 
	 * @param email
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**Get clients birthdate
	 * 
	 * @return birthdate
	 */
	
	public String getBirthdate() {
		return birthdate;
	}
	
	/**Sets clients birthdate
	 * 
	 * @param birthdate
	 */
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	/**Gets clients gender	
	 * 
	 * @return gender
	 */
	
	public String getGender() {
		return gender;
	}
	
	/**Sets clients gender
	 * 
	 * @param gender
	 */
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**Gets clients number
	 * 
	 * @return number
	 */
	
	public int getNumber() {
		return number;
	}
	
	/**Sets clients number
	 * 
	 * @param number
	 */
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**Compares client with another client using email
	 * 
	 * @param client
	 * @return boolean
	 */
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Client) {
			return (this.getEmail()).equals(((Client) o).getEmail());
		}
		return false;
	}
	
	/** HashCode implementation for checking equality of client objects
	 * 
	 */
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.clientID;
		return result;
	}
	
	/** Updates clients email
	 * 
	 * @param email
	 * @return response
	 */
	
	public ResponseObject updateClient(String email) {
		ResponseObject response = new ResponseObject();
		// Valid new email
		response = validator.validInput(getName(),email,getBirthdate(),getGender(),getNumber());
		// Check if new email belongs to a client already
		if (response.getErrorMessage().equals("Non-existing client")) {
			this.setEmail(email);
			response.setErrorMessage("Email has been updated");
			}
		return response;
	}
	
	/** Updates clients number
	 * 
	 * @param number
	 * @return response
	 */
	
	public ResponseObject updateClient(int number) {
		ResponseObject response = new ResponseObject();
		// Valid new phone number
		boolean validNumber = validator.validNumber(number);
		if (validNumber) {
			this.setNumber(number);
			response.setErrorMessage("Phone number has been updated");
			}
		else {
			response.setErrorMessage(number + " is not a valid phone number");
		}
		return response;
	}
	
	/** Puts a container belonging to client on a journey
	 * 
	 * @param container
	 * @param journey
	 * @param content
	 * @return response
	 */
	
	public ResponseObject containerToJourney(Container container, Journey journey, String content) {
		ResponseObject response = new ResponseObject("Container successfully added to journey");

		boolean belongsToClient = container.getOwner().equals(this);
		
		if (!belongsToClient) {
			response.setErrorMessage("Container does not belong to client");
			return response;
		}
		
		container.setContent(content);
		container.addJourney(journey);
		return response;
	}
	
	/** Prints clients information
	 * 
	 */
	
	public void print() {
		System.out.println("Name:" + this.getName());
		System.out.println("Company: " + this.getCompany());
		System.out.println("Client ID:" + this.getClientID());
		System.out.println("Email:" + this.getEmail());
		System.out.println("Birthdate:" + this.getBirthdate());
		System.out.println("Gender:" + this.getGender());
		System.out.println("Phone number:" + this.getNumber());
		
	}
	

}


