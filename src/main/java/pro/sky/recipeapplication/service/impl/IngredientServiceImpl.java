package pro.sky.recipeapplication.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipeapplication.model.Ingredient;
import pro.sky.recipeapplication.service.IngredientService;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {

    private static Long id = 3L;
    private static final Map<Long, Ingredient> ingredientsList = new LinkedHashMap<>();

    public static void putDefaultIngredients() {
        ingredientsList.put(0L, new Ingredient("Специи", 0, "по вкусу"));
        ingredientsList.put(1L, new Ingredient("Лук", 1, "кг"));
        ingredientsList.put(2L, new Ingredient("Картофель", 1, "кг"));
    }

    @Override
    public void addNewIngredient(Ingredient ingredient) {
        ingredientsList.put(id++, ingredient);
    }

    @Override
    public Ingredient getIngredient(Long id) throws ModelNotFoundException {
        if (ingredientsList.isEmpty() || !ingredientsList.containsKey(id)) {
            throw new ModelNotFoundException("Такого ингредиента нет!");
        } else {
            return ingredientsList.get(id);
        }
    }

    @Override
    public String getAllIngredients() {
        putDefaultIngredients();
        return ingredientsList.toString();
    }
}
