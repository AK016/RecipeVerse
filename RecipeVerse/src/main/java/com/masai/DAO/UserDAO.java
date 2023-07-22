package com.masai.DAO;

import com.masai.DTO.CustomerDTO;

public interface UserDAO {
    CustomerDTO findUserByUsername(String username);

    boolean saveUser(CustomerDTO user);
    
    // Add the login and signUp methods
    boolean login(String username, String password, String role);

    boolean signUp(String username, String password, String role);
    boolean saveUser(String username, String email, String password, String role);
}
