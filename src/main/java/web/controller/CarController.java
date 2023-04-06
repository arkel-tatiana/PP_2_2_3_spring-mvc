package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;
@Controller

public class CarController {
    @RequestMapping(value = "/cars")
    public String printWelcome(ModelMap modelCar, @RequestParam(value = "count", defaultValue = "5") Integer count) {
        CarService carListShow = new CarServiceImpl();
        modelCar.addAttribute("carsList", carListShow.getCars().subList(0,count));
        return "cars";
    }
}
