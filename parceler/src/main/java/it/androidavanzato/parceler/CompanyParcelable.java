package it.androidavanzato.parceler;

import android.os.Parcel;
import android.os.Parcelable;

public class CompanyParcelable implements Parcelable {

    private String name;

    private CompanyParcelable() {
    }

    public CompanyParcelable(String name) {
        this.name = name;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    public static final Parcelable.Creator<CompanyParcelable> CREATOR = new Parcelable.Creator<CompanyParcelable>() {
        public CompanyParcelable createFromParcel(Parcel in) {
            CompanyParcelable company = new CompanyParcelable();
            company.name = in.readString();
            return company;
        }

        public CompanyParcelable[] newArray(int size) {
            return new CompanyParcelable[size];
        }
    };

    //...
}
