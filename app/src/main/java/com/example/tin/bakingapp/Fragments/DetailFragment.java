package com.example.tin.bakingapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tin.bakingapp.Models.TheSteps;
import com.example.tin.bakingapp.R;

import java.util.ArrayList;

/**
 * Created by Tin on 20/11/2017.
 */

public class DetailFragment extends Fragment {

    ArrayList<TheSteps> mSteps;

    int mPosition;

    TextView tvStepDescription;

    // Mandatory Constructor for initiating the fragment
    public DetailFragment(){

    }

    // Inflates the fragment layout and sets any image resources
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        // Extracting the data from the Bundle
        Bundle getExtras = getArguments();
        mSteps = new ArrayList<>();
        mSteps = getExtras.getParcelableArrayList(StepsFragment.CURRENT_STEP);
        mPosition = getExtras.getInt(StepsFragment.CURRENT_POSITION);


        // Setting up the UI
        tvStepDescription = rootView.findViewById(R.id.step_description);
        tvStepDescription.setText(mSteps.get(mPosition).getDescription());

        return rootView;
    }
}
