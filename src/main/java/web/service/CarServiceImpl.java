package web.service;

import web.model.Car;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{

    @Override
    public List<Car> getCars() {
        List<Car> carList = new ArrayList<>(5);
        carList.add(new Car("BMW", 192121L, "RED"));
        carList.add(new Car("BMW", 2324454L, "BLU"));
        carList.add(new Car("BMW", 6798004L, "WHITE"));
        carList.add(new Car("BMW", 7652330L, "GREEN"));
        carList.add(new Car("BMW", 4567781L, "BLACK"));
        return carList;
    }
}
