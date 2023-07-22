package com.masai.services;

import com.masai.DTO.RecipeDTO;

public interface RecipeService {
	RecipeDTO getRecipeById(Long id);
    void saveRecipe(RecipeDTO recipe);
    void updateRecipe(RecipeDTO recipe);
    void deleteRecipe(long id);
}
