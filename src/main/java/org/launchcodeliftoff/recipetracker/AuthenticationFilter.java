package org.launchcodeliftoff.recipetracker;

import org.launchcodeliftoff.recipetracker.controllers.AuthenticationController;
import org.launchcodeliftoff.recipetracker.data.UserRepository;
import org.launchcodeliftoff.recipetracker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;


    private static final List<String> whitelist = Arrays.asList("/login", "/register", "/logout", "/css", "/recipe/view");

    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    private static final List<String> blacklist = Arrays.asList("/home", "/cookbook");
    private static boolean isBlacklisted(String path) {
        for (String pathRoot : blacklist) {
            if (path.startsWith(pathRoot)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

//        // Don't require sign-in for whitelisted pages
//        if (isWhitelisted(request.getRequestURI())) {
//            // returning true indicates that the request may proceed
//            System.out.println("I am in the if isWhiteListed");
//            return true;
//        }

        if(isBlacklisted(request.getRequestURI())){
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }


        // The user is NOT logged in
        response.sendRedirect("/login");
        return false;
    }

}

