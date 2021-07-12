package com.oktenwebjavaadvanced.controller;

import com.oktenwebjavaadvanced.entity.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

   final private List<Car>cars = new ArrayList<>();
    {
        cars.add(new Car(1, "volvo", "red", 600, "Ivan"));
        cars.add(new Car(2, "mercedes", "white", 700, "Oleg"));
        cars.add(new Car(3, "audi", "silver", 600, "Iryna"));
        cars.add(new Car(4, "shkoda", "green", 400, "Anton"));
        cars.add(new Car(5, "BMW", "black", 800, "Viktor"));
    }


    @GetMapping(value = "/car")
    public List<Car>getMovies(){
        return cars;
    }

    @PostMapping(value = "/car")
    @ResponseStatus(HttpStatus.CREATED)
    public  Car insertMovie (@RequestBody Car car) {
        cars.add(car);
        return car;
    }
    @PutMapping(value = "/car/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Car updateMovie (@PathVariable int id, @RequestBody Car car) {
        final Optional<Car> first = cars.stream()
                .filter(m -> m.getId()==id)
                .findFirst();
        final Car movieInList =first
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        final int index=cars.indexOf(movieInList);
        car.setId(id);
        cars.set(index, car);
        return car;
    }

    @DeleteMapping(value = "/car/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie (@PathVariable int id) {
        final boolean isRemoved = cars
                .removeIf(car -> car.getId()==id);
        if (isRemoved){
            System.out.println("Car removed");
        }
        else {
            System.out.println("No car with such id");
        }
    }

}


