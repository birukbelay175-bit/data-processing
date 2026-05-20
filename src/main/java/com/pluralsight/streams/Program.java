package com.pluralsight.streams;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Biruk", "Tafese", 24));
        people.add(new Person("Daniel", "Bekele", 21));
        people.add(new Person("Hanna", "Tesfaye", 23));
        people.add(new Person("Nathan", "Alemu", 28));
        people.add(new Person("Sara", "Kebede", 26));
        people.add(new Person("Abel", "Haile", 31));
        people.add(new Person("Mimi", "Solomon", 20));
        people.add(new Person("Eden", "Samuel", 27));
        people.add(new Person("Noah", "Gebre", 35));
        people.add(new Person("Liya", "Demissie", 22));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine();

        List<Person> matchedPeople = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(searchName)
                        || person.getLastName().equalsIgnoreCase(searchName))
                .collect(Collectors.toList());

        matchedPeople.forEach(person ->
                System.out.println(person.getFirstName() + " " + person.getLastName()));

        double averageAge = people.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum) / (double) people.size();

        int oldestAge = people.stream()
                .map(Person::getAge)
                .reduce(Integer.MIN_VALUE, Integer::max);

        int youngestAge = people.stream()
                .map(Person::getAge)
                .reduce(Integer.MAX_VALUE, Integer::min);

        System.out.println("Average age: " + averageAge);
        System.out.println("Oldest age: " + oldestAge);
        System.out.println("Youngest age: " + youngestAge);
    }
}