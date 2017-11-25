package com.example.tin.bakingapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tin.bakingapp.Activities.StepsAndDetailActivity;
import com.example.tin.bakingapp.Adapters.TheIngredientsAdapter;
import com.example.tin.bakingapp.Adapters.TheStepsAdapter;
import com.example.tin.bakingapp.Models.TheIngredients;
import com.example.tin.bakingapp.Models.TheSteps;
import com.example.tin.bakingapp.R;

import java.util.ArrayList;

import static android.widget.Toast.*;
import static java.lang.String.*;


/**
 * Created by Tin on 19/11/2017.
 */

public class StepsFragment extends Fragment implements TheStepsAdapter.TheStepsClickListener{

    private static final String TAG = StepsFragment.class.getSimpleName();

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
//
//    // This happens before the onCreateView happens
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//    }

    // Inflates the fragment layout and sets any image resources
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_steps, container, false);

        /** TODO
         * 1. OnCreateView we need to unBundle that was passed in
         * 2. We need to create an Adapter to create the RecyclerView
         * 3. We need to setup the tv's & iv's to hold the data */

        // Extracting the data from the Bundle
        Bundle getExtras = getArguments();
        mIngredients = new ArrayList<>();
        mSteps = new ArrayList<>();
        mIngredients = getExtras.getParcelableArrayList(StepsAndDetailActivity.INGREDIENTS_BUNDLED);
        mSteps = getExtras.getParcelableArrayList(StepsAndDetailActivity.STEPS_BUNDLED);


        ingredientsLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ingredientsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_ingredients);
        ingredientsRecyclerView.setHasFixedSize(true);
        ingredientsRecyclerView.setLayoutManager(ingredientsLayoutManager);
        mIngredientsAdapter = new TheIngredientsAdapter(mIngredients, getContext());
        ingredientsRecyclerView.setAdapter(mIngredientsAdapter);

        stepsLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        stepsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_steps);
        stepsRecyclerView.setHasFixedSize(true);
        stepsRecyclerView.setLayoutManager(stepsLayoutManager);
        mStepsAdapter = new TheStepsAdapter(mSteps, getContext(), StepsFragment.this);
        stepsRecyclerView.setAdapter(mStepsAdapter);

        return rootView;
    }

    @Override
    public void onClick(int position) {

        //Toast.makeText(this, "Position clicked on: " + mSteps.get(position), Toast.LENGTH_SHORT).show();
        Log.v(TAG, "Position Clicked On: " + mSteps.get(position));


    }
}
