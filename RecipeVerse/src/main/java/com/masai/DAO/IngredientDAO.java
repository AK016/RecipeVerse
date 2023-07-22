package com.masai.DAO;

import java.util.List;

import com.masai.DTO.IngredientDTO;

public interface IngredientDAO {
	void saveIngredient(IngredientDTO ingredient);
    void updateIngredient(IngredientDTO ingredient);
    void deleteIngredient(Long ingredientId);
    IngredientDTO getIngredientById(Long ingredientId);
    List<IngredientDTO> getIngredientsByRecipeId(Long recipeId);
}
