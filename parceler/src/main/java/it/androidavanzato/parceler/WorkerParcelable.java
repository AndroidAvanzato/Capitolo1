package it.androidavanzato.parceler;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fabiocollini on 30/08/14.
 */
public class WorkerParcelable extends PersonParcelable {
    private CompanyParcelable company;

    public WorkerParcelable() {
        super();
    }

    public WorkerParcelable(String name, String surname, CompanyParcelable company) {
        super(name, surname);
        this.company = company;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(company, 0);
    }

    @Override protected void readFromParcel(Parcel in) {
        super.readFromParcel(in);
        company = in.readParcelable(((Object) this).getClass().getClassLoader());
    }

    public static final Parcelable.Creator<WorkerParcelable> CREATOR = new Parcelable.Creator<WorkerParcelable>() {
        public WorkerParcelable createFromParcel(Parcel in) {
            WorkerParcelable worker = new WorkerParcelable();
            worker.readFromParcel(in);
            return worker;
        }

        public WorkerParcelable[] newArray(int size) {
            return new WorkerParcelable[size];
        }
    };
}
