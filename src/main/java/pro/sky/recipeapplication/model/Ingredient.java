package pro.sky.recipeapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("quantity")
    private final int quantity;
    @JsonProperty("measureUnit")
    private final String measureUnit;
}
