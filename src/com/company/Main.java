package com.company;

public class Main {

    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
        mom.happyBirthday();
        System.out.println("\n" + mom + " отпраздновала День рождения. теперь ей " + mom.getAge().getAsInt() + " года");
        Person threePerson = new PersonBuilder()
                .setName("Алексей")
                .setSurname("Сазанов")
                .setAge(55)
                .build();
        System.out.println("\n" + threePerson + " Мой адрес — Советский Союз");
        try {
            // Не хватает обязательных полей
            Person person = new PersonBuilder().build();

        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
