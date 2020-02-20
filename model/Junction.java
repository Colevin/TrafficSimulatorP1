package simulator.model;

import java.util.List;

import org.json.JSONObject;

public class Junction extends SimulatedObject{
	protected List <Road> ListIncRoad;
	

	Junction(String id, LightSwitchingStrategy lsStrategy, DequeuingStrategy dqStrategy, int xCoor, int yCoor) {
			super(id);

	}

	@Override
	void advance(int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}

}
