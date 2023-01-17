package pro.sky.recipeapplication.controller;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Recipe> getRecipe(@RequestParam Long id) throws ModelNotFoundException {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    //Поиск рецептов по id ингредиента.
    @GetMapping("/findrecipe")
    public ResponseEntity<String> findRecipeByIngredient(@RequestParam Long id) {
        String result = recipeService.findRecipeByIngredient(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public String getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addlist")
    public ResponseEntity<List<Recipe>> addRecipeList(@RequestBody List<Recipe> recipe) {
        if (recipe.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            recipeService.addRecipeList(recipe);
            return ResponseEntity.ok(recipe);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editIngredient(@PathVariable long id, @RequestBody Recipe recipe) {
        recipeService.editRecipe(id, recipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllRecipe() {
        recipeService.deleteAllRecipe();
        return ResponseEntity.ok().build();
    }
}
