package com.pluralsight.loops;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.Scanner;

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

        ArrayList<Person> matchedPeople = new ArrayList<>();

        for (int i = 0; i < people.size(); i++) {

            Person person = people.get(i);

            if (person.getFirstName().equalsIgnoreCase(searchName)
                    || person.getLastName().equalsIgnoreCase(searchName)) {

                matchedPeople.add(person);
            }
        }

        System.out.println("\nMatching People:");

        if (matchedPeople.size() == 0) {
            System.out.println("No people found.");
        } else {

            for (int i = 0; i < matchedPeople.size(); i++) {

                Person person = matchedPeople.get(i);

                System.out.println(person.getFirstName()
                        + " "
                        + person.getLastName());
            }
        }

        int totalAge = 0;
        int oldestAge = people.get(0).getAge();
        int youngestAge = people.get(0).getAge();

        for (int i = 0; i < people.size(); i++) {

            Person person = people.get(i);

            totalAge += person.getAge();

            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }

            if (person.getAge() < youngestAge) {
                youngestAge = person.getAge();
            }
        }

        double averageAge = (double) totalAge / people.size();

        System.out.println("\nAverage age: " + averageAge);
        System.out.println("Oldest age: " + oldestAge);
        System.out.println("Youngest age: " + youngestAge);
    }
}