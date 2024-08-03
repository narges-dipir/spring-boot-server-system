package com.narcis.amazing_spring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiController() {
        coffees.addAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Gandor"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas")
        ));
    }

    @GetMapping(value = "/coffee")
    Iterable<Coffee> getCoffees() {
        return coffees;
    }
    @GetMapping("/coffee/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee coffee: coffees) {
            if (coffee.getId().equals(id)){
                return Optional.of(coffee);
            }
        }
        return Optional.empty();
    }
    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }
    @PutMapping("/coffees/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
        int coffeeIndex = -1;

        for (Coffee c: coffees) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }
        return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;
    }

    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(c -> c.getId().equals(id));
    }
}
