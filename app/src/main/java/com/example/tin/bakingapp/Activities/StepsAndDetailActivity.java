package com.example.tin.bakingapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.tin.bakingapp.Fragments.DetailFragment;
import com.example.tin.bakingapp.Fragments.StepsFragment;
import com.example.tin.bakingapp.Models.TheIngredients;
import com.example.tin.bakingapp.Models.TheRecipe;
import com.example.tin.bakingapp.Models.TheSteps;
import com.example.tin.bakingapp.R;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class StepsAndDetailActivity extends AppCompatActivity {

    private static final String TAG = StepsAndDetailActivity.class.getSimpleName();

//    ArrayList<TheSteps> stepsList;
//    ArrayList<TheIngredients> ingredientsList;

//    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

    private ArrayList<TheRecipe> mTheRecipe;
    private ArrayList<TheIngredients> ingredients;
    private ArrayList<TheSteps> steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_and_detail);

        Intent intentThatStartedThisActivity = getIntent();

//        // Here we are taking the data passed in via the Intent from the MainActivity
//        stepsList = intentThatStartedThisActivity.getParcelableArrayListExtra("steps");
//        ingredientsList = intentThatStartedThisActivity.getParcelableArrayListExtra("ingredients");

        // Here we've taken the Extra containing the the "TheRecipe" Model and put it in the variable "mTheRecipe"
        if (intentThatStartedThisActivity.hasExtra("recipe")) {
            mTheRecipe = intentThatStartedThisActivity.getParcelableExtra("recipe");
            Log.v(TAG, "The Recipe inside mTheRecipe With Data" + mTheRecipe);
        } else {
            mTheRecipe = null;
            Log.v(TAG, "The Recipe inside mTheRecipe Null" + mTheRecipe);
        }
        // Here we are using a for loop to extract the "TheSteps" Model from mTheRecipe and we are
        // saving it in an ArrayList variable call "theStepsList"
//        ArrayList<Object> theStepsList = new ArrayList<>();
//        for (TheSteps theSteps : mTheRecipe.getSteps()) {
//            theStepsList.add(theSteps);
//
//            Log.v(TAG, "The steps list: " + theStepsList);
//        }

        //inflateStepsFragment();
        /** IF (ON MOBILE & THE MAIN ACTIVITY LAUNCHED THIS ACTIVITY) {
         *      Inflate the inflateStepsFragment
         *      }
         *      ELSE IF (ON TABLET & THE MAIN ACTIVITY LAUNCHED THIS ACTIVITY {
         *          Start the tablet version
         *          }
         */
    }

    /** REQUIRED METHOD,
     *      If user selects a step, we need to replace the stepsFragment with the
     *      detail fragment
     *      The if user presses UP button, they should return to the stepsFragment*/

//    // Ingredients & Steps Data Goes Into TheStepsFragment
//    private void inflateStepsFragment() {
//        // Creating a Bundle to hold the ingredientsList & stepsList
//        Bundle argsForIngredients_Steps = new Bundle();
//        argsForIngredients_Steps.putParcelableArrayList("argsForIngredients", ingredientsList);
//        argsForIngredients_Steps.putParcelableArrayList("argsForSteps", stepsList);
//
//        if (ingredientsList != null) {
//
//            // Initialise the StepsFragment
//            StepsFragment stepsFragment = new StepsFragment();
//            // Placing the Bundle Arguments into the stepsFragment
//            stepsFragment.setArguments(argsForIngredients_Steps);
//
//            // Start inflate the StepsFragment
//            fragmentManager.beginTransaction()
//                    .add(R.id.steps_container, stepsFragment)
//                    .commit();
//        }
//    }
//
//    /** IN MOBILE MODE THIS SHOULD ONLY BE INFLATED WHEN USER HAS CLICKED ON A STEP
//     * FURTHERMORE WHEN A USER CLICKS ON A STEP IT SHOULD REPLACE THE STEPSFRAGMENT?
//     */
//    private void inflateDetailFragment() {
//
//        DetailFragment detailFragment = new DetailFragment();
//
//        fragmentManager.beginTransaction()
//                .add(R.id.detail_container, detailFragment)
//                .commit();
//    }
}
