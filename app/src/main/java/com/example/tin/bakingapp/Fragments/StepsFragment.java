package com.example.tin.bakingapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tin.bakingapp.Adapters.TheIngredientsAdapter;
import com.example.tin.bakingapp.Adapters.TheStepsAdapter;
import com.example.tin.bakingapp.Models.TheIngredients;
import com.example.tin.bakingapp.Models.TheSteps;
import com.example.tin.bakingapp.R;

import java.util.ArrayList;


/**
 * Created by Tin on 19/11/2017.
 */

public class StepsFragment extends Fragment {

    ArrayList<TheIngredients> mIngredients;
    ArrayList<TheSteps> mSteps;

    LinearLayoutManager stepsLayoutManager;
    LinearLayoutManager ingredientsLayoutManager;

    RecyclerView stepsRecyclerView;
    RecyclerView ingredientsRecyclerView;

    TheStepsAdapter mStepsAdapter;
    TheIngredientsAdapter mIngredientsAdapter;

    // Mandatory Constructor for initiating the fragment
    public StepsFragment(){

    }

    // Inflates the fragment layout and sets any image resources
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_steps, container, false);

        /** TODO
         * 1. OnCreateView we need to unBundle that was passed in
         * 2. We need to create an Adapter to create the RecyclerView
         * 3. We need to setup the tv's & iv's to hold the data */

        // Extracting the data from the Bundle
        Bundle extras = getArguments();
        mIngredients = new ArrayList<>();
        mSteps = new ArrayList<>();
//        mIngredients = extras.getParcelableArrayList("argsForIngredients");
//        mSteps = extras.getParcelableArrayList("argsForSteps");

        stepsLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ingredientsLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        stepsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_steps);
        stepsRecyclerView.setHasFixedSize(true);

        ingredientsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_ingredients);
        ingredientsRecyclerView.setHasFixedSize(true);

        //mIngredientsAdapter = new TheIngredientsAdapter(mIngredients, getContext());
        mStepsAdapter = new TheStepsAdapter(mSteps, getContext());


        return rootView;
    }
}
