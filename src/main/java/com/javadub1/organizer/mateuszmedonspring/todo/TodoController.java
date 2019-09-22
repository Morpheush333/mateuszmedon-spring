package com.javadub1.organizer.mateuszmedonspring.todo;

import com.javadub1.organizer.mateuszmedonspring.todo.entities.Todo;
import com.javadub1.organizer.mateuszmedonspring.user.UserService;
import com.javadub1.organizer.mateuszmedonspring.user.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //    if empty return all users else follow bt gender
    @GetMapping
    public ModelAndView users(@RequestParam(name = "g", required = false, defaultValue = "") String status) {
        ModelAndView modelAndView = new ModelAndView("todo/todos-view");
        modelAndView.addObject("todos",
                StringUtils.isEmpty(status) ?
                        todoService.findAll() :
                        todoService.findByStatus(status.toUpperCase()));
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView userById(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("todo/todo-view");
        modelAndView.addObject("todo", todoService.findById(id));
        return modelAndView;
    }

    @PostMapping
    public String saveUser(@ModelAttribute Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/todos";
    }


}
