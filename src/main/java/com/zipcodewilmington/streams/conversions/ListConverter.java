package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ListConverter extends PersonConversionAgent<List<Person>> {
    List<Person> list;
    public ListConverter(List<Person> people) {

        super(people);
        list = super.objectSequence;
    }

    public ListConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .collect(Collectors.toList()));
    }

    @Override
    public List<Person> toList() {
        return super.objectSequence;
    }

    //TODO
    public Stream<Person> toStream() {

        return list.stream();
    }

    //TODO
    public Person[] toArray() {

        return list.stream().toArray(Person[]::new);
    }
}
