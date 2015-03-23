package action;

public class EnrollInfo {

	private String EnrollId;
	private String StudentId;
	private String CourseId;
	private String sem;
	
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getEnrollId() {
		return EnrollId;
	}
	public void setEnrollId(String enrollId) {
		EnrollId = enrollId;
	}
}
