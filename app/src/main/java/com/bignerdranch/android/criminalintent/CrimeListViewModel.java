package com.bignerdranch.android.criminalintent;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CrimeListViewModel extends ViewModel {
    private List<Crime> crimes = new ArrayList<>();

    private CrimeListViewModel() {
        for (int i = 0; i < 100; i++) {
            Crime crime = Crime.getInstance();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            crimes.add(crime);
        }
    }

    private static class LazyHolder {
        public static final CrimeListViewModel INSTANCE = new CrimeListViewModel();
    }

    public static CrimeListViewModel getInstance(){
        return LazyHolder.INSTANCE;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }
}
