package com.masai.services;

import com.masai.DTO.IngredientDTO;

public interface IngredientService {
	IngredientDTO getIngredientById(Long id);
    void saveIngredient(IngredientDTO ingredient);
    void updateIngredient(IngredientDTO ingredient);
    void deleteIngredient(IngredientDTO ingredient);
}
