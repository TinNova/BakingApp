package com.example.tin.bakingapp.Models;

import org.parceler.Parcel;

/**
 * Created by Tin on 18/11/2017.
 */
@Parcel
public class TheIngredients {

    private int quantity;
    private String measure;
    private String ingredient;

    public TheIngredients() {
    }

    public TheIngredients(int quantity, String measure, String ingredient) {
        super();
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }


    public String getIngredient() {
        return ingredient;
    }

}

