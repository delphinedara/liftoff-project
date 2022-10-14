package org.launchcodeliftoff.recipetracker.controllers;

import org.launchcodeliftoff.recipetracker.data.RecipeRepository;
import org.launchcodeliftoff.recipetracker.data.UserRepository;
import org.launchcodeliftoff.recipetracker.models.Recipe;
import org.launchcodeliftoff.recipetracker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/list-recipes/{recipeAuthorId}")
    public String displayListOfRecipesByRecipeAuthor(Model model, @PathVariable Integer recipeAuthorId, HttpServletRequest request){
        User recipeAuthor = userRepository.findById(recipeAuthorId).get();
        model.addAttribute("recipeAuthor", recipeAuthor);
        model.addAttribute("recipes", recipeRepository.findByRecipeAuthorId(recipeAuthorId));
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){
            //if the user is logged in leave a link for add recipe
            model.addAttribute("isUserLoggedIn", true);
        }else{
            //if no user logged in leave a link for register
            model.addAttribute("isUserLoggedIn", false);
        }
        return "list-recipes";
    }

    @PostMapping("/list-recipes/results")
    public String processSearchBar(@RequestParam String searchTerm, Model model, HttpServletRequest request){
        model.addAttribute("searchTerm", searchTerm);
        List<Recipe> allRecipes = (List<Recipe>) recipeRepository.findAll();
        List<Recipe> recipes = new ArrayList<>();
        for (Recipe recipe:
             allRecipes) {
            if (recipe.search(searchTerm)){
                recipes.add(recipe);
            }
        }
        model.addAttribute("recipes", recipes);

        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){
            //if the user is logged in leave a link for add recipe
            model.addAttribute("isUserLoggedIn", true);
        }else{
            //if no user logged in leave a link for register
            model.addAttribute("isUserLoggedIn", false);
        }

        return "list-recipes";
    }
}
