package org.csystem.samples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PersonFactory {
    private List<Person> m_people;

    private static Person getPersonByLine(String line)
    {
        var personInfo = line.split("[,]");

        var id = Integer.parseInt(personInfo[0]);
        var name = personInfo[1];
        var birthDate = LocalDate.parse(personInfo[2], DateTimeFormatter.ofPattern("dd.MM.yyy"));
        var maritalStatus = MaritalStatus.values()[Integer.parseInt(personInfo[3])];

        return new Person(id, name, birthDate, maritalStatus);
    }

    public static PersonFactory loadFromFile(String path) throws IOException
    {
        var personFactory = new PersonFactory();

        personFactory.m_people = Files.lines(Path.of(path), StandardCharsets.UTF_8)
                .map(PersonFactory::getPersonByLine).collect(Collectors.toList());

        return personFactory;
    }

    public List<Person> getPeople()
    {
        return m_people;
    }
}
