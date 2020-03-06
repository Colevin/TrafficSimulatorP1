package simulator.model;

import java.util.List;

import simulator.misc.Pair;

public class SetWeatherEvent extends Event {
	private  List<Pair<String,Weather>> ws;
	public SetWeatherEvent(int time, List<Pair<String,Weather>> ws) {
		super(time);
		if(ws == null) {
			throw new IllegalArgumentException();
		}
		else this.ws = ws;
		}

	@Override
	void execute(RoadMap map) {
		for(Pair<String, Weather> p: ws) {
			for(Road r: map.getRoads()) {
				if(r.getId().equals(p.getFirst())){
					r.setWeather(p.getSecond());
			}
				//EXCEPTION IF THE ROAD DOES NOT EXIs
			}
		}
	}

}
