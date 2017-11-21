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


    private TheRecipe() {
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
////
//package com.example.tin.bakingapp.Models;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import java.util.ArrayList;
//
//public class TheRecipe implements Parcelable {
//
//    private int id;
//    private String name;
//    private ArrayList<TheIngredients> ingredients;
//    private ArrayList<TheSteps> steps;
//    private int servings;
//    private String image;
//
//    public TheRecipe(Parcel in) {
//        id = in.readInt();
//        name = in.readString();
//        ingredients = in.createTypedArrayList(TheIngredients.CREATOR);
//        steps = in.createTypedArrayList(TheSteps.CREATOR);
//        servings = in.readInt();
//        image = in.readString();
//    }
//
//    public TheRecipe(int recipeId, String recipeName, ArrayList<TheIngredients> ingredientList, ArrayList<TheSteps> stepsList, int recipeServings, String recipeImage) {
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(id);
//        dest.writeString(name);
//        dest.writeTypedList(ingredients);
//        dest.writeTypedList(steps);
//        dest.writeInt(servings);
//        dest.writeString(image);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Creator<TheRecipe> CREATOR = new Creator<TheRecipe>() {
//        @Override
//        public TheRecipe createFromParcel(Parcel in) {
//            return new TheRecipe(in);
//        }
//
//        @Override
//        public TheRecipe[] newArray(int size) {
//            return new TheRecipe[size];
//        }
//    };
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public ArrayList<TheIngredients> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(ArrayList<TheIngredients> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public ArrayList<TheSteps> getSteps() {
//        return steps;
//    }
//
//    public void setSteps(ArrayList<TheSteps> steps) {
//        this.steps = steps;
//    }
//
//    public int getServings() {
//        return servings;
//    }
//
//    public void setServings(int servings) {
//        this.servings = servings;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
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
