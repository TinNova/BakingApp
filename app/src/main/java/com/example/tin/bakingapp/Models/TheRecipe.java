package com.example.tin.bakingapp.Models;


import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class TheRecipe {

    int id;
    String name;
    ArrayList ingredients;
    ArrayList steps;
    int servings;
    String image;

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

    // empty constructor needed by the Parceler library
    public TheRecipe() {
    }

    public TheRecipe(int id, String name, ArrayList ingredients, ArrayList steps, int servings, String image) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
        this.image = image;
    }

}
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import java.util.ArrayList;
//
//public class TheRecipe implements Parcelable {
//
//    private int id;
//    private String name;
//    private ArrayList ingredients = null;
//    private ArrayList steps = null;
//    private int servings;
//    private String image;
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public ArrayList<TheIngredients> getIngredients() {
//        return ingredients;
//    }
//
//    public ArrayList<TheSteps> getSteps() {
//        return steps;
//    }
//
//    public int getServings() {
//        return servings;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setIngredients(ArrayList<TheIngredients> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public void setSteps(ArrayList<TheSteps> steps) {
//        this.steps = steps;
//    }
//
//    public void setServings(int servings) {
//        this.servings = servings;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    @Override
//    public int describeContents() {
//        return hashCode();
//    }
//
//    // Code For Writing A Parcel
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(id);
//        parcel.writeString(name);
//        parcel.writeList(ingredients);
//        parcel.writeList(steps);
//        parcel.writeInt(servings);
//        parcel.writeString(image);
//
//    }
//
//    public TheRecipe(Parcel p) {
//        id = p.readInt();
//        name = p.readString();
//        ingredients = p.readArrayList(com.example.tin.bakingapp.Models.TheIngredients.class.getClassLoader());
//        steps = p.readArrayList(com.example.tin.bakingapp.Models.TheSteps.class.getClassLoader());
//        servings = p.readInt();
//        image = p.readString();
//    }
//
//
//    public TheRecipe(int recipeId, String recipeName, ArrayList<TheIngredients> ingredientList, ArrayList<TheSteps> stepsList, int recipeServings, String recipeImage) {
//    }
//
//    // We need to add a Creator
//    public final static Parcelable.Creator<TheRecipe> CREATOR = new Parcelable.Creator<TheRecipe>() {
//
//        @Override
//        public TheRecipe createFromParcel(Parcel parcel) {
//            return new TheRecipe(parcel);
//        }
//
//        @Override
//        public TheRecipe[] newArray(int size) {
//            return new TheRecipe[size];
//        }
//    };
//
//    @Override
//    public String toString() {
//        return "TheRecipe{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", ingredients=" + ingredients +
//                ", steps=" + steps +
//                ", servings=" + servings +
//                ", image=" + image +
//                '}';
//    }
//}