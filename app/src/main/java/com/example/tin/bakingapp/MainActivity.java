package com.example.tin.bakingapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.tin.bakingapp.Adapters.TheRecipeAdapter;
import com.example.tin.bakingapp.Models.TheRecipe;
import com.example.tin.bakingapp.NetworkUtils.NetworkAsyncTask;
import com.example.tin.bakingapp.NetworkUtils.NetworkAsyncTaskListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NetworkAsyncTaskListener, TheRecipeAdapter.ListItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    // Needed for the RecyclerView
    // This will be used to attach the RecyclerView to the MovieAdapter
    @BindView(R.id.recyclerView_cakes) RecyclerView mRecyclerView;
    private RecyclerView.Adapter recipeAdapter;

    // Used to check if the device has internet connection
    ConnectivityManager connectionManager;
    NetworkInfo networkInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /** Setting Up The RecyclerView to Display All of The Cakes/Pies In the App */
        // This will improve performance by stating that changes in the content will not change
        // the child layout size in the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        /*
         * A LayoutManager is responsible for measuring and positioning item views within a
         * RecyclerView as well as determining the policy for when to recycle item views that
         * are no longer visible to the user.
         */
        LinearLayoutManager mLinearLayoutManager =
                new LinearLayoutManager(this);
        // Set the mRecyclerView to the layoutManager so it can handle the positioning of the items
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        

        // Checking If The Device Is Connected To The Internet
        connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // If the connManager and networkInfo is NOT null, launch the AsyncTask
        if (connectionManager != null)
            networkInfo = connectionManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            NetworkAsyncTask getData = new NetworkAsyncTask((NetworkAsyncTaskListener) this);
            getData.execute();



        } else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
//            // Else if the connManager and networkInfo IS null, show a snakeBar informing the user
//            Snackbar snackbar = Snackbar.make(mNavigationView, getString(R.string.check_connection), Snackbar.LENGTH_LONG);
//            View snackBarView = snackbar.getView();
//            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
//            snackbar.show();
        }
    }

    @Override
    public void returnRecipeContent(ArrayList<TheRecipe> theRecipeContent) {
        recipeAdapter = new TheRecipeAdapter(theRecipeContent, getApplicationContext(), MainActivity.this);
        mRecyclerView.setAdapter(recipeAdapter);

        Log.d(TAG, "List of Recipes: " + theRecipeContent);

    }

    /** This Only Works If You Implement: implements TheRecipeAdapter.ListItemClickListener */
    @Override
    public void onListItemClick(int clickedItemIndex) {

        Log.v(TAG, "clikedItemIndex" + clickedItemIndex);
        //Toast.makeText(this, "ClickItemIndex: " + clickedItemIndex, Toast.LENGTH_SHORT).show();
    }
}
