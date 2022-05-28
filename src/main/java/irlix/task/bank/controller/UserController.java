package irlix.task.bank.controller;


import irlix.task.bank.models.dto.user.IndexUserDto;
import irlix.task.bank.models.dto.user.UserCreateEditDto;
import irlix.task.bank.models.dto.user.WorkingUserDto;
import irlix.task.bank.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @GetMapping()
    public String index(Model model) {
        IndexUserDto userList = service.getAllUserDto();
        model.addAttribute("userList", userList);
        model.addAttribute("newUser", new UserCreateEditDto());
        return "index";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("newUser") @Valid UserCreateEditDto userDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            IndexUserDto userList = service.getAllUserDto();
            model.addAttribute("userList", userList);
            return "index";
        }
        service.saveNewUser(userDto);
        return "redirect:/user";
    }

    @GetMapping("/{id}")
    public String lookEditAndDeleteUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("userDto", service.getOneUserDto(id));
        model.addAttribute("id", id);
        return "editUsers";
    }

    @PatchMapping("/{id}")
    public String EditUser(@PathVariable("id") int id, @ModelAttribute("userDto") @Valid UserCreateEditDto userDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "editUsers";
        }

        service.editUser(userDto, id);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable("id") int id) {
        service.deleteUser(id);
        return "redirect:/user";
    }
}
