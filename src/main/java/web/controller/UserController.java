package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String showAllUsers(ModelMap modelUser) {
      //   userService.saveUser(new User(22, "22@gg", "ivan","ivanov"));
    //    userService.saveUser(new User("kirill","krilov","33@gg", 33));
     //   userService.saveUser(new User("sawa","semenov","44@gg", 44));
         modelUser.addAttribute("userList", userService.getUsers());
        return "users";
    }
    @RequestMapping(value = "/addNewUser")
    public String addNewUser(ModelMap modelUser) {
        User addUser = new User();
        modelUser.addAttribute("userList", addUser);
        return "addUser";
    }
    @RequestMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("userList") User userSave) {
        System.out.println("jjj");
        userService.saveUser(userSave);
        return "redirect:/";
    }

}
