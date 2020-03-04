package simulator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class Junction extends SimulatedObject{
	private List <Road> listIncRoad; //Lista de carreteras que llegan a la juncion
	private Map <Junction,Road> map; //Tiene 2 valores, la juncion J está conectada con la carretera C. Para saber qué carretera llega a qué juncion
	private List<List<Vehicle>> listQue; //lista de listas de vehiculos de cada carretera
	private int greenIndex; //indice de la carretera de llegada que esta a verde
	private int lastSwTime; // tiempo que hace que se cambio el semaforo a verde
	private LightSwitchingStrategy lighStrat;
	private DequeuingStrategy deqStrat;
	private int x;
	private int y;
	private Map<Road, List<Vehicle>> roadList;
	

	Junction(String id, LightSwitchingStrategy lsStrategy, DequeuingStrategy dqStrategy, int xCoor, int yCoor) throws IllegalArgumentException {
			super(id);
			//AQUI HAY QUE HACER EL TEMA DE LAS EXCEPCIONES
			this.map = new HashMap<>();
			this.listIncRoad = new ArrayList<>();
			this.listQue = new LinkedList<>();
			this.roadList = new HashMap<>();
			this.lighStrat = lsStrategy;
			this.deqStrat = dqStrategy;
			this.x = xCoor;
			this.y = yCoor;
			this.greenIndex = 0;
			this.lastSwTime = 0;
	}
	
	 void addIncommingRoad(Road r) {
		if(r.destJunc != this) {
			throw new IllegalArgumentException("The junction of arrival and destination are not the same");
		}
		else {
		listIncRoad.add(r);
		List<Vehicle> que = new LinkedList<>();
		listQue.add(que);
		roadList.put(r, que);
		}
		
	}
	void addOutGotingRoad(Road r) {
		map.put(this,r);
		//CHECK QUE NO HAYA OTRA CARRETERA QUE VAYA A LA JUNCTION Y Q R SEA UNA CARRETERA DE SALIDA
	}
	void enter(Vehicle v) {
		listQue.add((List<Vehicle>) v);
	}
	Road roadTo(Junction j) {
		
	}

	@Override
	void advance(int time) {
		
	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean equals(Object obj) {
		return this._id == (Junction)obj._id;
	}

}
