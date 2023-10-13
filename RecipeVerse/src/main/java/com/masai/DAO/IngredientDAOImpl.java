package com.masai.DAO;

import java.util.List;

import com.masai.DTO.IngredientDTO;
import com.masai.Exceptions.NoRecordFoundException;
import com.masai.Exceptions.SomethingWentWrongException;
import com.masai.utility.EmUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class IngredientDAOImpl implements IngredientDAO {

    @Override
    public IngredientDTO getIngredientById(Long id) throws SomethingWentWrongException {
        IngredientDTO ingredient = null;
        EntityManager em = null;

        try {
            // Get an EntityManager from the utility class
            em = EmUtils.getEntityManager();

            // Find the IngredientDTO by its ID
            ingredient = em.find(IngredientDTO.class, id);

            // Check if the ingredient is null and throw an exception if not found
            if (ingredient == null) {
                throw new NoRecordFoundException("Invalid Ingredient Id");
            }
        } catch (PersistenceException | NoRecordFoundException e) {
            // Handle any exceptions that occur during database operations
            throw new SomethingWentWrongException("Unable to get Ingredient, try again later");
        } finally {
            if (em != null) {
                // Close the EntityManager if it was opened
                em.close();
            }
        }
        return ingredient;
    }

    @Override
    public void saveIngredient(IngredientDTO ingredient) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            // Get an EntityManager from the utility class
            em = EmUtils.getEntityManager();
            et = em.getTransaction();

            // Begin the transaction
            et.begin();

            // Persist the ingredient to the database
            em.persist(ingredient);

            // Commit the transaction
            et.commit();
        } catch (PersistenceException e) {
            if (et != null) {
                // Rollback the transaction if an exception occurs
                et.rollback();
            }
        } finally {
            if (em != null) {
                // Close the EntityManager if it was opened
                em.close();
            }
        }
    }

    @Override
    public void updateIngredient(IngredientDTO ingredient) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            // Get an EntityManager from the utility class
            em = EmUtils.getEntityManager();
            et = em.getTransaction();

            // Begin the transaction
            et.begin();

            // Merge (update) the ingredient in the database
            em.merge(ingredient);

            // Commit the transaction
            et.commit();
        } catch (PersistenceException e) {
            if (et != null) {
                // Rollback the transaction if an exception occurs
                et.rollback();
            }
            // Handle the exception or log the error
        } finally {
            if (em != null) {
                // Close the EntityManager if it was opened
                em.close();
            }
        }
    }

    @Override
    public void deleteIngredient(Long ingredientId) throws NoRecordFoundException {
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            // Get an EntityManager from the utility class
            em = EmUtils.getEntityManager();
            et = em.getTransaction();

            // Begin the transaction
            et.begin();

            // Find the IngredientDTO by its ID
            IngredientDTO ingredient = em.find(IngredientDTO.class, ingredientId);

            // Check if the ingredient is null and throw an exception if not found
            if (ingredient == null) {
                throw new NoRecordFoundException("Invalid Ingredient Id");
            }

            // Remove (delete) the ingredient from the database
            em.remove(ingredient);

            // Commit the transaction
            et.commit();
        } catch (PersistenceException e) {
            if (et != null) {
                // Rollback the transaction if an exception occurs
                et.rollback();
            }
            // Handle the exception or log the error
        } finally {
            if (em != null) {
                // Close the EntityManager if it was opened
                em.close();
            }
        }
    }

    public List<IngredientDTO> getAllIngredients() {
        EntityManager em = null;

        try {
            // Get an EntityManager from the utility class
            em = EmUtils.getEntityManager();

            // Query to retrieve all ingredients
            return em.createQuery("SELECT i FROM IngredientDTO i", IngredientDTO.class).getResultList();
        } finally {
            if (em != null) {
                // Close the EntityManager if it was opened
                em.close();
            }
        }
    }

    @Override
    public List<IngredientDTO> getIngredientsByRecipeId(Long recipeId) {
        // TODO Auto-generated method stub
        return null;
    }
}
