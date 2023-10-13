package com.masai.DAO;

import java.util.List;

import com.masai.DTO.IngredientDTO;
import com.masai.Exceptions.NoRecordFoundException;
import com.masai.Exceptions.SomethingWentWrongException;

/**
 * This interface defines the methods that a data access object (DAO) for managing ingredients should implement.
 */
public interface IngredientDAO {

    /**
     * Saves an ingredient to the data source.
     *
     * @param ingredient The IngredientDTO object to be saved.
     */
    void saveIngredient(IngredientDTO ingredient);

    /**
     * Updates an existing ingredient in the data source.
     *
     * @param ingredient The IngredientDTO object containing the updated information.
     */
    void updateIngredient(IngredientDTO ingredient);

    /**
     * Deletes an ingredient from the data source by its unique identifier.
     *
     * @param ingredientId The unique identifier of the ingredient to be deleted.
     * @throws NoRecordFoundException If the specified ingredient does not exist in the data source.
     */
    void deleteIngredient(Long ingredientId) throws NoRecordFoundException;

    /**
     * Retrieves an ingredient from the data source by its unique identifier.
     *
     * @param ingredientId The unique identifier of the ingredient to be retrieved.
     * @return The IngredientDTO object representing the retrieved ingredient.
     * @throws SomethingWentWrongException If an error occurs while retrieving the ingredient.
     */
    IngredientDTO getIngredientById(Long ingredientId) throws SomethingWentWrongException;

    /**
     * Retrieves a list of ingredients associated with a specific recipe.
     *
     * @param recipeId The unique identifier of the recipe for which ingredients are to be retrieved.
     * @return A list of IngredientDTO objects representing the ingredients associated with the recipe.
     */
    List<IngredientDTO> getIngredientsByRecipeId(Long recipeId);
}
