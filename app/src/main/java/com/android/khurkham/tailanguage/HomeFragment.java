package com.android.khurkham.tailanguage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setTitle("HomeFragment");
       // Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
       // Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setDisplayShowHomeEnabled(true);
       // Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setHomeButtonEnabled(true);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}