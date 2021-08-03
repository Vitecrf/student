package telran.java38.student.dto;

public class StudentNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3627744234180923074L;
	
	public StudentNotFoundException() {
	}
	
	public StudentNotFoundException(int id) {
		super("student id: " + id + ", not found");
	}
}
