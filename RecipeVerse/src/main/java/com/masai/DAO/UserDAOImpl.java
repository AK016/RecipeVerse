package com.masai.DAO;

import com.masai.DTO.CustomerDTO;
import com.masai.utility.EmUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

public class UserDAOImpl implements UserDAO {

	@Override
	public CustomerDTO findUserByUsername(String username) {
	    EntityManager em = null;

	    try {
	        em = EmUtils.getEntityManager();
	        return em.createQuery("SELECT u FROM CustomerDTO u WHERE u.name = :username", CustomerDTO.class)
	                .setParameter("username", username)
	                .getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}


	@Override
	public boolean saveUser(CustomerDTO user) {
		EntityManager em = null;
		EntityTransaction transaction = null;

		try {
			em = EmUtils.getEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// Implement the login method
	@Override
	public boolean login(String username, String password, String role) {
		CustomerDTO user = findUserByUsername(username);
		if (user != null && user.getPassword().equals(password) && user.getRole().equals(role)) {
			return true;
		}
		return false;
	}

	// Implement the signUp method
	@Override
	public boolean signUp(String username, String password, String role) {
		CustomerDTO user = new CustomerDTO();
		user.setName(username);
		user.setPassword(password);
		user.setRole(role);

		return saveUser(user);
	}

	@Override
	public boolean saveUser(String username, String email, String password, String role) {
		EntityManager em = null;
		EntityTransaction transaction = null;

		try {
			em = EmUtils.getEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			CustomerDTO user = new CustomerDTO();
			user.setName(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			em.persist(user);

			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
