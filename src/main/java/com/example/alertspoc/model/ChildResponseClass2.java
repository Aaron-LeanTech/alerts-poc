package com.example.alertspoc.model;

public class ChildResponseClass2 extends ResponseAbstractClass {
    public Animal animal;

    public ChildResponseClass2(Animal animal, User user) {
        super(user);
        this.animal = animal;
    }
}
