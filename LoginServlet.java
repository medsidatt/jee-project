package mr.iscae;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mr.iscae.services.LoginService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final LoginService loginService = new LoginService();
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//    	HttpSession session = request.getSession();
//    	boolean isLogedIn = session != null && session.getAttribute("role") != null;
//    	
//    	if(isLogedIn) {
//    		String role = session.getAttribute("role").toString();
//    		response.sendRedirect(request.getContextPath() + "/secure/" + role + "/produits");
//    	}
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Login Form</title></head><body>");
        out.println("<h2>Login Form</h2>");
        out.println("<form method='post' action='" + request.getContextPath() + "/login'>");
        out.println("Username: <input type='text' name='username'><br>");
        out.println("Password: <input type='password' name='password'><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginService.authenticate(username, password)) {
        	String role = loginService.getUserRole(username);
        	System.out.println(role);
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            session.setAttribute("magasine", role);

            response.sendRedirect(request.getContextPath() + "/secure/" + role + "/produits");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?error=Vous n'avez pas l'access");
        }
    }
}
