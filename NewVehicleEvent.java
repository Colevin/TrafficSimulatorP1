package simulator.model;

import java.util.List;

public class NewVehicleEvent extends Event{
	private List<Junction> itinerary;
	private int maxSpeed;
	private int contClass;
	private String id;
	public NewVehicleEvent(int time, String id, int maxSpeed, int contClass, List<Junction> itinerary) {
			super(time);
			this.id= id;
			this.itinerary = itinerary;
			this.maxSpeed = maxSpeed;
			this.contClass = contClass;
			}

	@Override
	void execute(RoadMap map) {
		map.addVehicle(new Vehicle(this.id, this.maxSpeed, this.contClass, this.itinerary));
	}

}
