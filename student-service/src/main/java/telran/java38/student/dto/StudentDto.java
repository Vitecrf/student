package telran.java38.student.dto;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder

public class StudentDto {
	Integer id;
	String name;
	String group;
	Map<String, Integer> scores;
}
