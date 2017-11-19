package com.example.tin.bakingapp.Activities_Fragments;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tin.bakingapp.R;

public class StepsAndDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_and_detail);

        // Creating an instance of the RecipeStepsFragment
        // Effectively assigning it to this Activity
        RecipeStepsFragment stepsFragment = new RecipeStepsFragment();

        // Using a FragmentManager and a Transaction to add the fragment to the screen
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        // Fragment Transaction, it takes the steps_container and attaches it to the
        // stepsFragment we just created
        fragmentManager.beginTransaction()
                .add(R.id.steps_container, stepsFragment)
                .commit();
    }
}
