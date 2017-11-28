package com.example.tin.bakingapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tin.bakingapp.Activities.DetailActivity;
import com.example.tin.bakingapp.Activities.StepsAndIngredientsActivity;
import com.example.tin.bakingapp.Adapters.TheIngredientsAdapter;
import com.example.tin.bakingapp.Adapters.TheStepsAdapter;
import com.example.tin.bakingapp.Models.TheIngredients;
import com.example.tin.bakingapp.Models.TheSteps;
import com.example.tin.bakingapp.R;

import java.util.ArrayList;


/**
 * Created by Tin on 19/11/2017.
 */

public class StepsFragment extends Fragment implements TheStepsAdapter.TheStepsClickListener {

    private static final String TAG = StepsFragment.class.getSimpleName();

    private static final String INGREDIENTS_KEY = "ingredients_key";
    private static final String STEPS_KEY = "steps_key";


    public static String CURRENT_STEP = "current_step";
    public static String CURRENT_POSITION = "current_position";

    ArrayList<TheIngredients> mIngredients;
    ArrayList<TheSteps> mSteps;

    LinearLayoutManager stepsLayoutManager;
    LinearLayoutManager ingredientsLayoutManager;

    RecyclerView stepsRecyclerView;
    RecyclerView ingredientsRecyclerView;

    TheStepsAdapter mStepsAdapter;
    TheIngredientsAdapter mIngredientsAdapter;

    DetailFragment mDetailFragment;

    // Mandatory Constructor for initiating the fragment
    public StepsFragment() {
    }


//    // This happens before the onCreateView happens
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    // Inflates the fragment layout and sets any image resources
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_steps, container, false);

        mIngredients = new ArrayList<>();
        mSteps = new ArrayList<>();

        Bundle getExtras = getArguments();
        mIngredients = getExtras.getParcelableArrayList(StepsAndIngredientsActivity.INGREDIENTS_BUNDLED);
        mSteps = getExtras.getParcelableArrayList(StepsAndIngredientsActivity.STEPS_BUNDLED);

        Log.v(TAG, "TheIngredients & TheSteps Taken From MainActivity Bundle");

        // Setting up the LayoutManager, RecyclerView, and Adapter
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
    public void onClick(int position, TheSteps theStepsModel) {

        //TODO: The commented out code could be used to launch the fragment when in tablet mode
        // Try starting the DetailFragment FragmentTransaction directly inside this method
        // if it fails, Try sending the data to the StepsAndIngredientsActivity then starting the DetailFragment FragmentTransaction from there

//        // Creating a Bundle to hold the ingredientsList & stepsList
//        Bundle argsForCurrentStep = new Bundle();
//        argsForCurrentStep.putParcelableArrayList(CURRENT_STEP, mSteps);
//        argsForCurrentStep.putInt(CURRENT_POSITION, position);
//
//        // Initialise the StepsFragment
//        mDetailFragment = new DetailFragment();
//        // Placing the Bundle Arguments into the stepsFragment
//        mDetailFragment.setArguments(argsForCurrentStep);
//
//        // Start inflate the StepsFragment (?Why can this be getFragmentManager, but in StepsAndIngredientsActivity it's getSupportFragmentManager?)
//        getFragmentManager().beginTransaction()
//                .add(R.id.detail_container, mDetailFragment)
//                .commit();

        Intent i = new Intent(getContext(), DetailActivity.class);
        i.putParcelableArrayListExtra(CURRENT_STEP, mSteps);
        i.putExtra(CURRENT_POSITION, position);
        startActivity(i);


        Log.v(TAG, "Position Clicked On: " + mSteps.get(position));
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        // Saving TheIngredients & TheSteps to be reused should the device rotate or return to this activity
//        outState.putParcelableArrayList(INGREDIENTS_KEY, mIngredients);
//        outState.putParcelableArrayList(STEPS_KEY, mSteps);
//        super.onSaveInstanceState(outState);
//    }
}

//TODO: On App Rotation it runs the onCreateView more and more times, test it out with the LOG: "TheIngredients & TheSteps Taken From MainActivity Bundle"
