package org.launchcodeliftoff.recipetracker.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private String email;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "recipeAuthor")
    private List<Recipe> myRecipes = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @ManyToMany(mappedBy = "users")
    @OneToMany
    private List<Recipe> savedRecipes = new ArrayList<>();

    @OneToMany
    private List<Cookbook> cookbooks = new ArrayList<>();

    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwHash() {
        return pwHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Recipe> getMyRecipes() {
        return myRecipes;
    }

    public void setMyRecipes(List<Recipe> myRecipes) {
        this.myRecipes = myRecipes;
    }

    public List<Recipe> getSavedRecipes() {
        return savedRecipes;
    }

    public void setSavedRecipes(List<Recipe> savedRecipes) {
        this.savedRecipes = savedRecipes;
    }

    public void addToSavedRecipes(Recipe recipe){
        this.savedRecipes.add(recipe);
    }

    public List<Cookbook> getCookbooks() {
        return cookbooks;
    }

    public void setCookbooks(List<Cookbook> cookbooks) {
        this.cookbooks = cookbooks;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public void addCookbook(Cookbook cookbook){
        this.cookbooks.add(cookbook);
    }
}
