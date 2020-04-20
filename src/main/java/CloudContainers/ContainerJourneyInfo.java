package CloudContainers;

import java.util.HashSet;

public class ContainerJourneyInfo {

	Journey journey;
	Client client;
	HashSet<Client> clients;
	
	/** Creates a containerJourneyInfo object
	 * 
	 * @param journey
	 * @param client
	 * @param clients
	 */
	
	public ContainerJourneyInfo(Journey journey, Client client, HashSet<Client> clients) {
		this.journey = journey;
		this.client = client;
		this.clients = clients;
	}
	
	/**Gets journey
	 * 
	 * @return journey
	 */
	
	public Journey getJourney() {
		return journey;
	}
	
	/**Sets journey
	 * 
	 * @param journey
	 */

	public void setJourney(Journey journey) {
		this.journey = journey;
	}
	
	/**Gets client
	 * 
	 * @return client
	 */

	public Client getClient() {
		return client;
	}
	
	/**Sets client
	 * 
	 * @param client
	 */

	public void setClient(Client client) {
		this.client = client;
	}
	
	/**Gets a hashset of clients
	 * 
	 * @return clients
	 */

	public HashSet<Client> getClients() {
		return clients;
	}
	
	/**Sets clients
	 * 
	 * @param clients
	 */

	public void setClients(HashSet<Client> clients) {
		this.clients = clients;
	}


	
	
	
	
}
