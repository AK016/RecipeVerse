package com.masai.DAO;

import java.util.List;

import com.masai.DTO.RecipeDTO;

/**
 * This interface defines the methods that a data access object (DAO) for
 * managing recipes should implement.
 */
public interface RecipeDAO {

	/**
	 * Saves a recipe to the data source.
	 *
	 * @param recipe The RecipeDTO object to be saved.
	 * @return A unique identifier or reference to the saved recipe.
	 */
	String saveRecipe(RecipeDTO recipe);

	/**
	 * Updates an existing recipe in the data source.
	 *
	 * @param recipe The RecipeDTO object containing the updated information.
	 */
	void updateRecipe(RecipeDTO recipe);

	/**
	 * Deletes a recipe from the data source by its unique identifier.
	 *
	 * @param recipeId The unique identifier of the recipe to be deleted.
	 */
	void deleteRecipe(Long recipeId);

	/**
	 * Retrieves a recipe from the data source by its unique identifier.
	 *
	 * @param recipeId The unique identifier of the recipe to be retrieved.
	 * @return The RecipeDTO object representing the retrieved recipe.
	 */
	RecipeDTO getRecipeById(Long recipeId);

	/**
	 * Retrieves a list of all recipes stored in the data source.
	 *
	 * @return A list of RecipeDTO objects representing all available recipes.
	 */
	List<RecipeDTO> getAllRecipes();
}
