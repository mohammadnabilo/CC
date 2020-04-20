package CloudContainers;

import java.util.HashSet;

/** Represents a hashset of clients
 * @author Gustav
 * @author Victor
 *
 */

public class ClientDatabase extends HashSet<Client> {
		
		/** Gets a client given a unique clientID
		 * 
		 * @param clientID
		 * @return client
		 */
	
		public Client getClient(int clientID) {
			for (Client c :this) {
				if (c.getClientID() == clientID) {
					return c;
				}
			} return null;
		}
		
		/** Gets client given a unique email
		 * 
		 * @param email
		 * @return client
		 */
		
		public Client getClient(String email) {
			
			for (Client c :this) {
				if ((c.getEmail()).equals(email)) {
					return c;
				}
			} return null;
		}	
		
		/** Gets client given a phone number
		 * 
		 * @param number
		 * @return client
		 */
		
		public Client getClientN(int number) {
			
			for (Client c :this) {
				if (c.getNumber()==number) {
					return c;
				}
			} return null;
		}
	
		
}
