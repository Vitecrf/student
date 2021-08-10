package telran.java38.user.service.secutity;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.java38.forum.model.Post;
import telran.java38.user.dao.AccountRespository;
import telran.java38.user.model.UserProfile;
import telran.java38.user.service.AccountService;

@Service
public class UserSecurityService {
	
//	@Autowired
//	AccountService accountService;
//	
//	public void updatePassword(String login, String token) throws AuthException, FibiddenException {
//		UserSecurity userSecurity = decoderToken(token);
//		UserProfile post = accountService.findUserById(userSecurity.getLogin())//.orElseThrow(() -> new AuthException());
//		if(!post.getPassword().equals(post.getPassword())) {
//			throw new AuthException();
//		}
//		if(!post.getLogin().equals(login)) {
//			throw new FibiddenException();
//		}
//	}
//
//	private UserSecurity decoderToken(String auth) throws AuthException {
//		try {
//			int index = auth.indexOf(" ");
//			auth = auth.substring(index + 1);
//			byte[] bytesDecode = Base64.getDecoder().decode(auth);
//			String token = new String(bytesDecode);
//			String[] credentials = token.split(":");
//			return new UserSecurity(credentials[0], credentials[1]);
//		} catch (Exception e) {
//			throw new AuthException();
//		}
//	}
}
