package mr.iscae.services;

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
}
