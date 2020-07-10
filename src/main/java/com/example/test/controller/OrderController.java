package com.example.test.controller;

import com.example.test.model.*;
import com.example.test.repository.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private StatusCarRepository statusCarRepository;
    @Autowired
    private UserRepository userRepository;

    public OrderController(OrdersRepository ordersRepository,
                            CarRepository carRepository,
                            GenderRepository genderRepository,
                            StatusCarRepository statusCarRepository,
                            UserRepository userRepository){
        this.ordersRepository = ordersRepository;
        this.carRepository = carRepository;
        this.genderRepository = genderRepository;
        this.statusCarRepository = statusCarRepository;
        this.userRepository = userRepository;

    }

    @GetMapping("/userName")
    public Collection<User> users() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/order")
    public Collection<Orders> orders() {
        return ordersRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/addOrder/{user_id}/{car_id}")
    public Orders addOrder(Orders orders,
                           @PathVariable long user_id,
                           @PathVariable long car_id)throws Exception {


        if(carRepository.findById(car_id).getStatusCar().getStatus()=="Ready"){
            Orders newOrder = new Orders();
            newOrder.setTimestart(new Date());
            newOrder.setCar(carRepository.findById(car_id));
            newOrder.setUsers(userRepository.findById(user_id));
            carRepository.findById(car_id).setStatusCar(statusCarRepository.findById(2));
            return ordersRepository.save(newOrder);
        }else{
            throw new Exception("error");
        }

    }

    @PutMapping("/paybackOrder/{order_id}")
    public Orders editOrder(Orders orders,
            @PathVariable Long order_id)throws Exception{
        if (ordersRepository.findById(order_id).get().getTimeend()==null) {
            return ordersRepository.findById(order_id)
                    .map(update -> {
                                update.getCar().setStatusCar(statusCarRepository.findById(1));
                                update.setTimeend(new Date());
                                return ordersRepository.save(update);
                            }
                    ).orElseGet(() -> {
                        orders.setId(order_id);
                        return ordersRepository.save(orders);
                    });
        }else{
            throw new Exception("error");
        }
    }
    @PutMapping("/UnAndFixCar/{car_id}")
    public Car editOrder(Car car,
                            @PathVariable Long car_id){

        return carRepository.findById(car_id)
                .map(update ->{
                    if(carRepository.findById(car_id).get().getStatusCar().getId()==1){
                            update.setStatusCar(statusCarRepository.findById(3));
                    }else if(carRepository.findById(car_id).get().getStatusCar().getId()==3){
                            update.setStatusCar(statusCarRepository.findById(1));
                    }else{
                        return null;
                    }
                            return carRepository.save(update);
                        }
                ).orElseGet(() ->{
                    car.setId(car_id);
                    return carRepository.save(car);
                });

    }

    @PostMapping("/addCar")
    public Car addCar(@RequestBody String car)throws IOException{
        final String decoded = URLDecoder.decode(car, "UTF-8");
        car = decoded;
        Car newCar = new Car();
        if(car.charAt(0) == '{'){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode carObj = mapper.readTree(car);
            newCar.setCarName(carObj.get("carName").textValue());
            newCar.setCarId(carObj.get("carId").textValue());
        }
        newCar.setStatusCar(statusCarRepository.findById(1));
        return carRepository.save(newCar);
    }

    @PostMapping("/addUser/{gender_id}/{age}")
    public User addOrder(@RequestBody String user,
                         @PathVariable long gender_id,
                         @PathVariable int age)throws IOException {
        final String decoded = URLDecoder.decode(user, "UTF-8");
        user = decoded;
        User newUser = new User();
        if(user.charAt(0) == '{'){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode UserObj = mapper.readTree(user);
            newUser.setName(UserObj.get("name").textValue());
            newUser.setPassport(UserObj.get("passport").textValue());
        }
        newUser.setAge(age);
        newUser.setGender(genderRepository.findById(gender_id));
        return userRepository.save(newUser);
    }
    @GetMapping("/Gender")
    public Collection<Gender> Gender() {
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Car")
    public Collection<Car> Car() {
        return carRepository.findAll().stream().collect(Collectors.toList());
    }
}
