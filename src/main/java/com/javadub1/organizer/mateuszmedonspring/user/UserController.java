package com.javadub1.organizer.mateuszmedonspring.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("users-view");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @GetMapping("/users/{userId}")
    public ModelAndView userById(@PathVariable("userId") Long id){
        ModelAndView modelAndView = new ModelAndView("user-view");
        modelAndView.addObject("user", userService.findById(id));
        return modelAndView;
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";

    }
}
