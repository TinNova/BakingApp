package com.example.tin.bakingapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.tin.bakingapp.Fragments.StepsFragment;
import com.example.tin.bakingapp.Models.TheIngredients;
import com.example.tin.bakingapp.Models.TheSteps;
import com.example.tin.bakingapp.R;

import java.util.ArrayList;

public class StepsAndIngredientsActivity extends AppCompatActivity {

    private static final String TAG = StepsAndIngredientsActivity.class.getSimpleName();

    public static String INGREDIENTS_BUNDLED = "argsForIngredients";
    public static String STEPS_BUNDLED = "argsForSteps";

    ArrayList<TheSteps> mTheSteps;
    ArrayList<TheIngredients> mTheIngredients;

    StepsFragment mStepsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_and_detail);

        Intent intentThatStartedThisActivity = getIntent();

        // Here we've taken the Extra containing the the "TheRecipe" Model and put it in the variable "mTheRecipe"
        mTheSteps = intentThatStartedThisActivity.getParcelableArrayListExtra("steps");
        mTheIngredients = intentThatStartedThisActivity.getParcelableArrayListExtra("ingredients");

        Log.v(TAG, "The Ingredients inside mTheIngredients: " + mTheIngredients);
        Log.v(TAG, "The Steps inside mTheSteps:" + mTheSteps);

        // Only create a new fragment if there is no previously saved state!
        if (savedInstanceState == null) {

            inflateStepsFragment();
        }
    }

    //inflateStepsFragment();
    /** IF (ON MOBILE & THE MAIN ACTIVITY LAUNCHED THIS ACTIVITY) {
     *      Inflate the inflateStepsFragment
     *      }
     *      ELSE IF (ON TABLET & THE MAIN ACTIVITY LAUNCHED THIS ACTIVITY {
     *          Start the tablet version
     *          }
     */


    /**
     * REQUIRED METHOD,
     * If user selects a step, we need to replace the stepsFragment with the
     * detail fragment
     * The if user presses UP button, they should return to the stepsFragment
     */

    // Ingredients & Steps Data Goes Into TheStepsFragment
    private void inflateStepsFragment() {
        // Creating a Bundle to hold the ingredientsList & stepsList
        Bundle argsForIngredientsSteps = new Bundle();
        argsForIngredientsSteps.putParcelableArrayList(INGREDIENTS_BUNDLED, mTheIngredients);
        argsForIngredientsSteps.putParcelableArrayList(STEPS_BUNDLED, mTheSteps);

        // If we have successfully passed the selected TheIngredient to this activity, begin the
        // transaction to start the StepsFragment
        if (mTheIngredients != null) {

            // Initialise the StepsFragment
            mStepsFragment = new StepsFragment();
            // Placing the Bundle Arguments into the stepsFragment
            mStepsFragment.setArguments(argsForIngredientsSteps);

            //fragmentManager = getSupportFragmentManager();
            // Start inflate the StepsFragment
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.steps_container, mStepsFragment)
                    .commit();
        } else {
            Toast.makeText(this, "Unable To Launch Fragment Transaction", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * IN MOBILE MODE THIS SHOULD ONLY BE INFLATED WHEN USER HAS CLICKED ON A STEP
     * FURTHERMORE WHEN A USER CLICKS ON A STEP IT SHOULD REPLACE THE STEPSFRAGMENT?
     */
//    private void inflateDetailFragment() {
//
//        DetailFragment detailFragment = new DetailFragment();
//
//        fragmentManager.beginTransaction()
//                .add(R.id.detail_container, detailFragment)
//                .commit();
//    }
}

