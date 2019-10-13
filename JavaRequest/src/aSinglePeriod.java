
public class aSinglePeriod {
	public String courseCode;
	public String teachersName;
	public String classRoomNo;
	public String classTime;
	public boolean hasClass = true;

	public aSinglePeriod(String courseCode, String teachersName, String classRoomNo, String classTime,
			boolean hasClass) {
		super();
		this.courseCode = courseCode;
		this.teachersName = teachersName;
		this.classRoomNo = classRoomNo;
		this.classTime = classTime;
		this.hasClass = hasClass;
	}
	
	
	

	public aSinglePeriod(String courseCode, String teachersName, String classRoomNo, boolean hasClass) {
		super();
		this.courseCode = courseCode;
		this.teachersName = teachersName;
		this.classRoomNo = classRoomNo;
		this.hasClass = hasClass;
	}




	public aSinglePeriod(boolean hasClass) {
		super();
		this.hasClass = hasClass;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getTeachersName() {
		return teachersName;
	}

	public void setTeachersName(String teachersName) {
		this.teachersName = teachersName;
	}

	public String getClassRoomNo() {
		return classRoomNo;
	}

	public void setClassRoomNo(String classRoomNo) {
		this.classRoomNo = classRoomNo;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	public boolean isHasClass() {
		return hasClass;
	}

	public void setHasClass(boolean hasClass) {
		this.hasClass = hasClass;
	}

	@Override
	public String toString() {
		return "aSinglePeriod [courseCode=" + courseCode + ", teachersName=" + teachersName + ", classRoomNo="
				+ classRoomNo + ", ClassTime=" + classTime + ", hasClass=" + hasClass + "]";
	}

}
