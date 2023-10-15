package com.masai.services;

import java.util.List;

import com.masai.DTO.RecipeDTO;

public interface RecipeService {
	String saveRecipe(RecipeDTO recipe);
	RecipeDTO getRecipeById(Long id);
    void updateRecipe(RecipeDTO recipe);
    void deleteRecipe(long id);
    List<RecipeDTO> getAllRecipes();
}
