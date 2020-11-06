package com.in28minutes.rest.webservices.restfulwebservices.person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonTeste {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person(21, "Fulano", "fulano_br@gmail.com"),
                new Person(22, "Fulano", "fulano_eua@gmail.com"),
                new Person(23, "Ciclano", "ciclano_br@gmail.com"),
                new Person(24, "Ciclano", "ciclano_eua@gmail.com")
        );

        List<Person> personListFiltered = personList.stream()
                .filter(Person.distinctByKey(Person::getName))
                .collect(Collectors.toList());

        List<String> names = personList.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(personListFiltered);
        System.out.println(names);

        for (String name : names) {
            List<Person> personListByName = personList.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
            System.out.println(personListByName);
        }
    }
}
