package pro.sky.recipeapplication.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.recipeapplication.model.Recipe;
import pro.sky.recipeapplication.service.RecipeService;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping()
    public Recipe getRecipe(@RequestParam Long id) throws ModelNotFoundException {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/addlist")
    public void add(@RequestBody List<Recipe> recipe) {
        recipeService.addRecipeList(recipe);
    }

    @PostMapping("/add")
    public void addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @GetMapping("/all")
    public String getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}
