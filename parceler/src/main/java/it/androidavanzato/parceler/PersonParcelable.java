package it.androidavanzato.parceler;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fabiocollini on 30/08/14.
 */
public class PersonParcelable implements Parcelable {
    private String name;
    private String surname;

    protected PersonParcelable() {
    }

    public PersonParcelable(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
    }

    protected void readFromParcel(Parcel in) {
        name = in.readString();
        surname = in.readString();
    }

    public static final Parcelable.Creator<PersonParcelable> CREATOR = new Parcelable.Creator<PersonParcelable>() {
        public PersonParcelable createFromParcel(Parcel in) {
            PersonParcelable person = new PersonParcelable();
            person.readFromParcel(in);
            return person;
        }

        public PersonParcelable[] newArray(int size) {
            return new PersonParcelable[size];
        }
    };

    //...
}
