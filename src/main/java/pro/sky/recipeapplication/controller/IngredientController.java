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

    @GetMapping("/getingredient")
    public Ingredient getIngredient(@RequestParam Long id) throws ModelNotFoundException {
        return ingredientService.getIngredient(id);
    }

    @GetMapping("/addingredient")

    public void addIngredient(@RequestParam String name, @RequestParam int count, @RequestParam String units) {
        ingredientService.addNewIngredient(name, count, units);
    }

    @GetMapping("/allingredients")
    public String getAllIngredients() {
        return ingredientService.getAllIngredients();
    }
}
