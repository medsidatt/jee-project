package mr.iscae;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebFilter("/secure/*")
public class AuthFilter implements Filter  {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("username") != null;
        String baseUrl = httpRequest.getContextPath();

        if(loggedIn) {
        	String role = session.getAttribute("role").toString();
        	if(role.equals("admin")) {
        		httpResponse.sendRedirect(baseUrl + "/secure/" + role);
        	}
        }
	}
	
	
}
