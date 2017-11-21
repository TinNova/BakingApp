package com.example.tin.bakingapp.NetworkUtils;

import com.example.tin.bakingapp.Models.TheRecipe;

import java.util.ArrayList;

/**
 * Created by Tin on 18/11/2017.
 */

public interface NetworkAsyncTaskListener {
    void returnData(ArrayList<TheRecipe> theRecipeContent);

}
