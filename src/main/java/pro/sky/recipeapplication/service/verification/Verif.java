package pro.sky.recipeapplication.service.verification;

import org.jetbrains.annotations.NotNull;

public class Verif {

    public static int checkInt(int number) {
        return number > 0 ? number : 1;
    }
    public static @NotNull String checkName(String name) {
        return name == null
                || name.isEmpty()
                || name.isBlank() ? "unnamed" : name;
    }
}