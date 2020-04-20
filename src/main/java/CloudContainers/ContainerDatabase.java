package CloudContainers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainerDatabase extends HashSet<Container>{
	
	/** Filters containers for a given client
	 * 
	 * @param client
	 * @return a set of containers for a specific client
	 */

	public Set<Container> filterClient(Client client) {
		Set<Container> filtered = this.stream()
				.filter(container -> container.getOwner().equals(client))
				.collect(Collectors.toSet());
		return filtered;	
	}
	
	/** Filters containers for a given journey
	 * 
	 * @param journey
	 * @return a set of containers for a specific journey
	 */
	
	public Set<Container> filterJourney(Journey journey) {
		Set<Container> filtered = this.stream()
				.filter(container -> journey.equals(container.getCurrentJourney()))
				.collect(Collectors.toSet());
		return filtered;	
	}
	
	/**Finds a free container in container database
	 * 
	 * @return container
	 */
	
	public Container findFreeContainer() {
		
		for (Container c: this) {
			if (!c.isOwned()) {
				return c;
			}
		}
		return null;
		}

	
}
