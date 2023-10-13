package com.masai.services;

import java.util.List;

import com.masai.DAO.RecipeDAO;
import com.masai.DAO.RecipeDAOImpl;
import com.masai.DTO.RecipeDTO;

public class RecipeServiceImpl implements RecipeService {

	@Override
    public String saveRecipe(RecipeDTO recipe) {
    	RecipeDAO recipeDAO=new RecipeDAOImpl();
        return recipeDAO.saveRecipe(recipe);
    }
	
	@Override
    public RecipeDTO getRecipeById(Long id) {
		RecipeDAO recipeDAO=new RecipeDAOImpl();
        return recipeDAO.getRecipeById(id);
    }

    @Override
    public void updateRecipe(RecipeDTO recipe) {
    	RecipeDAO recipeDAO=new RecipeDAOImpl();
        recipeDAO.updateRecipe(recipe);
    }

    @Override
    public void deleteRecipe(long id) {
    	RecipeDAO recipeDAO=new RecipeDAOImpl();
        recipeDAO.deleteRecipe(id);
    }

    @Override
    public List<RecipeDTO> getAllRecipes(){
    	RecipeDAO recipeDAO=new RecipeDAOImpl();
        return recipeDAO.getAllRecipes();
    }
}
