package com.masai.DAO;

import java.util.List;

import com.masai.DTO.RecipeDTO;

public interface RecipeDAO {
	String saveRecipe(RecipeDTO recipe);
    void updateRecipe(RecipeDTO recipe);
    void deleteRecipe(Long recipeId);
    RecipeDTO getRecipeById(Long recipeId);
    List<RecipeDTO> getAllRecipes();
}
