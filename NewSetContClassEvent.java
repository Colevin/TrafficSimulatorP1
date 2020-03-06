package simulator.model;

import java.util.List;

import simulator.misc.Pair;

public class NewSetContClassEvent extends Event{
	private List<Pair<String,Integer>> cs;
	public NewSetContClassEvent(int time, List<Pair<String,Integer>> cs) {
		super(time);
		if(cs == null) {
			throw new IllegalArgumentException();
			}
		else {
			this.cs = cs;
			}
		}
	@Override
	void execute(RoadMap map) {
		for(Pair<String, Integer> p: cs) {
			for(Vehicle v: map.getVehicles()) {
				if(v.getId().equals(p.getFirst())){
					v.setContamination(p.getSecond());
			}
				//EXCEPTION IF THE CAR DOES NOT EXIs
			}
		}
	}
}
