package com.masai.DAO;

import java.util.List;

import com.masai.DTO.RecipeDTO;
import com.masai.utility.EmUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class RecipeDAOImpl implements RecipeDAO {

    // Method to save a new recipe to the database
    @Override
    public String saveRecipe(RecipeDTO recipe) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EmUtils.getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(recipe);
            et.commit();
            return "Recipe Added Successfully";
        } catch (PersistenceException e) {
            et.rollback();
            return "Unable to add Recipe " + e.getMessage();
        } finally {
            em.close();
        }
    }

    // Method to update an existing recipe in the database
    @Override
    public void updateRecipe(RecipeDTO recipe) {
        EntityManager em = null;
        try {
            em = EmUtils.getEntityManager();
            em.getTransaction().begin();
            em.merge(recipe);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete a recipe from the database
    @Override
    public void deleteRecipe(Long recipeId) {
        EntityManager em = null;
        try {
            em = EmUtils.getEntityManager();
            em.getTransaction().begin();
            RecipeDTO recipe = em.find(RecipeDTO.class, recipeId);
            if (recipe != null) {
                em.remove(recipe);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to retrieve a recipe by its unique ID
    @Override
    public RecipeDTO getRecipeById(Long recipeId) {
        EntityManager em = null;
        try {
            em = EmUtils.getEntityManager();
            return em.find(RecipeDTO.class, recipeId);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to retrieve all recipes from the database
    @Override
    public List<RecipeDTO> getAllRecipes() {
        EntityManager em = null;
        try {
            em = EmUtils.getEntityManager();

            // Create a CriteriaBuilder to build a query
            CriteriaBuilder cb = em.getCriteriaBuilder();

            // Create a CriteriaQuery for RecipeDTO
            CriteriaQuery<RecipeDTO> cq = cb.createQuery(RecipeDTO.class);

            // Set the root entity (from clause) for the query
            Root<RecipeDTO> root = cq.from(RecipeDTO.class);

            // Define the select clause
            cq.select(root);

            // Create a TypedQuery using the CriteriaQuery
            TypedQuery<RecipeDTO> query = em.createQuery(cq);

            // Execute the query and return the list of RecipeDTO
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}

