package it.androidavanzato.parceler;

import org.parceler.Parcel;

@Parcel
public class Worker extends Person {
    Company company;

    Worker() {
        super();
    }

    public Worker(String name, String surname, Company company) {
        super(name, surname);
        this.company = company;
    }

}
