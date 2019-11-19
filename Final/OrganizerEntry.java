package Final;

public class OrganizerEntry {

	int id;
	static int customerId = 0;
	String courseNumber, courseName, assignment;
	String done = "!!!";
	
	public OrganizerEntry() {
		super();
	}
	public OrganizerEntry(int id, String courseNumber, String courseName, String assignment) {
		//super();
		this.id = id;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.assignment = assignment;
	}
	public OrganizerEntry(String courseNumber, String courseName, String assignment) {
		//super();
		this.id = customerId++;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.assignment = assignment;
	}
	public OrganizerEntry(int id, String courseNumber, String courseName) {
		//super();
		this.id = id;
		this.courseNumber = courseNumber;
		this.courseName = courseName;
	}
	public OrganizerEntry(String courseNumber, String courseName) {
		//super();
		this.courseNumber = courseNumber;
		this.courseName = courseName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public String getDone() {
		return done;
	}
	public void setDone(String done) {
		this.done = done;
	}
}
