package simulator.model;

import java.util.ArrayList;
import java.util.List;

public class MostCrowdedStrategy implements LightSwitchingStrategy{

	private int timeSlot;
	public MostCrowdedStrategy(int timeSlot) {
		this.timeSlot = timeSlot;
	}
	public int chooseNextGreen(List<Road> roads, List<List<Vehicle>> qs, int currGreen, int lastSwitchingTime, int currTime) {
		if(roads.isEmpty()) {
			return -1;
		} 
		else if(currGreen == -1) {
			List<Vehicle> largestQ = new ArrayList<>();
			
			for	(List<Vehicle> vl: qs) {
				if(largestQ.size() < vl.size()) {
					largestQ = vl;
				}
			}
			return largestQ.size();
		}
		else if(currTime-lastSwitchingTime < timeSlot) {
			return currGreen;
		}
		else {
			int[] rearrange = new int[qs.size()] ;
			int tempGreen =0, tempPos;
			for	(int i = currGreen+1; i < qs.size();i++) {
				rearrange[tempGreen] = qs.get(i).size();
				tempGreen++;
				}
			for(int i = 0; i < currGreen+1; i++) {
				rearrange[tempGreen] = qs.get(i).size();
				tempGreen++;
				}
			for(int i = 0; i < rearrange.length-1; i++)	{
				if(rearrange[i]>rearrange[i+1]){
					tempPos = i;
				}
			}
		}

		}
}

	
