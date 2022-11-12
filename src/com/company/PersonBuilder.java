package com.company;

public class PersonBuilder implements PersonBuild {
    private String name;
    private String surname;
    private String address;
    private int age;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            return this;
        } else throw new IllegalStateException("Возраст не может быть отрицательным");

    }


    public Person build() {
        if (this.name == null | this.surname == null) {
            throw new IllegalStateException("Имя и фамилия должны быть обязательно указаны");
        }
        if (age >= 0 && address != null) {
            return new Person(name, surname, age, address);
        } else if (age >= 0 && address == null) {
            return new Person(name, surname, age, "Советский Союз");
        } else {
            return new Person(name, surname, 0, "Советский Союз");
        }
    }
}
