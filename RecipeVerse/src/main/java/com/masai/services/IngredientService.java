package com.masai.services;

import java.util.List;

import com.masai.DTO.IngredientDTO;
import com.masai.Exceptions.NoRecordFoundException;
import com.masai.Exceptions.SomethingWentWrongException;

public interface IngredientService {
	void saveIngredient(IngredientDTO ingredient);
    void updateIngredient(IngredientDTO ingredient);
    void deleteIngredient(Long ingredientId) throws NoRecordFoundException;
    IngredientDTO getIngredientById(Long ingredientId) throws NoRecordFoundException, SomethingWentWrongException;
    List<IngredientDTO> getIngredientsByRecipeId(Long recipeId);
}
