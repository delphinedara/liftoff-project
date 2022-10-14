package org.launchcodeliftoff.recipetracker.data;

import org.launchcodeliftoff.recipetracker.models.Cookbook;
import org.launchcodeliftoff.recipetracker.models.Recipe;
import org.launchcodeliftoff.recipetracker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

//    Iterable<Recipe> findByRecipeAuthor(User recipeAuthor);
//
//    //    Iterable<Recipe> findByCookbookId(Integer cookbookId);
//    Iterable<Recipe> findByCookbooks(Cookbook cookbook);

        Iterable<Recipe> findByRecipeAuthorId(Integer recipeAuthorId);
}
