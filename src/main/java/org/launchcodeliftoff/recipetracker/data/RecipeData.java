package org.launchcodeliftoff.recipetracker.data;

import org.launchcodeliftoff.recipetracker.models.Recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RecipeData {

//TODO Clean up this code - not needed

    private static final Map<Integer, Recipe> recipes = new HashMap<>();

    public static Collection<Recipe> getAll() {
        return recipes.values();
    }

    public static Recipe getById(int id) {
        return recipes.get(id);
    }

    public static void add(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
    }

    public static void remove(int id){
        recipes.remove(id);
    }




}
