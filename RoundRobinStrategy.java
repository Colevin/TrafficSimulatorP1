package simulator.model;

import java.util.List;

public class RoundRobinStrategy implements LightSwitchingStrategy{

	private int timeSlot;
	public RoundRobinStrategy(int timeSlot) {
		this.setTimeSlot(timeSlot);
	}
	public int chooseNextGreen(List<Road> roads, List<List<Vehicle>> qs, int currGreen, int lastSwitchingTime,
			int currTime) {
		if(roads.isEmpty()) {
			return -1;
		}
		else if(currGreen == -1 ) {
			return roads[0].id;
		}
		else if(currGreen != -1 ) {
			return 0;
		}
		else if(currTime-lastSwitchingTime < timeSlot) {
			return currGreen;
		}
		else if(currTime-lastSwitchingTime >= timeSlot) {
			return currGreen +1 % roads.lenght;
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}


}
