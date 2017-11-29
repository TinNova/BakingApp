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

import static com.example.tin.bakingapp.Activities.StepsAndIngredientsActivity.TWO_PANE;


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
    boolean mTwoPane;

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

        // Extracting the Ingredients, Steps & TwoPane Boolean
        Bundle getExtras = getArguments();
        mIngredients = getExtras.getParcelableArrayList(StepsAndIngredientsActivity.INGREDIENTS_BUNDLED);
        mSteps = getExtras.getParcelableArrayList(StepsAndIngredientsActivity.STEPS_BUNDLED);
        mTwoPane = getExtras.getBoolean(TWO_PANE);

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
        // If the device has a minimum width of 600dp inflate the DetailFragment within the
        // StepsAndIngredientsActivity

        if (mTwoPane == true) {
            // Creating a Bundle to hold the ingredientsList & stepsList
            Bundle argsForCurrentStep = new Bundle();
            argsForCurrentStep.putParcelableArrayList(CURRENT_STEP, mSteps);
            argsForCurrentStep.putInt(CURRENT_POSITION, position);

            // Initialise the StepsFragment
            mDetailFragment = new DetailFragment();
            // Placing the Bundle Arguments into the stepsFragment
            mDetailFragment.setArguments(argsForCurrentStep);

            // Start inflate the StepsFragment (?Why can this be getFragmentManager, but in StepsAndIngredientsActivity it's getSupportFragmentManager?)
            getFragmentManager().beginTransaction()
                    .add(R.id.detail_container, mDetailFragment)
                    .commit();

            // Else launch an intent to the DetailActivity where the Fragment will be inflated
        } else {

            Intent i = new Intent(getContext(), DetailActivity.class);
            i.putParcelableArrayListExtra(CURRENT_STEP, mSteps);
            i.putExtra(CURRENT_POSITION, position);
            startActivity(i);
        }


        Log.v(TAG, "Position Clicked On: " + mSteps.get(position));
    }

}

//TODO: On App Rotation it runs the onCreateView more and more times, test it out with the LOG: "TheIngredients & TheSteps Taken From MainActivity Bundle"
