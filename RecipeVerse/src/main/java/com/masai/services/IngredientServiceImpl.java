package com.masai.services;

import java.util.List;

import com.masai.DAO.IngredientDAO;
import com.masai.DTO.IngredientDTO;
import com.masai.Exceptions.NoRecordFoundException;
import com.masai.Exceptions.SomethingWentWrongException;

public class IngredientServiceImpl implements IngredientService {
	
	private IngredientDAO ingredientDAO;

    public IngredientServiceImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

//	IngredientDAO ingredientDAO=new IngredientDAOImpl();
	
	@Override
	public void saveIngredient(IngredientDTO ingredient) {
		ingredientDAO.saveIngredient(ingredient);
	}

	@Override
	public void updateIngredient(IngredientDTO ingredient) {
		ingredientDAO.updateIngredient(ingredient);
	}

	@Override
	public void deleteIngredient(Long ingredientId) throws NoRecordFoundException {
		ingredientDAO.deleteIngredient(ingredientId);
	}

	@Override
	public IngredientDTO getIngredientById(Long ingredientId)
			throws NoRecordFoundException, SomethingWentWrongException {
		return ingredientDAO.getIngredientById(ingredientId);
	}

	@Override
	public List<IngredientDTO> getIngredientsByRecipeId(Long recipeId) {
		return ingredientDAO.getIngredientsByRecipeId(recipeId);
	}

	
}
