package com.example.alertspoc.model;

public class ChildResponseClass extends ResponseAbstractClass {
    public Animal animal;

    public ChildResponseClass(Animal animal, User user) {
        super(user);
        this.animal = animal;
    }
}
