package simulator.model;

public class CityRoad extends Road{

	void reduceTotalContamination() {
		int x = 0;
		switch (this.weather) {
			case WINDY: x = 10;
				break;
			case STORM: x = 10;
			 	break;	
			default: x = 2;
				break;
		}
		this.totalCont  = this.totalCont - x;
		if(this.totalCont < 0) {
			this.totalCont = 0;
		}
	}
	void updateSpeedLimit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	int calculateVehicleSpeed(Vehicle v) {
		v.speed = ((int)(((11.0- v.contClass)/11.0)*contLimit* this.cuMaxSpeed));
		return v.speed;
	}
}
