package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.dao.CarDAO;
import ua.com.owu.entity.Car;
import ua.com.owu.entity.User;
import ua.com.owu.service.CarService;
import ua.com.owu.service.editors.UserEditor;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarDAO carDAO;
//    @Autowired
//    private UserDAO userDAO;

    @GetMapping("/")
    public String mainPage(Model model) {
        System.out.println("hi! ");

        model.addAttribute("xxx", new User("kooks", 123));
//        model.addAttribute("cars", Arrays.asList(new Car("subaru", 12), new Car("bubrau", 13)));
        model.addAttribute("cars", carDAO.findAll());

        model.addAttribute("yyy", new Car());

//        model.addAttribute("users", userDAO.findAll());
        return "index";
    }


    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("yyy") Car car) {
        carService.save(car);
        return "redirect:/";
    }


    @Autowired

    private UserEditor userEditor;

    @InitBinder("yyy")
    public void binder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(User.class, userEditor);
    }


    @PostMapping("/saveImg")
    public String saveImg(@RequestParam("picture") MultipartFile file) throws IOException {

        String path =
                System.getProperty("user.home")
                        + File.separator +
                        "pics"
                        + File.separator;
        file.transferTo(new File(path + file.getOriginalFilename()));



        return "";
    }

}
