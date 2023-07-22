// CustomerService.java
package com.masai.services;

import com.masai.DTO.CustomerDTO;

public interface CustomerService {
    CustomerDTO getCustomerById(Long id);
    boolean login(String username, String password, String role);
    boolean signUp(String username, String password, String role);
	boolean signUp(CustomerDTO newUser);
}
