package com.masai.services;

import com.masai.DAO.RecipeDAO;
import com.masai.DTO.RecipeDTO;

public class RecipeServiceImpl implements RecipeService {

    private RecipeDAO recipeDAO;

    // Constructor or setter injection for RecipeDAO

    @Override
    public RecipeDTO getRecipeById(Long id) {
        return recipeDAO.getRecipeById(id);
    }

    @Override
    public void saveRecipe(RecipeDTO recipe) {
        recipeDAO.saveRecipe(recipe);
    }

    @Override
    public void updateRecipe(RecipeDTO recipe) {
        recipeDAO.updateRecipe(recipe);
    }

    @Override
    public void deleteRecipe(long id) {
        recipeDAO.deleteRecipe(id);
    }
}
