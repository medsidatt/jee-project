package mr.iscae.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mr.iscae.Directeur;
import mr.iscae.Magasin;
import mr.iscae.Stock;
import mr.iscae.User;

public class UserService {

	 private static final Map<Integer, User> usersMap = new HashMap<>();
	 private static final List<Stock> stocks = new ArrayList<Stock>();

	    static {
	    	usersMap.put(1, new User(1, "directeur", "directeur", "directeur", new Magasin("magasin1", null)));
	    	usersMap.put(2, new User(2, "admin", "admin", "admin"));

	    }

	    public List<User> getUsersByRole(String role) {
	        List<User> usersByRole = new ArrayList<>();
	        for (User user : usersMap.values()) {
	            if (user.getRole().equals(role)) {
	                usersByRole.add(user);
	            }
	        }
	        return usersByRole;
	    }

	    public Map<Integer, User> getUsersMap() {
	        return usersMap;
	    }
}
