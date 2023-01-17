package pro.sky.recipeapplication.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipeapplication.model.Ingredient;
import pro.sky.recipeapplication.model.Recipe;
import pro.sky.recipeapplication.service.RecipeService;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final static Map<Long, Recipe> recipeList = new HashMap<>();
    private static Long id = 1L;

    @Override
    public void addRecipe(Recipe recipe) {
        recipeList.put(id++, recipe);
    }

    @Override
    public void addRecipeList(List<Recipe> recipe) {
        for (Recipe recipe1 : recipe) {
            recipeList.put(id++, recipe1);
        }
    }

    @Override
    public Recipe getRecipe(Long id) throws ModelNotFoundException {
        if (recipeList.isEmpty() || !recipeList.containsKey(id)) {
            throw new ModelNotFoundException("Такого рецепта нет!");
        } else {
            return recipeList.get(id);
        }
    }

    @Override
    public String getAllRecipes() {
        putDefaultRecipes();
        return recipeList.toString();
    }

    public void putDefaultRecipes() {
        recipeList.put(0L, new Recipe("Сырники из творога", 30,
                List.of(
                        new Ingredient("Творог", 350, "гр."),
                        new Ingredient("Куриное яйцо", 2, "шт."),
                        new Ingredient("Пшеничная мука", 6, "ст. л."),
                        new Ingredient("Сахар", 2, "ст. л.")),
                Map.of(
                        1L, "Смешайте весь творог с яйцами, сахаром и тщательно всё перемешайте.",
                        2L, "Всыпьте в творог муку и тщательно перемешайте.",
                        3L, "Поставьте сковороду на средний огонь и налейте в нее подсолнечное масло.",
                        4L, "Слепите несколько небольших шариков из получившейся творожной массы и положите их на тарелку. " +
                                "Затем по очереди обкатывайте творожные шарики в муке и выкладывайте на сковороду.",
                        5L, "Обжаривайте сырники 1–2 минуты до появления золотистой корочки. " +
                                "Затем переверните их на другую сторону и также обжарьте до золотистого состояния.",
                        6L, "Повторяйте, пока творог не закончится.")));
    }
}
