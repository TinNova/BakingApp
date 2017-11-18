package com.example.tin.bakingapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TheRecipe implements Parcelable{

    private int id;
    private String name;
    private ArrayList<TheIngredients> ingredients = null;
    private ArrayList<TheSteps> steps = null;
    private int servings;
    private String image;


    public TheRecipe() {
    }

    public TheRecipe(int id, String name, ArrayList<TheIngredients> ingredients, ArrayList<TheSteps> steps, int servings, String image) {
        super();
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<TheIngredients> getIngredients() {
        return ingredients;
    }

    public ArrayList<TheSteps> getSteps() {
        return steps;
    }

    public int getServings() {
        return servings;
    }

    public String getImage() {
        return image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    // Code For Writing A Parcel
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeList(ingredients);
        parcel.writeList(steps);
        parcel.writeInt(servings);
        parcel.writeString(image);

    }

    // Code for Reading A Parcel
    public final static Parcelable.Creator<TheRecipe> CREATOR
            = new Creator<TheRecipe>() {

        public TheRecipe createFromParcel(Parcel in) {
            TheRecipe theRecipe = new TheRecipe();
            theRecipe.id = ((int) in.readValue((int.class.getClassLoader())));
            theRecipe.name = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(theRecipe.ingredients, (com.example.tin.bakingapp.Models.TheIngredients.class.getClassLoader()));
            in.readList(theRecipe.steps, (com.example.tin.bakingapp.Models.TheSteps.class.getClassLoader()));
            theRecipe.servings = ((int) in.readValue((int.class.getClassLoader())));
            theRecipe.image = ((String) in.readValue((String.class.getClassLoader())));
            return theRecipe;
        }

        public TheRecipe[] newArray(int size) {
            return (new TheRecipe[size]);
        }

    };
}

