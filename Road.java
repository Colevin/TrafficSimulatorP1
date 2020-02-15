package simulator.model;

import java.util.List;

public abstract class Road extends SimulatedObject {
	private Junction srcJunc;
	private Junction destJunc;	
	private int length;
	private int maxSpeed;
	private int contLimit;
	private int cuMaxSpeed;
	private Weather weather;
	private int totalCont;
	private List <Vehicle> vehicles;
	
	Road(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length, Weather weather) {
		super(id);
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
	void setWeather(Weather w) throws IllegalArgumentException {
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
}
