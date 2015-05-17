package it.androidavanzato.parceler;

import org.parceler.Parcel;

@Parcel
public class Company {

    String name;

    Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    //...
}
