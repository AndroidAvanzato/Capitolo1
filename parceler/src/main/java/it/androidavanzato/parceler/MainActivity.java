package it.androidavanzato.parceler;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.parceler.Parcels;


public class MainActivity extends ActionBarActivity {

    public static final String PERSON_PARCELABLE = "person_parcelable";
    public static final String PERSON = "person";

    private PersonParcelable personParcelable;

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            personParcelable = new WorkerParcelable("name", "surname", new CompanyParcelable("company"));
            person = new Worker("name", "surname", new Company("company"));
        } else {
            personParcelable = savedInstanceState.getParcelable(PERSON_PARCELABLE);
            person = Parcels.unwrap(savedInstanceState.getParcelable(PERSON));
        }
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PERSON_PARCELABLE, personParcelable);
        outState.putParcelable(PERSON, Parcels.wrap(person));
    }
}
