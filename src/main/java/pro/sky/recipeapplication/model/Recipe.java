package pro.sky.recipeapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
    @JsonProperty("recipeName")
    private final String recipeName;
    @JsonProperty("cookTime")
    private final int cookTime;
    @JsonProperty("ingredients")
    private final List<Ingredient> ingredients;
    @JsonProperty("cookingSteps")
    private final List<String> cookingSteps;
}
