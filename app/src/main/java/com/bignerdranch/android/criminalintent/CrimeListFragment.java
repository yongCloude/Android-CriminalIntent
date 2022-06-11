package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CrimeListFragment extends Fragment {

    public static final String TAG = "CrimeListFragment";

    private CrimeListViewModel crimeListViewModel = CrimeListViewModel.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Total crimes: " + crimeListViewModel.getCrimes().size());
    }

    public static CrimeListFragment newInstance(){
        return new CrimeListFragment();
    }
}
