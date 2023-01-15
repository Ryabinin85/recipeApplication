package pro.sky.recipeapplication.service;

import pro.sky.recipeapplication.model.Ingredient;
import pro.sky.recipeapplication.model.Recipe;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;

import java.util.List;

public interface RecipeService {
    void addNewRecipe(String name, int count, String units,
                      List<Ingredient> ingredients, List<String> cookingSteps);

    Recipe getRecipe(Long id) throws ModelNotFoundException;

    String getAllRecipes();
}
