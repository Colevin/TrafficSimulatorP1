package simulator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class RoadMap{

	private List<Junction> ListJunctions;
	private List<Road> ListRoads;
	private List<Vehicle> ListVehicles;
	private Map<String, Junction> JunctionsMap;
	private Map<String, Road> RoadsMap; //map w junction Id and the road itself
	private Map<String, Vehicle> VehiclesMap;  //map w vehicle Id and the vehicle
	
	
	
	RoadMap() {
		this.ListJunctions = new ArrayList<>();
		this.ListRoads = new ArrayList<>();
		this.ListVehicles = new ArrayList<>();
		this.JunctionsMap = new HashMap<>();
		this.RoadsMap = new HashMap<>();
		this.VehiclesMap = new HashMap<>();
	}
	
	protected void addJunction(Junction j) {
		if(!ListJunctions.contains(j)) {
			ListJunctions.add(j);
			JunctionsMap.put(j._id,j);
		}
		//else throw new IllegalArgumentException("Tienen el mismo ID");
	}
	protected void addRoad(Road r) {
		if(!ListRoads.contains(r)) {
			if(RoadsMap.containsValue(r)) {
			ListRoads.add(r);
			RoadsMap.put(r._id,r);
			}
			else throw new IllegalArgumentException("The road doesnt exist in the map");
		}
		else throw new IllegalArgumentException("It alredy exists ");
	}
	protected void addVehicle(Vehicle v) {
		if(!ListVehicles.contains(v)) {
			//IF EXISTEN LAS CARRETERAS DEL ITINERARIO
			ListVehicles.add(v);
			VehiclesMap.put(v._id,v);
		}
		else throw new IllegalArgumentException("The Vehicle alredy exists in the list");
	}
	public Junction getJunction(String id) {
		Junction j = null;
		if(JunctionsMap.containsKey(id)) {
			j = JunctionsMap.get(id);
		}
		return j;
	}
	public Road getRoad(String id) {
		Road r = null;
		if(RoadsMap.containsKey(id)) {
			r = RoadsMap.get(id);
		}
		return r;
	}
	public Vehicle getVehicle(String id) {
		Vehicle v = null;
		if(VehiclesMap.containsKey(id)) {
			v = VehiclesMap.get(id);
		}
		return v;
	}
	public List<Junction> getJunctions(){
		return Collections.unmodifiableList(ListJunctions);
	}
	public List<Road> getRoads(){
		return Collections.unmodifiableList(ListRoads);
	}
	public List<Vehicle> getVehicles(){
		return Collections.unmodifiableList(ListVehicles);
	}
	void reset() {
		ListJunctions.removeAll(ListJunctions);
		JunctionsMap.clear();
		ListRoads.removeAll(ListRoads);
		RoadsMap.clear();
		ListVehicles.removeAll(ListVehicles);
		VehiclesMap.clear();
	}
	//public JSONObject report() {
		
	//}
	//EXTRA
	void advanceJunctions(int time) {
		for(Junction j: ListJunctions) {
			j.advance(time);
		}
	}
	void advanceRoads(int time) {
		for(Road r: ListRoads) {
			r.advance(time);
		}
	}
}
