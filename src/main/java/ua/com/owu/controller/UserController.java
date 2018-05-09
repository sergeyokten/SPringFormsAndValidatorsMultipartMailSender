package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.entity.User;
import ua.com.owu.service.MainService;
import ua.com.owu.service.UserService;
import ua.com.owu.service.editors.CarEditor;
import ua.com.owu.service.vaildators.UserValidator;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

//    @PostMapping("/save")
//    public String save(@RequestParam String name,
//                       @RequestParam Integer age) {
//        System.out.println(name + " " + age);
//
//
//        return "index";
//    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private CarEditor carEditor;


    @Autowired
    private MainService mainService;

    @PostMapping("/save")
    public String save(Model model, User user, @RequestParam("ava") MultipartFile file) throws IOException {

        String path =
                System.getProperty("user.home")
                        + File.separator +
                        "pics"
                        + File.separator;
        file.transferTo(new File(path + file.getOriginalFilename()));
        user.setAvatar("/avax/" + file.getOriginalFilename());


        userService.save(user);
        model.addAttribute("users", userService.findAll());
        mainService.sendEmail(user);


        return "allUsers";
    }

    @PostMapping("/saveSF")
    public String saveSF(@ModelAttribute("xxx") @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("has some errors");
            return "index";
        }
        System.out.println(user);
        System.out.println(user.getCars());
        userService.save(user);

        return "redirect:/";
    }


    @InitBinder("xxx")
    public void initBinderXXX(WebDataBinder dataBinder) {
        System.out.println("binder work");
//        dataBinder.registerCustomEditor(Car.class, carEditor);
        dataBinder.addValidators(userValidator);


    }
}
