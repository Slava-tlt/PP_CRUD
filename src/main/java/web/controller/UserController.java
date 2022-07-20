package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userServiceImpl;

    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String getAllUsers(Model model) {

        model.addAttribute("users", userServiceImpl.getAllUsers());

        return "allUsers";
    }

    @GetMapping("/addUser")
    public String newUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/Update")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userServiceImpl.getById(id));
        return "Update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userServiceImpl.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }

}
