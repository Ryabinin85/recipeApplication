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
    private static Map<Long, Ingredient> ingredientList = new LinkedHashMap<>();

    public static Map<Long, Ingredient> getIngredientList() {
        return ingredientList;
    }

    public static void putDefaultIngredients() {
        ingredientList.put(0L, new Ingredient("Специи", 0, "по вкусу"));
        ingredientList.put(1L, new Ingredient("Лук", 1, "кг"));
        ingredientList.put(2L, new Ingredient("Картофель", 1, "кг"));
    }

    @Override
    public void addNewIngredient(Ingredient ingredient) {
        ingredientList.put(id++, ingredient);
    }

    @Override
    public Ingredient getIngredient(Long id) throws ModelNotFoundException {
        if (ingredientList.isEmpty() || !ingredientList.containsKey(id)) {
            throw new ModelNotFoundException("Такого ингредиента нет!");
        } else {
            return ingredientList.get(id);
        }
    }

    @Override
    public String getAllIngredients() {
        putDefaultIngredients();
        return ingredientList.toString();
    }

    @Override
    public Ingredient editIngredient(long id, Ingredient ingredient) {
        if (ingredient != null && !ingredientList.isEmpty() && ingredientList.containsKey(id)) {
            return ingredientList.put(id, ingredient);
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(long id) {
        if (ingredientList.containsKey(id)) {
            ingredientList.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllIngredients() {
        ingredientList = new LinkedHashMap<>();
    }
}
