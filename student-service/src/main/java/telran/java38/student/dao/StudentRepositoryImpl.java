package telran.java38.student.dao;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import telran.java38.student.model.Student;
//
////@Component
//
//public class StudentRepositoryImpl implements StudentRepository {
//	
//	Map<Integer, Student> students = new ConcurrentHashMap<>();		//создай если нет элемента или добавьеще один если такой элемент есть
//	
//	@Override
//	public boolean addStudent(Student student) {
//		return students.putIfAbsent(student.getId(), student) == null;
//	}
//
//	@Override
//	public Student findStudent(int id) {
//		return students.get(id);
//	}
//
//	@Override
//	public Student removeStudent(int id) {
//		return students.remove(id);
//	}
//	
//	@Override
//	public Student updateStudent(Student student) {
//		return students.replace(student.getId(), student);
//	}
//
//}
