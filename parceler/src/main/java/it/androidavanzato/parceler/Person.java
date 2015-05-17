package it.androidavanzato.parceler;

import org.parceler.Parcel;

@Parcel
public class Person {
    String name;
    String surname;

    protected Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    //...
}
