package simulator.model;

import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Vehicle extends SimulatedObject{
	private List<Junction> itinerary;
	private int maxSpeed;
	private int speed;
	private VehicleStatus status;
	private Road road;
	private int location;
	private int contClass;
	private int totalContamination;
	private int totalDistance;
	
	Vehicle(String id, int maxSpeed, int contClass, List<Junction> itinerary) throws IllegalArgumentException {
		super(id);
		if (maxSpeed > 0) 
			this.maxSpeed = maxSpeed;
		else 
			throw new IllegalArgumentException("Max Speed should be bigger than 0");
			
		if(0<= contClass && contClass <= 10)
			this.contClass = contClass;
		else
			throw new IllegalArgumentException("Contamination has an invalid value");
		
		if(itinerary.lenght() > 2)
			Collections.unmodifiableList(new ArrayList<>(itinerary));
		else
			throw new IllegalArgumentException("Itinery is not longh enough");
	}


	public void setSpeed(int s) throws IllegalArgumentException{
		if(s<0)
			throw new IllegalArgumentException("Max Speed should be bigger than 0");
		else
			if(s <= maxSpeed) {
				this.speed = s;
			}
			else {
				this.speed = maxSpeed;
			}
		
	}
	public void setContamination(int c) {
		
	}
	public void advance(int time) {
		
	}
	public JSONObject report() throws JSONException {
		StringBuilder sb = new StringBuilder();
		String id = "\" id \" :  \" " + this._id + "\",";
		String sp = "\" speed \" :   " + this.speed + ",";
		String dis = "\" distance \" :  \" " + this.totalDistance + ",";
		String co2= "\" co2 \" :  \" " + this.totalContamination + ",";
		String cl = "\" class \" :  \" " + this.contClass + ",";
		String st = "\" status \" :  \" " + this.status + "\",";
		String rd = "\" road \" :  \" " + this.road + "\","; 
		String loc = "\" location \" :  \" " + this.location;
		
		return new JSONObject( sb.append(id).append(sp).append(dis).append(co2).append(cl).append(st).append(rd).append(loc).toString());
}