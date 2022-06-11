package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CrimeListFragment extends Fragment {

    public static final String TAG = "CrimeListFragment";

    private CrimeListViewModel crimeListViewModel = CrimeListViewModel.getInstance();
    private RecyclerView crimeRecyclerView;

    private class CrimeHolder extends RecyclerView.ViewHolder{
        public CrimeHolder(@NonNull View view) {
            super(view);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Total crimes: " + crimeListViewModel.getCrimes().size());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        crimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
        crimeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public static CrimeListFragment newInstance(){
        return new CrimeListFragment();
    }
}
