package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CrimeListFragment extends Fragment {

    public static final String TAG = "CrimeListFragment";

    private CrimeListViewModel crimeListViewModel = CrimeListViewModel.getInstance();
    private RecyclerView crimeRecyclerView;
    private CrimeAdapter adapter;

    private class CrimeHolder extends RecyclerView.ViewHolder{

        private TextView titleTextView;
        private TextView dateTextView;

        public CrimeHolder(@NonNull View view) {
            super(view);
            titleTextView = itemView.findViewById(R.id.crime_title);
            dateTextView = itemView.findViewById(R.id.crime_date);
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> crimes;

        public CrimeAdapter(List<Crime> crimes) {
            this.crimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.list_item_crime, parent, false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = crimes.get(position);
            holder.titleTextView.setText(crime.getTitle());
            holder.dateTextView.setText(crime.getDate().toString());
        }

        @Override
        public int getItemCount() {
            return crimeListViewModel.getCrimes().size();
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

        updateUI();
        return view;
    }

    public static CrimeListFragment newInstance(){
        return new CrimeListFragment();
    }

    private void updateUI(){
        List<Crime> crimes = crimeListViewModel.getCrimes();
        adapter = new CrimeAdapter(crimes);
        crimeRecyclerView.setAdapter(adapter);

    }
}
