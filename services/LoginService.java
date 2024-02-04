package mr.iscae.services;

import jakarta.ws.rs.core.Response;
import mr.iscae.Admin;
import mr.iscae.Magasin;
import mr.iscae.User;

public class LoginService {

	private final UserService userService = new UserService();

    public boolean authenticate(String username, String password) {
        for (User user : userService.getUsersMap().values()) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String getUserRole(String username) {
        for (User user : userService.getUsersMap().values()) {
            if (user.getUserName().equals(username)) {
                return user.getRole();
            }
        }
        return null;
    }
    
    public Magasin getUserMagasin(String username) {
    	 for (User user : userService.getUsersMap().values()) {
             if (user.getUserName().equals(username)) {
                 return user.getMagasin();
             }
         }
         return null;
    }

    
//    public Response changePassword(String oldPassword, String newPassword) {
//    	User user = getUserByName("admin");
//    	if(user != null && oldPassword.equals(user.getPassword())) {
//    		user.setPassword(newPassword);
//    		Response.ok(user).build();
//    	}
//    	return Response.serverError().entity("Le mot de pass n'est pas changer").build();
//    }
//    
    public User getUserByName(String username) {
    	 for (User user : userService.getUsersMap().values()) {
             if (user.getUserName().equals(username)) {
                 return user;
             }
         }
         return null;
    }
}
