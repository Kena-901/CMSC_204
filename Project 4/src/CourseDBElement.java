
public class CourseDBElement implements Comparable <CourseDBElement>{
	private String ID;
	private int crn;
	private int credits;
	private String roomNumber;
	private String instructorName;
	
	/**
	 * defualt constructor for CourseDBElement
	 */
	public CourseDBElement()
	{
	 this.ID = null;
	 this.crn = 0;
	 this.credits = 0;
	 this.roomNumber = null;
	 this.instructorName = null;
	}
	
	/**
	 * Constructor for CourseDBElement with specified fields
	 * @param courseID
	 * @param crn
	 * @param credits
	 * @param roomNumber
	 * @param instructorName
	 */
	public CourseDBElement(String courseID, int crn, int credits, String roomNumber, String instructorName)
	{
	 this.ID = courseID;
	 this.crn = crn;
	 this.credits = credits;
	 this.roomNumber = roomNumber;
	 this.instructorName = instructorName;
	}
	
	/**
	 * setter and getter methods for class fields
	 */
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getCRN() {
		return crn;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNum() {
		return roomNumber;
	}

	public void setRoomNum(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	/**
	 * overriden compareTo method for CourseDBElement class
	 */
	@Override
	public int compareTo(CourseDBElement check) {
		
		if(check.crn==crn) {
			return 0;
		}
		else if(check.crn<crn) {
			return -1;
		}
		else 
			return 1;
		}

	/**
	 * hashcode generator for CourseDBElement class
	 */
	public int hashCode() {
		String code=String.valueOf(crn);
		return code.hashCode();
	}
	
	/**
	 * toString method for CourseDBElement class
	 */
	public String toString() {
		String course="Course:"+ID+" CRN:"+crn+" Credits:"+credits+" Instructor:"+instructorName+" Room:"+roomNumber;
		return course;
	}

}
