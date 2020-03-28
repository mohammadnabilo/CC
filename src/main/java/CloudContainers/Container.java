package CloudContainers;

public class Container {
	private int id;
	// Default is 20.0C (not on journey)
	private double temperature = 20.0;
	// Default is 1 atm (not on journey)
	private double pressure = 1.0;
	// Default is 0.5 - 50% (not on journey)
	private double airHumidity = 0.5;
	// Default is false
	private boolean onJourney = false;
	private boolean owned = false;
	
	public boolean isOnJourney() {
		return onJourney;
	}
	public void setOnJourney(boolean onJourney) {
		this.onJourney = onJourney;
	}
	public boolean isOwned() {
		return owned;
	}
	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	private String content = "";
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public Container(int id) {
		super();
		this.id = id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public double getAirHumidity() {
		return airHumidity;
	}
	public void setAirHumidity(double airHumidity) {
		this.airHumidity = airHumidity;
	}
	
	public boolean equals(Container c) {
		return this.getId() == c.getId();
	}
	public void print() {
		System.out.println(this.getId());
		System.out.println(this.getTemperature());
		System.out.println(this.getPressure());
		System.out.println(this.getAirHumidity());
		System.out.println(this.isOwned());
		System.out.println(this.isOnJourney());
	}
	
	
}
