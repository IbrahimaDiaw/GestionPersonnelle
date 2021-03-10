/**
 * 
 */
package com.db2g.Projetdb2g.Service;

import org.springframework.stereotype.Service;
import com.db2g.Projetdb2g.model.User;

/**
 * @author ibrahima
 *
 */
@Service
public interface  UserService {

	 public User findUserByEmail(String email);
	 
	 public void saveUser(User user);

}