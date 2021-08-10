package telran.java38.student.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = {"id"})
@Document(collection = "post")		//прописываем имя коллекции в монго ДБ либо указываем имя коллекции к которой нужно подключится
public class Student {
	@Id
	Integer id;
	@Setter
	String name;
	@Setter
	String password;
	String group;
	Map<String, Integer> scores;
	
	public Student(Integer id, String name, String password, String group) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.group = group;
		scores = new HashMap<>();
	}
	
	public boolean addScore(String exam, int score) {	// метод добавления оценок студенту
		return scores.put(exam, score) == null;
	}
	
	
}
