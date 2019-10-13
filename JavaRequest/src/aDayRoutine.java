import java.util.ArrayList;

public class aDayRoutine {
	public ArrayList<aSinglePeriod> aDayRoutineList;

	
	
	public aDayRoutine(ArrayList<aSinglePeriod> aDayRoutineList) {
		super();
		this.aDayRoutineList = aDayRoutineList;
	}

	
	public ArrayList<aSinglePeriod> getaDayRoutineList() {
		return aDayRoutineList;
	}


	public void setaDayRoutineList(ArrayList<aSinglePeriod> aDayRoutineList) {
		this.aDayRoutineList = aDayRoutineList;
	}

	
	@Override
	public String toString() {
		return "aDayRoutine [aDayRoutineList=" + aDayRoutineList + "]";
	}


	public void addToDayRoutine(aSinglePeriod asingleperiod) {
		aDayRoutineList.add(asingleperiod);		
	}
}

