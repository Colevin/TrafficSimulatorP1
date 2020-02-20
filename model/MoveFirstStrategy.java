package simulator.model;

import java.util.ArrayList;
import java.util.List;

public class MoveFirstStrategy implements DequeuingStrategy{
	List<Vehicle> onlyFirst = new ArrayList<>();
	public List<Vehicle> dequeue(List<Vehicle> q) {
		onlyFirst.add(q.get(0));
		return onlyFirst;
	}
}
