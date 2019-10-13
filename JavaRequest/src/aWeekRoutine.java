import java.util.ArrayList;

public class aWeekRoutine {
	public ArrayList<aDayRoutine> weekRoutine;

	public aWeekRoutine(ArrayList<aDayRoutine> weekRoutine) {
		super();
		this.weekRoutine = weekRoutine;
	}

	@Override
	public String toString() {
		return "aWeekRoutine [weekRoutine=" + weekRoutine + "]";
	}

	public ArrayList<aDayRoutine> getWeekRoutine() {
		return weekRoutine;
	}

	public void setWeekRoutine(ArrayList<aDayRoutine> weekRoutine) {
		this.weekRoutine = weekRoutine;
	}
	
	public void addToWeekROutine(aDayRoutine adayroutine) {
		weekRoutine.add(adayroutine);
	}
}
