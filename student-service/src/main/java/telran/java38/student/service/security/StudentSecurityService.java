package telran.java38.student.service.security;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.java38.student.dao.StudentMongoRepository;
import telran.java38.student.dto.exceptions.AuthException;
import telran.java38.student.dto.exceptions.FirbiddenException;
import telran.java38.student.model.Student;

@Service
public class StudentSecurityService {
	
//	@Autowired
	StudentMongoRepository studentRepository;
	
	public void updateStudentValidate(Integer id, String token) {
		Credential credential = decodeToken(token);
		Student student = studentRepository.findById(credential.getId()).orElseThrow(() -> new AuthException());
		if(!student.getPassword().equals(credential.getPassword())) {
			throw new AuthException();
		}
		if(!student.getId().equals(id)) {
			throw new FirbiddenException();
		}
	}

	private Credential decodeToken(String token) {
		try {
			int index = token.indexOf(" ");
			token = token.substring(index + 1);
			byte[] bytesDecode = Base64.getDecoder().decode(token);
			String token1 = new String(bytesDecode);
			String[] credentials = token1.split(":");
			return new Credential(Integer.parseInt(credentials[0]), credentials[1]);
		} catch (Exception e) {
			throw new AuthException();
		}
	}
}
