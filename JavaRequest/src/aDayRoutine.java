import java.util.ArrayList;
import java.util.LinkedHashMap;

public class aDayRoutine {
	
	LinkedHashMap<String,ArrayList<aSinglePeriod> > aDayRoutineList;

	public aDayRoutine() {
		super();
		aDayRoutineList = new LinkedHashMap<String,ArrayList<aSinglePeriod> >();
	}
	
	public void add(String key, ArrayList<aSinglePeriod> value) {
		aDayRoutineList.put(key, value);
	}

	@Override
	public String toString() {
		return "aDayRoutine [aDayRoutineList=" + aDayRoutineList + "]";
	}
	
	public ArrayList<aSinglePeriod> get(String key) {
		return aDayRoutineList.get(key);
		
	}
	
	
	

}

