package com.nemiro54.springmvcwebapp.dao;

import com.nemiro54.springmvcwebapp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 16, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 21, "bob@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 23, "mike@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 24, "katy@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}