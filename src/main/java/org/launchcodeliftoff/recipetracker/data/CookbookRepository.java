package org.launchcodeliftoff.recipetracker.data;

import org.launchcodeliftoff.recipetracker.models.Cookbook;
import org.launchcodeliftoff.recipetracker.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface CookbookRepository extends CrudRepository<Cookbook, Integer> {

    Iterable<Cookbook> findByUserId(Integer userId);
}
