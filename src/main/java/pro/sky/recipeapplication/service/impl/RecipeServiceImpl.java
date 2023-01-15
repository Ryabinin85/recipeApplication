package pro.sky.recipeapplication.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.recipeapplication.model.Ingredient;
import pro.sky.recipeapplication.model.Recipe;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;
import pro.sky.recipeapplication.service.RecipeService;
import pro.sky.recipeapplication.service.verification.Verif;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final static Map<Long, Recipe> recipeList = new HashMap<>();
    private static Long id = 0L;

    @Override
    public void addNewRecipe(String name, int count, String units,
                             List<Ingredient> ingredients, List<String> cookingSteps) {
        List<Ingredient> thisIngredients = new ArrayList<>(ingredients);
        List<String> thisCookingSteps = new ArrayList<>(cookingSteps);
        recipeList.put(id++, new Recipe(Verif.checkName(name), Verif.checkInt(count), thisIngredients, thisCookingSteps));
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
        recipeList.put(id++, new Recipe("Сырники из творога", 30,
                List.of(
                        new Ingredient("Творог", 350, "гр."),
                        new Ingredient("Куриное яйцо", 2, "шт."),
                        new Ingredient("Пшеничная мука", 6, "ст. л."),
                        new Ingredient("Сахар", 2, "ст. л.")),
                List.of(
                        "Смешайте весь творог с яйцами, сахаром и тщательно всё перемешайте.",
                        "Всыпьте в творог муку и тщательно перемешайте.",
                        "Поставьте сковороду на средний огонь и налейте в нее подсолнечное масло.",
                        "Слепите несколько небольших шариков из получившейся творожной массы и положите их на тарелку. " +
                                "Затем по очереди обкатывайте творожные шарики в муке и выкладывайте на сковороду.",
                        "Обжаривайте сырники 1–2 минуты до появления золотистой корочки. " +
                                "Затем переверните их на другую сторону и также обжарьте до золотистого состояния.",
                        "Повторяйте, пока творог не закончится.")));

    }
}
