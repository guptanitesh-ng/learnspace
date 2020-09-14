package com.concepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 4, 5, 6, 7);

        // list.forEach(num -> System.out.println(num));
        // long l = list.stream().filter(num -> num > 5).count();
        // System.out.println(l);

        Collections.sort(list, (a, b) -> a < b ? -1 : 1);

        // list.forEach(value -> System.out.println(value));

        // list.stream().filter(num -> num > 5).forEach(System.out::println);

        /*
         * LocalTime time = LocalTime.now(); System.out.println(time);
         * 
         * List<String> values = Arrays.asList("Clock", "LocalTime", "Arrays", "Instant");
         * 
         * //values.forEach(value -> System.out.println(value));
         * 
         * values.forEach(System.out::println);
         * 
         * //Runnable runnable = () -> System.out.println("I m in run method"); Thread t = new
         * Thread(() -> System.out.println("I m in run method")); t.start();
         */

        List<Person> people = Arrays.asList(new Person("Mario", "Puzo", 74),
                new Person("Elvis", "Presley", 45), new Person("Samuel", "Edwards", 67),
                new Person("Thomas", "Cook", 52), new Person("Chris", "Johnson", 29));

        // people.stream().sorted((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()))
        // .forEach(System.out::println);

        // people.stream().filter(p ->
        // p.getLastName().startsWith("P")).forEach(System.out::println);
        System.out.println(people.stream().map(p -> p.getFirstName().toLowerCase())
                .collect(Collectors.toSet()));
        System.out.println(people);
        // System.out.println(getValue());

        Person p = new Person("c", "y", 2);
        Employee e = new Employee("d", "e", 9);
        Main main = new Main();
        main.add(e);
        main.add(p);
    }

    private void add(Person p) {
        System.out.println("Person");
    }

    private void add(Employee e) {
        System.out.println("Employee");
    }

    private static int getValue() {
        int x = 1;
        return x == 1 ? null : 0;
    }
}