package org.launchcodeliftoff.recipetracker.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(max = 500, message = "Comment is too long.")
    private String commentBody;

    private Integer rating;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(String commentBody, Integer rating, Recipe recipe, User user) {
        this.commentBody = commentBody;
        this.rating = rating;
        this.recipe = recipe;
        this.user = user;
    }

    // GETTERS & SETTERS

    public Integer getId() {
        return id;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
