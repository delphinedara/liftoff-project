package org.launchcodeliftoff.recipetracker.data;

import org.launchcodeliftoff.recipetracker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
