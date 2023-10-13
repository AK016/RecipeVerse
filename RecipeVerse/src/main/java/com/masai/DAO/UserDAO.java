package com.masai.DAO;

import com.masai.DTO.CustomerDTO;

/**
 * This interface defines the methods that a data access object (DAO) for
 * managing user data should implement.
 */
public interface UserDAO {

	/**
	 * Find a user by their username.
	 *
	 * @param username The username of the user to find.
	 * @return The CustomerDTO object representing the found user, or null if not
	 *         found.
	 */
	CustomerDTO findUserByUsername(String username);

	/**
	 * Save a user to the data source.
	 *
	 * @param user The CustomerDTO object representing the user to be saved.
	 * @return true if the user was successfully saved, false otherwise.
	 */
	boolean saveUser(CustomerDTO user);

	/**
	 * Log in a user with the given username and password, checking against the
	 * specified role.
	 *
	 * @param username The username of the user attempting to log in.
	 * @param password The password provided by the user for authentication.
	 * @param role     The role against which to check the user's credentials.
	 * @return true if the login was successful, false otherwise.
	 */
	boolean login(String username, String password, String role);

	/**
	 * Sign up a new user with the given username, password, and role.
	 *
	 * @param username The username of the new user.
	 * @param password The password for the new user.
	 * @param role     The role or type of the new user.
	 * @return true if the signup was successful, false otherwise.
	 */
	boolean signUp(String username, String password, String role);

	/**
	 * Save a user with extended information including email to the data source.
	 *
	 * @param username The username of the user.
	 * @param email    The email address of the user.
	 * @param password The password of the user.
	 * @param role     The role or type of the user.
	 * @return true if the user was successfully saved, false otherwise.
	 */
	boolean saveUser(String username, String email, String password, String role);
}
