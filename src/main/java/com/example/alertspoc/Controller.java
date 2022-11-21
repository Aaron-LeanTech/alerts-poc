package com.example.alertspoc;

import com.example.alertspoc.model.Animal;
import com.example.alertspoc.model.ChildResponseClass;
import com.example.alertspoc.model.ChildResponseClass2;
import com.example.alertspoc.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/hello")
    public ChildResponseClass hello() {
        var animal = new Animal("dog");
        var user = new User("Aaron");
        return new ChildResponseClass(animal, user);
    }

    @GetMapping("/hello2")
    public ChildResponseClass2 hello2() {
        var animal = new Animal("cat");
        var user = new User("TheBeast");
        return new ChildResponseClass2(animal, user);
    }

}
