package pro.sky.recipeapplication.service;

import pro.sky.recipeapplication.model.Ingredient;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;

public interface IngredientService {
    Ingredient getIngredient(Long identifier) throws ModelNotFoundException;


    void addNewIngredient(Ingredient ingredient);

    String getAllIngredients();

    Ingredient editIngredient(long id, Ingredient ingredient);

    boolean deleteIngredient(long id);

    void deleteAllIngredients();
}
