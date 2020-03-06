package simulator.model;


import java.util.List;

import simulator.misc.SortedArrayList;

public class TrafficSimulator {
	private RoadMap roadMap;
	private List<Event> listEvent;
	private int time;
	public TrafficSimulator() {
		this.time = 0;
		this.listEvent = new SortedArrayList<>();
		this.roadMap = new RoadMap();
	}
	
	public void addEvent(Event e) {
		if(e != null) {
			this.listEvent.add(e);
		}
	}
	public void advance() {
		this.time ++;
		for(Event e: listEvent) {
			if(e.getTime() == this.time) {
				e.execute(roadMap);
				listEvent.remove(e);
			}
		}
		//COMO NO PUEDO ACCEDER A LAS JUNCTIONS DESDE AQUI HAGO LAS FUNCIONES EN EL PROPIO ROAD MAP
		//DE ESTA FORMA NO SE ROMPE LA ENCAPSULACION CREO
		roadMap.advanceJunctions(time);
		roadMap.advanceRoads(time);
	}
	public void reset() {
		roadMap.reset();
		listEvent.clear();
		this.time = 0;
	}
	//public JSONObject report() {
		
	//}
}
