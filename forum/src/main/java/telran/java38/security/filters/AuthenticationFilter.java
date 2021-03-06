package telran.java38.security.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.java38.user.dao.AccountRespository;

@Service
public class AuthenticationFilter implements Filter {
	
	@Autowired
	AccountRespository accountRepository;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		System.out.println(request.getServletPath());
		System.out.println(request.getMethod());
		response.sendError(418);
		System.out.println(request.getHeader("Authorization"));
		String auth = request.getHeader("Authorization");
		if(auth == null) {
			response.sendError(401, "Header Authorization is not exists");
			return;
		} else {
			
		}
		chain.doFilter(request, response);

	}

}
