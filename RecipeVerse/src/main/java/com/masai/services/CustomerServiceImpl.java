// CustomerServiceImpl.java
package com.masai.services;

import com.masai.DAO.UserDAO;
import com.masai.DTO.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
    private final UserDAO userDAO;

    public CustomerServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        // Implement the logic to get a customer by ID
        return null;
    }

    @Override
    public boolean login(String username, String password, String role) {
        CustomerDTO user = userDAO.findUserByUsername(username); 
        return user != null && user.getPassword().equals(password) && user.getRole().equals(role);
    }

    @Override
    public boolean signUp(String username, String password, String role) {
        // Implement the sign-up logic using UserDAO
        CustomerDTO user = new CustomerDTO();
        user.setName(username);
        user.setPassword(password);
        user.setRole(role);
        userDAO.saveUser(user);
        return true; // Return true to indicate successful sign-up
    }
    public boolean signUp(CustomerDTO user) {
        // Call the modified saveUser method in the UserDAOImpl class
        return userDAO.saveUser(user);
    }
}
