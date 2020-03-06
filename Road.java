package simulator.model;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
//FALTA LA VISIBILIDAD DE TODOS LOS METODOS
public abstract class Road extends SimulatedObject {
	protected Junction srcJunc;
	protected Junction destJunc;	
	protected int length;
	protected int maxSpeed;
	protected int contLimit;
	protected int cuMaxSpeed;
	protected Weather weather;
	protected int totalCont;
	protected List <Vehicle> vehicles;
	
	Road(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length, Weather weather) {
		super(id);
		//AQUI HAY QUE HACER LO DE LAS EXCEPTIONS
		this.srcJunc = srcJunc;
		this.destJunc = destJunc;
		this.maxSpeed = maxSpeed;
		this.contLimit = contLimit;
		this.length = length;
	}
	abstract void reduceTotalContamination(); //
	abstract void updateSpeedLimit(); //
	abstract int calculateVehicleSpeed(Vehicle v); //
	
	void enter(Vehicle v) {
		vehicles.add(v);
	}
	void exit(Vehicle v) {
		vehicles.remove(v);
	}
	public void setWeather(Weather w) throws IllegalArgumentException {
		if(w != null) {
			this.weather = w;
		}
		else {
			throw new IllegalArgumentException("Weather is null");
		}
	}
	void addContamination(int c) throws IllegalArgumentException {
		if(c>0) {
			this.totalCont += c;
		}
		else {
			throw new IllegalArgumentException("Only Greta can have negative contamination values");
		}
	}
	void advance(int time) {
		reduceTotalContamination();
		updateSpeedLimit();
		for (Vehicle v: vehicles) {
			v.setSpeed(calculateVehicleSpeed(v));
			v.advance(1);//YO CREO QUE ESO ES 1 pero se lo puedo preguntar a profe y asi nos hacemoos amiguis
			vehicles.sort(v);
		}
		// Hay que revisar los sorts, apuntes del profe 
	}
	public JSONObject report() throws JSONException {
		
			StringBuilder sb = new StringBuilder();
			String id = "\" id \" :  \" " + this._id + "\",";
			String sp = "\" speedlimit \" :   " + this.maxSpeed + ",";
			String wea = "\" weather \" :  \" " + this.weather + ",";
			String co2= "\" co2 \" :  \" " + this.contLimit + ",";
			String ve = "\" vehicles \" :  \" " + this.vehicles + ",";
			
			return new JSONObject( sb.append(id).append(sp).append(wea).append(co2).append(ve).toString());
	}
	public Junction getDestJunc() {
		return this.destJunc;
	}
}
