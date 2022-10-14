package org.launchcodeliftoff.recipetracker.data;

import org.launchcodeliftoff.recipetracker.models.Comment;
import org.launchcodeliftoff.recipetracker.models.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    Iterable<Comment> findByRecipeId(Integer recipeId);
}
