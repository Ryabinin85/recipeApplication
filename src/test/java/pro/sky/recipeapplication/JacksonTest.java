package pro.sky.recipeapplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pro.sky.recipeapplication.model.Ingredient;
import pro.sky.recipeapplication.model.Recipe;
import pro.sky.recipeapplication.service.IngredientService;
import pro.sky.recipeapplication.service.impl.IngredientServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class JacksonTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void pojoToJsonString() throws JsonProcessingException {
        IngredientService ingredientService = new IngredientServiceImpl();
        String jsonIngredients = objectMapper.writeValueAsString(ingredientService.getAllIngredients());

        Ingredient ingredient = new Ingredient("Test", 1, "units");
        String jsonIngredient = objectMapper.writeValueAsString(ingredient);

        System.out.println(jsonIngredients);
        System.out.println(jsonIngredient);

    }


    @Test
    void fileToList() throws IOException {

        File file = new File("src/main/resources/recipes.json");
        ArrayList<Recipe> recipes = objectMapper.readValue(file, ArrayList.class);

        for (int i = 0; i < recipes.size(); i++) {
            System.out.println(recipes.get(i));
        }
    }
}
