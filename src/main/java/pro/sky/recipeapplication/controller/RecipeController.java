package pro.sky.recipeapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.recipeapplication.model.Ingredient;
import pro.sky.recipeapplication.model.Recipe;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;
import pro.sky.recipeapplication.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping
    public String start() {
        return "Приложение запущено";
    }

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getrecipe")
    public Recipe getRecipe(@RequestParam Long id) throws ModelNotFoundException {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/addrecipe")
    public void addRecipe(@RequestParam String name, @RequestParam int count, @RequestParam String units,
                              List<Ingredient> ingredients, List<String> cookingSteps) {
        recipeService.addNewRecipe(name, count, units, ingredients, cookingSteps);
    }

    @GetMapping("/allrecipes")
    public String getAllRecipes () {
        return recipeService.getAllRecipes();
    }
}
