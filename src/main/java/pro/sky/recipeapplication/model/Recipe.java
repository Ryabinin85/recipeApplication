package pro.sky.recipeapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

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
    private final List <Ingredient> ingredients;
    @JsonProperty("cookingInstruction")
    private final Map<Long, String> cookingInstruction;
}
