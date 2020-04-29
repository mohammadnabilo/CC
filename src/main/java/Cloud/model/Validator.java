package CloudContainers;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.validator.GenericValidator;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Validator {

<<<<<<< HEAD
	private LogisticCompany company;
	
	
	public Validator(LogisticCompany company) {
		super();
		this.company = company;
	}
	
	public LogisticCompany getCompany() {
		return company;
	}

	public void setCompany(LogisticCompany company) {
		this.company = company;
	}
=======
>>>>>>> redirectRefactor

	public static boolean validBirthdate(String birthdate) {
		return GenericValidator.isDate(birthdate, "dd-MM-yyyy", true);
	}
	
	public static boolean validEmail(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}
	
	
	public static boolean emptyParameters(String name, String email, String birthdate, String gender, int number) {
		return !(   (name.equals("")) 
				|| (birthdate.equals("")) 
				|| (email.equals(""))			
				|| (gender.equals("")) 
				|| (number==0)   );
	}
	
<<<<<<< HEAD
	
	public boolean validNumber(int number) {
		int length = String.valueOf(number).length();
		return (length == 8);
	}
	public ResponseObject validInput(String name, String email, String birthdate, String gender, int number) {
=======
	/** Method to check if a phone number is valid
	 * 
	 * @param number
	 * @return boolean
	 */
	public static boolean validPhoneNumber(int number) {
		int length = String.valueOf(number).length();
		return (length == 8);
	}
	
	/** Checks if new client info is valid 
	 * 
	 * @param name
	 * @param email
	 * @param birthdate
	 * @param gender
	 * @param number
	 * @return response - type ResponseObject
	 */
	public static ResponseObject validInput(String name, String email, String birthdate, String gender, int number) {
>>>>>>> redirectRefactor
	ResponseObject response = new ResponseObject();
	
		if (!emptyParameters(name,email,birthdate,gender,number)) {
			response = new ResponseObject("There is a missing parameter");
			return response;
		}
		else if (!validEmail(email)) {
			response = new ResponseObject(email + " is not a valid email");
			return response;
		}
		else if (!validBirthdate(birthdate)) {
			response = new ResponseObject(birthdate + " is not a valid birthdate");
			return response;
		}
		else if (!validNumber(number)) {
			response = new ResponseObject(number + " is not a valid phone number");
			return response;
		}
		
		response.setErrorMessage("Valid");
		return response;
	
<<<<<<< HEAD
}
	public boolean clientHasAccess(Client client, Container container) {
=======
	}
	
	/** Checks if a client has access to a given container
	 * 
	 * @param client
	 * @param container
	 * @return boolean
	 */
	public static boolean clientHasAccess(Client client, Container container) {
>>>>>>> redirectRefactor
		return container.getAccessClients().stream().anyMatch(c -> c.equals(client));
	}
	
}
