package pro.sky.recipeapplication.service.exceptions;

public class ModelNotFoundException extends Exception {

    public ModelNotFoundException() {
    }
    public ModelNotFoundException(String massage) {
        super(massage);
    }
}
