package pro.sky.recipeapplication.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.recipeapplication.model.Ingredient;
import pro.sky.recipeapplication.service.IngredientService;
import pro.sky.recipeapplication.service.exceptions.ModelNotFoundException;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping()
    public Ingredient getIngredient(@RequestParam Long id) throws ModelNotFoundException {
        return ingredientService.getIngredient(id);
    }

    @PostMapping("/add")
    public void addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addNewIngredient(ingredient);
    }

    @GetMapping("/all")
    public String getAllIngredients() {
        return ingredientService.getAllIngredients();
    }
}
