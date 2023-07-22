package com.masai.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmUtils {
	static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("recipeverse");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void closeEntityManagerFactory() {
        emf.close();
    }
}
