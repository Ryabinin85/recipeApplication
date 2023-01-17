package pro.sky.recipeapplication.service;

import pro.sky.recipeapplication.model.Recipe;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;

import java.util.List;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    void addRecipeList(List<Recipe> recipe);

    Recipe getRecipe(Long id) throws ModelNotFoundException;

    String getAllRecipes();

    Recipe editRecipe(long id, Recipe recipe);

    boolean deleteRecipe(long id);

    void deleteAllRecipe();

    String findRecipeByIngredient(long id);
}
